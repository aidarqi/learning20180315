package month1.classTest.refelectTest.methodTest;

import java.lang.reflect.Method;

/**
 * @author aidar
 * @desc  通过Class对象可以获取某个类中的：构造方法、成员变量、成员方法；并访问成员；
 *        2.获取成员变量并调用：
 *              1).批量的方法：
 *              public Method[] getMethods()：获取所有"公有方法"；（包含了父类的方法也包含Object类）
 *              public Method[] getDeclaredMethods():获取所有的成员方法，包括私有的(不包括继承的)
 *              2).获取单个的：
 *              public Method getMethod(String name,Class<?>... parameterTypes): name为方法名,Class ...:形参的Class类型对象
 *              public Method getDeclaredMethod(String name,Class<?>... parameterTypes)
 *              设置字段的值：
 *              Method --> public Object invoke(Object obj,Object... args): obj为要调用方法的对象,args调用方法时所传递的实参
 * @date 18-3-21
 */
public class MethodTest {

    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("month1.classTest.refelectTest.methodTest.StudentMethod");
        System.out.println("****************获取所有的'公有'方法*******************");
        Method[] methods = clazz.getMethods();
        for (Method m : methods) {
            System.out.println(m);
        }
        System.out.println("****************获取所有的方法,包括私有的*******************");
        methods = clazz.getDeclaredMethods();
        for (Method m : methods) {
            System.out.println(m);
        }
        System.out.println("****************获取公有的show1()方法*******************");
        Method m = clazz.getMethod("show1", String.class);
        System.out.println(m);
        Object obj = clazz.getConstructor().newInstance();
        m.invoke(obj, "刘德华");

        System.out.println("****************获取私有的show4()方法*******************");
        m = clazz.getDeclaredMethod("show4", int.class);
        System.out.println(m);
        m.setAccessible(true);
        Object result = m.invoke(obj, 20);
        System.out.println("返回值: " + result);
    }
}
