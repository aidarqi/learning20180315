package month1.lock_test.condition_test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author aidar
 * @desc
 * @date 18-3-30
 */
public class Depot {
    private int depotSize;
    private Lock lock;
    private int capaity;

    private Condition fullCondition;
    private Condition emptyCondition;

    public Depot(int capaity) {
        depotSize = 0;
        lock = new ReentrantLock();
        this.capaity = capaity;
        this.fullCondition = lock.newCondition();
        this.emptyCondition = lock.newCondition();
    }

    /**
     * 商品入库
     * @param value
     */
    public void put(int value) {
        lock.lock();
        try {
            int left = value;
            while (left > 0) {
                /**
                 * 库存已满时,"生产者"等待"消费者消费"
                 */
                while (depotSize >= capaity) {
                    fullCondition.await();
                }
            int inc = depotSize + value > capaity ? capaity - depotSize : left;
            depotSize += inc;
            left -= inc;
            System.out.println(
                Thread.currentThread().getName() + " ---要入库数量: " + value + ";;实际入库数量: " + inc + ";;仓库货物数量: " + depotSize + ";;没有入库数量: " + left);
            /**
             * 通知消费者可以消费了
             */
            emptyCondition.signal();

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 消费者出库
     * @param value
     */
    public void get(int value) {
        lock.lock();
        try {
            int left = value;
            while (left > 0) {
                /**
                 * 库存已空,"消费者"等待"生产者"生产货物
                 */
                while (depotSize <= 0) {
                    emptyCondition.await();
                }
            //实际消费
            int dec = depotSize < left ? depotSize : left;
            depotSize -= dec;
            left -= dec;
            System.out.println(
                Thread.currentThread().getName() + " ---要消费的数量: " + value + ";;实际消费数量: " + dec + ";;仓库货物数量: " + depotSize + ";;没有商品消费的消费者数量: " + left);
            /**
             * 通知生产者可以生产了
             */
            fullCondition.signal();

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
