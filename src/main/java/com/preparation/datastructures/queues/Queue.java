package com.preparation.datastructures.queues;

/**
 * Created by aleth on 12/4/2016.
 */
public interface Queue {
    boolean isEmpty();

    int size();

    void enqueue(Object item);

    Object dequeue();

    Object peekAtHead();

    Object peekAtTail();
}
