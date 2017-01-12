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

    public String print() {
        String out = "";
        LinkedListNode temp = head;
        String firstEntry = String.valueOf(head.getData());
        out = "[ " + firstEntry;
        while (temp.next != null) {
            temp = temp.next;
            out = out + ", " + String.valueOf(temp.getData());
        }
        out = out + " ]";
        return out;
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

    public Object pop() {
        Object out;
        if (head == null) {
            out = null;
        } else {
            out = head.getData();
            head = head.next;
            size--;
        }
        return out;
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

    public void reverse() {
        LinkedListNode currentNode = head;
        LinkedListNode nextNode = null;
        LinkedListNode workNode = null;

        while (currentNode.next != null) {
            nextNode = currentNode.next;
            currentNode.previous = nextNode;
            currentNode.next = workNode;
            workNode = currentNode;
            currentNode = nextNode;
        }

        head = currentNode;
        head.next = workNode;
    }

    private LinkedListNode loopToThisNode(int i) {
        LinkedListNode temp = head;
        for (int j = 0; j < i; j++) {
            temp = temp.next;
        }
        return temp;
    }

}
