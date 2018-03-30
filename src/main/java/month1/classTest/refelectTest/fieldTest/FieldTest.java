package month1.classTest.refelectTest.fieldTest;

import java.lang.reflect.Field;

/**
 * @author aidar
 * @desc  通过Class对象可以获取某个类中的：构造方法、成员变量、成员方法；并访问成员；
 *        2.获取成员变量并调用：
 *              1).批量的方法：
 *              public Field[] getFields()：所有"公有的"字段
 *              public Field[] getDeclaredFields()：获取所有的字段(包括私有、受保护、默认、公有)
 *              2).获取单个的：
 *              public Field getField(String name):获取单个的"公有的"字段：
 *              public Field getDeclaredField(String name):获取"某个字段"可以是私有的，或受保护、默认、公有；
 *              设置字段的值：
 *              Field --> public void set(Object obj, Object value): obj为要设置字段所在的对象,value为要为字段设置的值
 * @date 18-3-21
 */
public class FieldTest {

    public static void main(String[] args) throws Exception {
         Class clazz = Class.forName("month1.classTest.refelectTest.fieldTest.StudentField");
        System.out.println("*****************获取所有的公有字段*****************");
        Field[] fields = clazz.getFields();
        for (Field f : fields) {
            System.out.println(f);
        }
        System.out.println("*****************获取所有字段(包括私有,受保护,默认)*****************");
        fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            System.out.println(f);
        }
        System.out.println("*****************获取公有字段并调用*****************");
        Field f = clazz.getField("name");
        System.out.println(f);
        Object obj = clazz.getConstructor().newInstance();
        f.set(obj, "刘德华");
        System.out.println("验证姓名: " + ((StudentField)obj).name);

        System.out.println("*****************获取私有字段并调用*****************");
        f = clazz.getDeclaredField("phoneNum");
        System.out.println(f);
        f.setAccessible(true);
        f.set(obj, "18352534196");
        System.out.println("验证电话: " + (StudentField)obj);

    }
}
