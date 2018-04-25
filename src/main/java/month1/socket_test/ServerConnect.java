package month1.socket_test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @author aidar
 * @desc
 * @date 18-4-11
 */
public class ServerConnect {
    private static final int BUF_SIZE=1024;
    private static final int PORT = 8080;
    private static final int TIMEOUT = 3000;
    public static void main(String[] args)
    {
        selector();
    }
    public static void handleAccept(SelectionKey key) throws IOException {
        //从SelectionKey访问Channel
        ServerSocketChannel ssChannel = (ServerSocketChannel)key.channel();
        SocketChannel sc = ssChannel.accept();
        sc.configureBlocking(false);
        //还可以在用register()方法向Selector注册Channel的时候附加对象
        sc.register(key.selector(), SelectionKey.OP_READ, ByteBuffer.allocateDirect(BUF_SIZE));
    }
    public static void handleRead(SelectionKey key) throws IOException{
        SocketChannel sc = (SocketChannel)key.channel();
        //可以将一个对象或者更多信息附着到SelectionKey上，这样就能方便的识别某个给定的通道。例如，可以附加与通道一起使用的Buffer，或是包含聚集数据的某个对象
        ByteBuffer buf = (ByteBuffer)key.attachment();
        long bytesRead = sc.read(buf);
        while(bytesRead>0){
            buf.flip();
            while(buf.hasRemaining()){
                System.out.print((char)buf.get());
            }
            System.out.println();
            buf.clear();
            bytesRead = sc.read(buf);
        }
        if(bytesRead == -1){
            sc.close();
        }
    }
    public static void handleWrite(SelectionKey key) throws IOException{
        ByteBuffer buf = (ByteBuffer)key.attachment();
        buf.flip();
        SocketChannel sc = (SocketChannel) key.channel();
        while(buf.hasRemaining()){
            sc.write(buf);
        }
        buf.compact();
    }
    public static void selector() {
        Selector selector = null;
        ServerSocketChannel ssc = null;
        try{
            //创建一个Selector实例（使用静态工厂方法open()）
            selector = Selector.open();
            ssc= ServerSocketChannel.open();
            ssc.socket().bind(new InetSocketAddress(PORT));
            //与Selector一起使用时，Channel必须处于非阻塞模式下。
            // 这意味着不能将FileChannel与Selector一起使用，因为FileChannel不能切换到非阻塞模式。而套接字通道都可以
            ssc.configureBlocking(false);
            //将Selector实例注册（register）到想要监控的信道上
            //将Channel注册到Selector上
            //当向Selector注册Channel时，Channel.register()方法会返回一个SelectionKey 对象。这个对象代表了注册到该Selector的通道
            ssc.register(selector, SelectionKey.OP_ACCEPT);
            while(true){
                //调用选择器的select()方法。该方法会阻塞等待，直到有一个或更多的信道准备好了I/O操作或等待超时
                //select()方法将返回可进行I/O操作的信道数量
                //如果经过一段时间后仍然没有信道准备好，select()方法就会返回0，并允许程序继续执行其他任务
                //select()方法返回的int值表示有多少通道已经就绪。亦即，自上次调用select()方法后有多少通道变成就绪状态。
                // 如果调用select()方法，因为有一个通道变成就绪状态，返回了1，若再次调用select()方法，如果另一个通道就绪了，它会再次返回1。
                // 如果对第一个就绪的channel没有做任何操作，现在就有两个就绪的通道，但在每次select()方法调用之间，只有一个通道就绪了
                if(selector.select(TIMEOUT) == 0){
                    System.out.println("==");
                    continue;
                }
                //通过调用selector的selectedKeys()方法，访问“已选择键集（selected key set）”中的就绪通道
                Iterator<SelectionKey> iter = selector.selectedKeys().iterator();
                while(iter.hasNext()){
                    SelectionKey key = iter.next();
                    if(key.isAcceptable()){
                        handleAccept(key);
                    }
                    if(key.isReadable()){
                        handleRead(key);
                    }
                    if(key.isWritable() && key.isValid()){
                        handleWrite(key);
                    }
                    if(key.isConnectable()){
                        System.out.println("isConnectable = true");
                    }
                    //Selector不会自己从已选择键集中移除SelectionKey实例。必须在处理完通道时自己移除。下次该通道变成就绪时，Selector会再次将其放入已选择键集中
                    iter.remove();
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                if(selector!=null){
                    selector.close();
                }
                if(ssc!=null){
                    ssc.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
