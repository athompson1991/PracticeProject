package com.preparation.datastructures.stacks;

import java.util.NoSuchElementException;

/**
 * Created by aleth on 12/3/2016.
 */
public class BoundedStack implements StackInterface {
    private Object[] array;
    private int size = 0;

    public BoundedStack(int capacity) {
        array = new Object[capacity];
    }

    public void push(Object item) {
        if (size == array.length) {
            throw new IllegalStateException("Stack is full!");
        }
        array[size++] = item;
    }

    private void popDelete() {
        array[--size] = null;
    }

    public Object pop() {
        if (size == 0) throw new NoSuchElementException("Empty Stack!");
        Object result = array[size - 1];
        popDelete();
        return result;
    }

    public Object top() {
        if (size == 0) throw new NoSuchElementException("Empty Stack!");
        return array[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

}
