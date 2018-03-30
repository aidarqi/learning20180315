package month1.stringTest;

import java.util.Arrays;

/**
 * @author aidar
 * @desc
 * @date 18-3-16
 */
public class Test1 {
    public static void main(String[] args) {
        String str = "a";
        String str1 = new String("a");
        String str2 = "a";
        String str3 = new String("a");

        System.out.println(str == str1);
        System.out.println(str.equals(str1));
        System.out.println(str.intern());
        System.out.println(str1.intern());
        System.out.println(str == str1.intern());
        System.out.println(str.equals(str1.intern()));
        System.out.println(str2 == str);
        System.out.println(str2.equals(str));
        System.out.println(str3 == str1.intern());
        System.out.println(str3.equals(str1.intern()));

//        char[] chars = {'a','b','c'};
//        int len = chars.length;
//        int otherLen = str.length();
//        char buf[] = Arrays.copyOf(chars, len + otherLen);
//        System.arraycopy(chars, 0, buf, len, len);
//        System.out.println(new String(buf));
//        str.intern();
//
//        System.out.println(str.concat(str2));

    }
}
