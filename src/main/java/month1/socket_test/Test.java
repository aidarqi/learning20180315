package month1.socket_test;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.TimeUnit;

/**
 * @author aidar
 * @desc
 * @date 18-4-11
 */
public class Test {

    public static void method1(){
        RandomAccessFile aFile = null;
        try{
            aFile = new RandomAccessFile("src/nio.txt","rw");
            FileChannel fileChannel = aFile.getChannel();
            ByteBuffer buf = ByteBuffer.allocate(1024);
            //写入数据到Buffer
            int bytesRead = fileChannel.read(buf);
            System.out.println(bytesRead);
            while(bytesRead != -1)
            {
                buf.flip();
                while(buf.hasRemaining())
                {
                    //从Buffer中读取数据
                    System.out.print((char)buf.get());
                }
                buf.compact();
                bytesRead = fileChannel.read(buf);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            try{
                if(aFile != null){
                    aFile.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public static void method2() {
        InputStream in = null;
        try {
            in = new BufferedInputStream(new FileInputStream("src/nomal_io.txt"));
            byte[] buf = new byte[1024];
            int bytesRead = in.read(buf);
            while (bytesRead != -1) {
                for (int i = 0; i < bytesRead; i++)
                    System.out.print((char) buf[i]);
                bytesRead = in.read(buf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * FileChannel提供了map方法来把文件影射为内存映像文件： MappedByteBuffer map(int mode,long position,long size); 可以把文件的从position开始的size大小的区域映射为内存映像文件，mode指出了 可访问该内存映像文件的方式：

     READ_ONLY,（只读）： 试图修改得到的缓冲区将导致抛出 ReadOnlyBufferException.(MapMode.READ_ONLY)

     READ_WRITE（读/写）： 对得到的缓冲区的更改最终将传播到文件；该更改对映射到同一文件的其他程序不一定是可见的。 (MapMode.READ_WRITE)

     PRIVATE（专用）： 对得到的缓冲区的更改不会传播到文件，并且该更改对映射到同一文件的其他程序也不是可见的；相反，会创建缓冲区已修改部分的专用副本。 (MapMode.PRIVATE)

     MappedByteBuffer是ByteBuffer的子类，其扩充了三个方法：

     force()：缓冲区是READ_WRITE模式下，此方法对缓冲区内容的修改强行写入文件；

     load()：将缓冲区的内容载入内存，并返回该缓冲区的引用；

     isLoaded()：如果缓冲区的内容在物理内存中，则返回真，否则返回假；
     */
    public static void method3(){
        RandomAccessFile aFile = null;
        FileChannel fc = null;
        try{
            aFile = new RandomAccessFile("src/1.ppt","rw");
            fc = aFile.getChannel();
            long timeBegin = System.currentTimeMillis();
            MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_ONLY, 0, aFile.length());
            // System.out.println((char)mbb.get((int)(aFile.length()/2-1)));
            // System.out.println((char)mbb.get((int)(aFile.length()/2)));
            //System.out.println((char)mbb.get((int)(aFile.length()/2)+1));
            long timeEnd = System.currentTimeMillis();
            System.out.println("Read time: "+(timeEnd-timeBegin)+"ms");
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                if(aFile!=null){
                    aFile.close();
                }
                if(fc!=null){
                    fc.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    public static void method4(){
        RandomAccessFile aFile = null;
        FileChannel fc = null;
        try{
            aFile = new RandomAccessFile("src/1.ppt","rw");
            fc = aFile.getChannel();
            long timeBegin = System.currentTimeMillis();
            ByteBuffer buff = ByteBuffer.allocate((int) aFile.length());
            buff.clear();
            fc.read(buff);
            //System.out.println((char)buff.get((int)(aFile.length()/2-1)));
            //System.out.println((char)buff.get((int)(aFile.length()/2)));
            //System.out.println((char)buff.get((int)(aFile.length()/2)+1));
            long timeEnd = System.currentTimeMillis();
            System.out.println("Read time: "+(timeEnd-timeBegin)+"ms");
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                if(aFile!=null){
                    aFile.close();
                }
                if(fc!=null){
                    fc.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    /**
     * 采用NIO实现
     */
    public static void client(){
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        SocketChannel socketChannel = null;
        try
        {
            socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
            socketChannel.connect(new InetSocketAddress("10.10.195.115",8080));
            if(socketChannel.finishConnect())
            {
                int i=0;
                while(true)
                {
                    TimeUnit.SECONDS.sleep(1);
                    String info = "I'm "+i+++"-th information from client";
                    buffer.clear();
                    buffer.put(info.getBytes());
                    buffer.flip();
                    while(buffer.hasRemaining()){
                        System.out.println(buffer);
                        socketChannel.write(buffer);
                    }
                }
            }
        }
        catch (IOException | InterruptedException e)
        {
            e.printStackTrace();
        }
        finally{
            try{
                if(socketChannel!=null){
                    socketChannel.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    /**
     * 采用BIO实现
     */
    public static void server(){
        ServerSocket serverSocket = null;
        InputStream in = null;
        try
        {
            serverSocket = new ServerSocket(8080);
            int recvMsgSize = 0;
            byte[] recvBuf = new byte[1024];
            while(true){
                Socket clntSocket = serverSocket.accept();
                SocketAddress clientAddress = clntSocket.getRemoteSocketAddress();
                System.out.println("Handling client at "+clientAddress);
                in = clntSocket.getInputStream();
                while((recvMsgSize=in.read(recvBuf))!=-1){
                    byte[] temp = new byte[recvMsgSize];
                    System.arraycopy(recvBuf, 0, temp, 0, recvMsgSize);
                    System.out.println(new String(temp));
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally{
            try{
                if(serverSocket!=null){
                    serverSocket.close();
                }
                if(in!=null){
                    in.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}