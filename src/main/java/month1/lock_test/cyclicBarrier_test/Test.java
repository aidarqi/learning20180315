package month1.lock_test.cyclicBarrier_test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author aidar
 * @desc 由于CyclicBarrier的存在,导致线程池中的active thread在执行完任务后不会消亡,此时线程池中的活跃线程等同于任务始终没有完成,那么线程池中的BlockingQueue中的剩余任务将始终处于阻塞状态,
 *       所以在执行完第八个任务结束后便不在执行了
 *       因为barrier设置为16,随意要等到16个才能执行;但线程池中只有8个一直被
 * @date 18-4-4
 */
public class Test {
    private static CyclicBarrier cb;
    static class TaskThread extends Thread {
        @Override public void run() {
            System.out.println("子线程"+Thread.currentThread().getName()+"到了");
            try {
                cb.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        cb = new CyclicBarrier(16, new Runnable() {
            @Override public void run() {
                System.out.println("到齐了......");
            }
        });
        long start = System.currentTimeMillis();
        ExecutorService executorPool = Executors.newFixedThreadPool(8);
        for (int i = 0; i < 16; i++) {
            executorPool.execute(new Runnable() {
                @Override public void run() {
                    System.out.println("子线程"+Thread.currentThread().getName()+"到了");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        cb.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
