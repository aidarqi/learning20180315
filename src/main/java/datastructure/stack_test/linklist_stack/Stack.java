package datastructure.stack_test.linklist_stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author aidar
 * @desc
 * @date 18-3-29
 */
public class Stack<Item> implements Iterable<Item> {

    private Node<Item> first;
    private int n;

    public Stack() {
        first = null;
        n = 0;
    }

    public boolean isEmpty() {
        return first == null;
//        return n == 0;
    }

    public int size() {
        return n;
    }

    public void push(Item item) {
        Node<Item> oldfirst = first;
        first = new Node<>();
        first.item = item;
        first.next = oldfirst;
        n++;
    }

    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException("stack underflow");
        Item item = first.item;
        first = first.next;
        n--;
        return item;
    }

    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("stack underflow");
        return first.item;
    }

    /**
     * 从栈顶到栈底打印元素
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this)
            s.append(item + " ");
        return s.toString();
    }

    @Override public Iterator<Item> iterator() {
        return new ListIterator<Item>(first);
    }

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        //初始化时，current指向栈顶
        public ListIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
