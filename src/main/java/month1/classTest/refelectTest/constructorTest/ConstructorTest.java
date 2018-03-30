package month1.classTest.refelectTest.constructorTest;

import java.lang.reflect.Constructor;

/**
 * @author aidar
 * @desc  * 通过Class对象可以获取某个类中的：构造方法、成员变量、成员方法；并访问成员；
 *        1.获取构造方法：
 *              1).批量的方法：
 *              public Constructor[] getConstructors()：所有"公有的"构造方法
 *              public Constructor[] getDeclaredConstructors()：获取所有的构造方法(包括私有、受保护、默认、公有)
 *              2).获取单个的方法，并调用：
 *              public Constructor getConstructor(Class... parameterTypes):获取单个的"公有的"构造方法：
 *              public Constructor getDeclaredConstructor(Class... parameterTypes):获取"某个构造方法"可以是私有的，或受保护、默认、公有；
 *              调用构造方法：
 *              Constructor-->newInstance(Object... initargs)
 * @date 18-3-21
 */
public class ConstructorTest {
    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName(
            "month1.classTest.refelectTest.constructorTest.StudentConstructor");

        //获取所有公有构造方法
        System.out.println("*******************所有公有构造方法********************");
        Constructor[] conArray = clazz.getConstructors();
        for (Constructor c : conArray) {
            System.out.println(c);
        }

        System.out.println("*******************所有的构造方法(包括:私有,受保护,默认,公有)********************");
        conArray = clazz.getDeclaredConstructors();
        for (Constructor c : conArray) {
            System.out.println(c);
        }

        System.out.println("*******************获取公有,无参的构造方法********************");
        Constructor con = clazz.getConstructor(null);
        System.out.println("con = " + con);
        Object obj = con.newInstance();
        System.out.println(obj.getClass().getName());

        System.out.println("*******************获取公有,String参数的构造方法********************");
        Constructor con1 = clazz.getConstructor(java.lang.String.class);
        System.out.println("con1 = " + con1);

        System.out.println("*******************获取私有构造方法,并调用********************");
        con = clazz.getDeclaredConstructor(int.class);
        System.out.println(con);
        //调用构造方法,并且忽略掉修饰符,暴力访问
        con.setAccessible(true);
        obj = con.newInstance(25);
    }
}
