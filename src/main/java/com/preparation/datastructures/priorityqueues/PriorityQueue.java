package com.preparation.datastructures.priorityqueues;

/**
 * Created by aleth on 2/6/2017. From here: https://courses.cs.washington.edu/courses/cse373/11wi/homework/5/PriorityQueue.java
 */
public interface PriorityQueue<T> {
    public void add(T value);

    public boolean isEmpty();

    public boolean isFull();

    public T peek();

    public T remove();

    public int getSize();
}
