package month1.classTest.refelectTest.delegatingTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author aidar
 * @desc
 * @date 18-3-22
 */
public class Test1 {
    public static void main(String[] args) {
        Proxy proxy = new Proxy();
        try {
            Method method = Proxy.class.getDeclaredMethod("run");
            try {
                method.invoke(proxy);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    static class Proxy {
        public void run() {
            System.out.println("run");
        }
    }
}
