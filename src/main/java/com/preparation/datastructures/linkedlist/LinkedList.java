package com.preparation.datastructures.linkedlist;

/**
 * Created by aleth on 1/10/2017.
 */
public class LinkedList {

    private LinkedListNode head = null;
    private int size;

    private class LinkedListNode {

        private LinkedListNode next;
        private LinkedListNode previous;
        private Object data = null;

        LinkedListNode(LinkedListNode previous, LinkedListNode next, Object data) {
            this.previous = previous;
            this.next = next;
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }

    }

    public int getSize() {
        return size;
    }

    public Object peek() {
        return head.getData();
    }

    LinkedList() {
        size = 0;
    }

    public void push(Object data) {
        if (head == null) {
            head = new LinkedListNode(null, null, data);
        } else {
            head = new LinkedListNode(null, head, data);
        }
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Object getDataAt(int i) {
        Object out;
        if (i < 0 | i > size) {
            out = null;
        } else {
            LinkedListNode temp = loopToThisNode(i);
            temp = temp.next;
            out = temp.getData();
        }
        return out;
    }

    public void insertBefore(Object data, int i) {
        LinkedListNode temp = loopToThisNode(i);
        temp.next = new LinkedListNode(temp, temp.next, data);
        size++;
    }

    private LinkedListNode loopToThisNode(int i) {
        LinkedListNode temp = head;
        for (int j = 0; j < i; j++) {
            temp = temp.next;
        }
        return temp;
    }

    public Object pop() {
        return null;
    }

}
