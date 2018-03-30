package month1.concurrency_collection_test;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author aidar
 * @desc
 * @date 18-3-26
 */
public class Test {
    public static Unsafe getUnsafe() {
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            return (Unsafe)f.get(null);
        } catch (Exception e) {
       /* ... */
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(getUnsafe());
    }
}
