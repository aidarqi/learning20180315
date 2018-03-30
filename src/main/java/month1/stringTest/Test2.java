package month1.stringTest;

/**
 * @author aidar
 * @desc 在定义变量的时候赋值，如果赋值的是静态的字符串，就会执行进入字符串池的操作，如果池中含有该字符串，则返回引用。
 * @date 18-3-19
 */
public class Test2 {
    public static void main(String[] args) {
        String a = "abc";
        String b = "abc";
        String c = "a" + "b" + "c";
        String d = "a" + "bc";
        String e = "ab" + "c";

        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(a == d);
        System.out.println(a == e);
        System.out.println(c == d);
        System.out.println(c == e);
    }
}
