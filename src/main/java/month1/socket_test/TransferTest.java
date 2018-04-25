package month1.socket_test;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * @author aidar
 * @desc
 * @date 18-4-11
 */
public class TransferTest {

    /**
     * 方法的输入参数position表示从position处开始向目标文件写入数据，count表示最多传输的字节数。
     * 如果源通道的剩余空间小于 count 个字节，则所传输的字节数要小于请求的字节数。
     * 此外要注意，在SoketChannel的实现中，SocketChannel只会传输此刻准备好的数据（可能不足count字节）。
     * 因此，SocketChannel可能不会将请求的所有数据(count个字节)全部传输到FileChannel中。
     */
    public static void method1(){
        RandomAccessFile fromFile = null;
        RandomAccessFile toFile = null;
        try
        {
            fromFile = new RandomAccessFile("src/fromFile.xml","rw");
            FileChannel fromChannel = fromFile.getChannel();
            toFile = new RandomAccessFile("src/toFile.txt","rw");
            FileChannel toChannel = toFile.getChannel();
            long position = 0;
            long count = fromChannel.size();
            System.out.println(count);
            toChannel.transferFrom(fromChannel, position, count);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally{
            try{
                if(fromFile != null){
                    fromFile.close();
                }
                if(toFile != null){
                    toFile.close();
                }
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    /**
     * 上面所说的关于SocketChannel的问题在transferTo()方法中同样存在。
     */
    public static void method2()
    {
        RandomAccessFile fromFile = null;
        RandomAccessFile toFile = null;
        try
        {
            fromFile = new RandomAccessFile("src/fromFile.txt","rw");
            FileChannel fromChannel = fromFile.getChannel();
            toFile = new RandomAccessFile("src/toFile.txt","rw");
            FileChannel toChannel = toFile.getChannel();
            long position = 0;
            long count = fromChannel.size();
            System.out.println(count);
            fromChannel.transferTo(position, count,toChannel);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally{
            try{
                if(fromFile != null){
                    fromFile.close();
                }
                if(toFile != null){
                    toFile.close();
                }
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
