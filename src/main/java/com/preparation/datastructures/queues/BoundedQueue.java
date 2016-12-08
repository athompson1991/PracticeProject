package com.preparation.datastructures.queues;

/**
 * Created by aleth on 12/4/2016.
 */
public class BoundedQueue implements Queue{

   private Object[] array;
   private int size = 0;
   private int head = 0;
   private int tail = 0;

   public BoundedQueue(int capacity) {
      array = new Object[capacity];
   }

   public void enqueue(Object item) {
      if(size == array.length) throw new IllegalStateException("Full array");
      array[tail] = item;
      size++;
      tail = (tail + 1) % array.length;
   }

   public Object dequeue() {
      if(size == 0) throw new IllegalStateException("Empty Array");
      Object returnVal =  array[head];
      array[head] = null;
      head = (head + 1) % array.length;
      size--;
      return returnVal;
   }

   public Object peekAtHead() {
      return array[head];
   }

   public Object peekAtTail() {
      return array[tail - 1];
   }

   public boolean isEmpty() {
      return size == 0;
   }

   public int size() {
      return size;
   }
}
