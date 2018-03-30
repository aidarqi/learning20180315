package month1.exceptionTest;

/**
 * @author aidar
 * @version 0.0.1
 * @desc
 * @date 18-3-15
 */
public class Test1 {

    static int c = 0;

    public static void  divide1(int a, int b) {
        try
        {
            // 这块代码出现了异常
            c = a / b;

            // 那么异常之后的代码都不会被执行
            System.out.println("Hello World");
        }
        catch (ArithmeticException e)
        {
            e.printStackTrace();//打印异常信息
        }
        finally
        {
            //不管有没有发生异常，finally语句块都会被执行
            System.out.println("finally");
        }

        System.out.println(c);
        // 当b为0时，有异常，输出为c的初始值0
    }

    static void divide2(int a, int b) throws Exception{
        c = a/b;
    }

    static void divide3(int a, int b) throws Exception {
        if (b == 0) {
           throw new Exception();
        }
    }

    public static void main(String[] args) {
//        divide1(1,0);
//        try {
//            divide2(1,0);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        divide2(1,0);
        try {
            divide3(1,0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Number n = 0;
        System.out.println(n.getClass());
        Class<? extends Number> c = n.getClass();
        System.out.println(c);
    }
}
