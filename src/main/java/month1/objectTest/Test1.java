package month1.objectTest;

/**
 * @author aidar
 * @desc
 * @date 18-3-15
 */
public class Test1 {
    public static void main(String[] args) {
        int a = 1;
        int b = 1;
        String str1 = "hello";
        String str2 = "hello";
        String str3 = "hell" + "0";
        User user1 = new User();
        User user2 = new User();
        System.out.println(str1.equals(str2));
        System.out.println(str1.equals("hello"));
        System.out.println(str1.equals(str3));
        System.out.println(str1 == str2);
        System.out.println(str1 == "hello");
        System.out.println(str1 == str3);
        System.out.println(user1.equals(user2));
        System.out.println(user1 == user2);
    }
}
