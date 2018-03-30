package month1.classTest.refelectTest.getClassTest;

import month1.classTest.refelectTest.constructorTest.StudentConstructor;

/**
 * @author aidar
 * @desc  获取Class对象的三种方式
 *        1 Object ——> getClass();
 *        2 任何数据类型（包括基本数据类型）都有一个“静态”的class属性
 *        3 通过Class类的静态方法：forName（String  className）(常用)
 * @date 18-3-21
 */
public class GetStudentClassTest {
    public static void main(String[] args) {
        //第一种,对象都有了还要反射做什么
        StudentConstructor student = new StudentConstructor();
        Class stuClass = student.getClass();
        System.out.println(stuClass.getName() + " " + stuClass.getClassLoader());

        //第二种,需要导入类的包,依赖太强
        Class stuClass2 = StudentConstructor.class;
        System.out.println(stuClass2.getName() + " " + stuClass2.getClassLoader());
        System.out.println(stuClass == stuClass2);

        //第三种
        try {
            Class stuClass3 = Class.forName(
                "month1.classTest.refelectTest.constructorTest.StudentConstructor");
            System.out.println(stuClass3.getName() + " " + stuClass3.getClassLoader());
            System.out.println(stuClass3 == stuClass2);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
