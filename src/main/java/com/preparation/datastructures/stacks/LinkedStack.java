package com.preparation.datastructures.stacks;

import java.util.NoSuchElementException;

/**
 * Created by aleth on 12/3/2016.
 */
public class LinkedStack implements StackInterface {
    private class Node {
        public Node next;
        public Object data;

        Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node top = null;

    public void push(Object data) {
        top = new Node(data, top);
    }

    public void popDelete() {
        top = top.next;
    }

    public Object pop() {
        Object outObj = top();
        popDelete();
        return outObj;
    }

    public Object top() {
        if (top == null) throw new NoSuchElementException();
        return top.data;
    }

    public int size() {
        int count = 0;
        for (Node node = top; node != null; node = node.next) {
            count++;
        }
        return count;
    }

    public boolean isEmpty() {
        return top == null;
    }
}
