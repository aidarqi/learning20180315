package month2.synchronized_test;

/**
 * @author aidar
 * @desc
 * @date 18-4-23
 */
public class Test1 {
    public synchronized void doSth() {
        System.out.println("Hello Wprld");
    }

    public void doSth1() {
        synchronized (Test1.class) {
            System.out.println("Hello World");
        }
    }
}
