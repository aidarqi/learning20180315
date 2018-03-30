package month1.stringTest;

/**
 * @author aidar
 * @desc 通过b.intern() == d和b.intern() == f可知，字符串相加的时候，都是静态字符串的结果会添加到字符串池，如果其中含有变量（如f中的e）则不会进入字符串池中。
 * @date 18-3-19
 */
public class Test3 {
    public static void main(String[] args) {
        String a = new String("ab");
        String b = new String("ab");
        String c = "ab";
        String d = "a" + "b";
        String e = "b";
        String f = "a" + e;

        System.out.println(b.intern() == a);
        System.out.println(b.intern() == c);
        System.out.println(b.intern() == d);
        System.out.println(f);
        System.out.println(b.intern() == f);
        System.out.println(b.intern() == a.intern());
    }
}
