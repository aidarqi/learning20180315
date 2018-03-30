package month1.lock_test.semaphore_test;

import java.util.concurrent.Semaphore;

/**
 * @author aidar
 * @desc
 * @date 18-3-30
 */
public class PrintQueue {
    private final Semaphore semaphore;

    public PrintQueue() {
        semaphore = new Semaphore(1);
    }

    public void printJob(Object document) {
        try {
            semaphore.acquire();//调用acquire获取信号量
            long duration = (long)(Math.random() * 10);
            System.out.println(Thread.currentThread().getName() + "PrintQueue: Printing a job during " + duration);
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();//释放信号量
        }
    }
 }
