package month1.lock_test.MCS;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author aidar
 * @desc a. 队列初始化时没有结点，tail=null
 *       b. 线程A想要获取锁，于是将自己置于队尾，由于它是第一个结点，它的locked域为false
 *       c. 线程B和C相继加入队列，a->next=b,b->next=c。且B和C现在没有获取锁，处于等待状态，所以它们的locked域为true，尾指针指向线程C对应的结点
 *       d. 线程A释放锁后，顺着它的next指针找到了线程B，并把B的locked域设置为false。这一动作会触发线程B获取锁
 *       过程描述
 *       当一个线程申请锁时：
 *         a)首先会实例化一个QNode节点，并将其设置为自己的本地线程变量myNode；
 *         b)然后通过调用AtomicReference的getAndSet()方法，将myNode设置为队列的最后一个节点，并返回其前驱节点
 *         c)接着判断前面是否已经有其他线程加入到锁的等待队列中，即前驱节点是否为空。如果前驱节点为空，则说明自己是第一个加入到锁的等待队列中的线程，执行自旋，由于locked域初始值为false，所以能立即退出自旋，获取到锁；
 *         d)如果前驱节点非空，则首先将myNode的locked域设置为true，表明自己正在等待获取锁；同时将前驱结点的next域指向myNode。
 *         e)最后该线程一直在自己节点的locked域自旋，直到locked域变为false，即前驱节点释放了锁。
 *       当一个线程释放锁时，会处于以下三种情况之一中：
 *          a)此刻没有其它线程正在申请锁，即当前节点的next域指向null，且tail指向当前节点：此种情况通过调用AtomicReference的compareAndSet()方法，将tail指向null；然后直接返回。
 *          b)此刻有其他线程正在申请锁，而且已更新tail域，但还未将前驱节点的next域指向它。即当前节点的next域指向null，且tail不是指向当前节点：此种情况则一直等待其他线程设置前驱节点的next域后，才将后继节点的locked域设置为false，以便后继节点退出自旋，从而获取到释放的锁。
 *          c)此刻有其他线程正在申请锁，而且已更新tail域，而且已将前驱节点的next域指向它。即当前节点的next域非空：此种情况则直接将后继节点的locked域设置为false，以便后继节点退出自旋，从而获取到释放的锁。
 * @date 18-3-30
 */
public class MCSLock implements Lock {
    AtomicReference<QNode> tail;
    ThreadLocal<QNode> myNode;

    public MCSLock() {
        tail = new AtomicReference<>(null);
        myNode = new ThreadLocal<QNode>() {
            protected QNode initialValue() {
                return new QNode();
            }
        };
    }

    @Override public void lock() {
        QNode qNode = myNode.get();
        QNode pred = tail.getAndSet(qNode);
        if (pred != null) {
            qNode.locked = true;
            pred.next = qNode;
            // wait until predecessor gives up the lock
            while (qNode.locked) {

            }
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
        QNode qNode = myNode.get();
        if (qNode.next == null) {
            if (tail.compareAndSet(qNode, null))
                return;
            while (qNode.next == null) {

            }
        }
        qNode.next.locked = false;
        qNode.next = null;
    }

    @Override public Condition newCondition() {
        return null;
    }

    class QNode {
        boolean locked = false;
        QNode next = null;
    }
}
