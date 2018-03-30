package month1.lock_test.CLH;

import jdk.nashorn.internal.runtime.regexp.joni.ast.QuantifierNode;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author aidar
 * @desc    当一个线程需要获取锁时：
 *              1.创建一个的QNode，将其中的locked设置为true表示需要获取锁
 *              2.线程对tail域调用getAndSet方法，使自己成为队列的尾部，同时获取一个指向其前趋结点的引用myPred
 *              3.该线程就在前趋结点的locked字段上旋转，直到前趋结点释放锁
 *              4.当一个线程需要释放锁时，将当前结点的locked域设置为false，同时回收前趋结点(我的理解:根据代码就是将当前节点设置为myPred节点,丢弃当前节点信息)
 * @date 18-3-27
 */
public class CLHLock implements Lock {

    AtomicReference<QNode> tail;
    ThreadLocal<QNode> myPred;
    ThreadLocal<QNode> myNode;

    public CLHLock() {
        tail = new AtomicReference<QNode>(new QNode());
        myNode = new ThreadLocal<QNode>() {
            protected QNode initialValue() {
                return new QNode();
            }
        };
        myPred = new ThreadLocal<QNode>() {
          protected QNode initialValue() {
              return null;
          }
        };

    }



    @Override public void lock() {
        QNode qNode = myNode.get();
        qNode.locked = true;
        QNode pred = tail.getAndSet(qNode);
        myPred.set(pred);
        while (pred.locked) {

        }
    }

    @Override public void lockInterruptibly() throws InterruptedException {

    }

    @Override public boolean tryLock() {
        return false;
    }

    @Override public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override public void unlock() {
        QNode qNode =myNode.get();
        qNode.locked =false;
        myNode.set(myPred.get());
    }

    @Override public Condition newCondition() {
        return null;
    }
}
