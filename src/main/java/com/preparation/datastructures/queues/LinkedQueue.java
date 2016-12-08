package com.preparation.datastructures.queues;

/**
 * Created by aleth on 12/4/2016.
 */
public class LinkedQueue implements Queue{

    private class Node {
        public Object data;
        public Node next;
        public  Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private int size = 0;
    private Node head = null;
    private Node tail = null;

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(Object item){
        Node newNode = new Node(item, null);
        if(size == 0){
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    public Object dequeue(){
        if(size == 0) throw new IllegalStateException("Empty list");
        Object out = head.data;
        size--;
        return out;
    }

    public Object peekAtHead(){
        return head.data;
    }

    public Object peekAtTail(){
        return tail.data;
    }
}
