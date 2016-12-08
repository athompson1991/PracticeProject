package com.preparation.datastructures.stacks;

/**
 * Created by aleth on 12/3/2016.
 */
public interface StackInterface {
    void push(Object item);
    Object pop();
    Object top();
    int size();
    boolean isEmpty();
}
