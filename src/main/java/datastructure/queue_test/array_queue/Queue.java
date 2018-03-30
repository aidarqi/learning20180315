package datastructure.queue_test.array_queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author aidar
 * @desc
 * @date 18-3-29
 */
public class Queue<Item> implements Iterable<Item> {

    private Item[] q;
    private int n;
    private int first;
    private int last;

    public Queue() {
        q = (Item[])new Object[2];
        n = 0;
        first = 0;
        last = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    private void resize(int max) {
        assert max >= n;
        Item[] temp = (Item[])new Object[max];
        /**
         * 因为循环使用数组,从first开始的第i个元素可能保存在了first前面(即last在first前面)
         */
        for (int i = 0; i < n; i++) {
            temp[i] = q[(first + i)%q.length];
        }
        q = temp;
        //把小队列按顺序复制到大队列后重置队头和队尾
        first = 0;
        last = n;
    }

    public void enqueue(Item item) {
        if (n == q.length) resize(2*q.length);
        q[last++] = item;//???数组越界???
        if (last == q.length) last=0;
        n++;
    }

    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item item = q[first];
        q[first] = null;
        n--;
        first++;
        if (first == q.length) first = 0;
        if (n > 0 && n == q.length/4) resize(q.length/2);
        return item;
    }

    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        return q[first];
    }


    @Override public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    //实现迭代器
    private class ArrayIterator implements Iterator<Item> {
        //维护一个i用于迭代
        private int i = 0;
        public boolean hasNext()  { return i < n; }
        public void remove()      { throw new UnsupportedOperationException();  }

        //直接利用first进行遍历，注意可能存在数组的循环利用
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = q[(i + first) % q.length];
            i++;
            return item;
        }
    }

}
