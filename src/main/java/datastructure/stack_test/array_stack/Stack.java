package datastructure.stack_test.array_stack;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

/**
 * @author aidar
 * @desc
 * @date 18-3-29
 */
public class Stack<Item> implements Iterable<Item> {

    private Item[] a;
    private int n;

    public Stack() {
        a = (Item[])new Object();
        n = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void resize(int capacity) {
        assert capacity >= n;
        Item[] temp = (Item[])new Object[capacity];
        for (int i = 0; i < n; i++) {
            temp[i] = a[i];
        }
        a = temp;
        //也可用该方法改变数组大小
//        a = Arrays.copyOf(a, capacity);
    }

    public void push(Item item) {
        if (n == a.length) resize(2*a.length);
        a[n++] = item;
    }

    /**
     * 弹出并返回元素
     */
    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException("stack underflow");
        Item item = a[n-1];
        a[n-1] = null;//防止对象游离
        n--;
        //如果有必要则调整栈的大小
        if (n > 0 && n == a.length/4) resize(a.length/2);
        return item;
    }

    /**
     * 返回但不弹出栈顶元素
     */
    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("stack underflow");
        return a[n-1];
    }

    @Override public Iterator<Item> iterator() {
        return null;
    }

    /**
     * 用内部类实现迭代器接口,实现从栈顶往栈底的先进后出迭代,没有实现remove()方法
     */
    private class ReverseArrayIterator implements Iterator<Item> {
        private int i;

        public ReverseArrayIterator() {
            i = n-1;
        }

        @Override public void remove() {
            throw new UnsupportedOperationException();
        }

//        @Override public void forEachRemaining(Consumer<? super Item> action) {
//        }

        @Override public boolean hasNext() {
            return i >= 0;
        }

        @Override public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return a[i--];
        }
    }

//    public static void main(String[] args) {
//        Stack<String> stack = new Stack<String>();
//        while (!StdIn.isEmpty()) {
//            String item = StdIn.readString();
//            if (!item.equals("-")) stack.push(item);
//            else if (!stack.isEmpty()) StdOut.print(stack.pop() + " ");
//        }
//        StdOut.println("(" + stack.size() + " left on stack)");
//    }
}
