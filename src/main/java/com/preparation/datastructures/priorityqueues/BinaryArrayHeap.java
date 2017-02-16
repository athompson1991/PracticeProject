package com.preparation.datastructures.priorityqueues;


/**
 * Created by aleth on 2/13/2017.
 */
public class BinaryArrayHeap implements PriorityQueue {

    private Object[] array;
    private Object top;
    private Object lastInserted;
    private int size;

    BinaryArrayHeap(int capacity) {
        this.array = new Object[capacity];
        this.size = 0;
    }

    BinaryArrayHeap() {
        this.array = new Object[100];
        this.size = 0;
    }

    @Override
    public void add(Object value) {

    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == array.length;
    }

    @Override
    public Object peek() {
        return array[0];
    }

    @Override
    public Object remove() {
        return null;
    }

    @Override
    public int getSize() {
        return size;
    }
}
