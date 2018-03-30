package month1.classTest.refelectTest.mainTest;

import java.lang.reflect.Method;

/**
 * @author aidar
 * @desc
 * @date 18-3-21
 */
public class MainTest {
    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("month1.classTest.refelectTest.mainTest.StudentMain");
        Method main = clazz.getMethod("main", String[].class);
        main.invoke(null, (Object)new String[]{"a", "b", "c"});
    }
}
