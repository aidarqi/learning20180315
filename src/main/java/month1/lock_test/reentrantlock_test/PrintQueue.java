package month1.lock_test.reentrantlock_test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author aidar
 * @desc
 * @date 18-3-29
 */
public class PrintQueue {
    private final Lock queueLock = new ReentrantLock();

    public void printJob(Object document) {
        try {
            queueLock.lock();
            Long duration = (long)(Math.random() * 10);
            System.out.println(Thread.currentThread().getName() + ": PrintQueue: Printing a Job during " + duration);
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            queueLock.unlock();
        }
    }
}
