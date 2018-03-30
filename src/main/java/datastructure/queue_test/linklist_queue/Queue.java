package datastructure.queue_test.linklist_queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author aidar
 * @desc
 * @date 18-3-29
 */
public class Queue <Item> implements Iterable<Item> {
    private Node<Item> first;    // 队头节点
    private Node<Item> last;     // 队尾节点（注意和上面的last区分，last并不是队尾元素的下标）
    private int N;               // 队列元素的数量

    // 辅助类Node
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    /**
     * 初始化队列
     */
    public Queue() {
        first = null;
        last  = null;
        N = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    /**
     * 返回但不删除头元素
     */
    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        return first.item;
    }

    /**
     * 元素入列
     */
    public void enqueue(Item item) {
        //记录尾节点
        Node<Item> oldlast = last;
        //创建新的尾节点
        last = new Node<Item>();
        last.item = item;
        last.next = null;
        //如果队列是空的，将first置为last，因为这时候队列中只有一个元素
        if (isEmpty()) first = last;
            //否则执行正常的在尾节点插入新节点的操作
        else           oldlast.next = last;
        N++;
    }

    /**
     *元素出列
     */
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        //队头元素出列
        Item item = first.item;
        first = first.next;
        N--;
        //如果这时候队列为空，表示原来只有一个元素，这时候也将last置为null
        if (isEmpty()) last = null;
        return item;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this)
            s.append(item + " ");
        return s.toString();
    }
    public Iterator<Item> iterator()  {
        return new ListIterator<Item>(first);
    }

    // 实现迭代
    private class ListIterator<Item> implements Iterator<Item> {

        private Node<Item> current;
        //要实现迭代，我们只需要维护一个节点，并在开始的时候将它置为first
        public ListIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext()  { return current != null;}
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
