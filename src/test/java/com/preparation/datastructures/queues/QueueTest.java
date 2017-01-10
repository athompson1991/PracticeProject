package com.preparation.datastructures.queues;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by aleth on 12/4/2016.
 */
public abstract class QueueTest {

    protected Queue myQueue;

    @Test
    public void testNewQueueIsEmpty() {
        assertTrue(myQueue.isEmpty());
        assertEquals(myQueue.size(), 0);
    }

    @Test
    public void testEnqueue() {
        int numberOfEntries = 10;
        for (int i = 0; i < numberOfEntries; i++) {
            myQueue.enqueue("Hello");
        }
        assertFalse(myQueue.isEmpty());
        assertEquals(myQueue.size(), numberOfEntries);
    }

    @Test
    public void testEnqueueThenDequeue() {
        Object testVal = "Hello";
        myQueue.enqueue(testVal);
        assertEquals(testVal, myQueue.dequeue());
    }

    @Test
    public void testPeekHead() {
        helloWorldEnqueue();
        assertEquals("Hello", myQueue.peekAtHead());
    }

    @Test
    public void testPeekAtTail() {
        helloWorldEnqueue();
        assertEquals("World", myQueue.peekAtTail());
    }

    @Test
    public void testManyEnqueueManyDequeue() {
        int numberOfTests = 50;
        manyEnqueues(numberOfTests);
        assertEquals(numberOfTests, myQueue.size());
        manyDequeues(numberOfTests);
        assertEquals(0, myQueue.size());
        assertTrue(myQueue.isEmpty());
    }

    @Test(expected = IllegalStateException.class)
    public void testDequeueOnEmpty() {
        assertTrue(myQueue.isEmpty());
        myQueue.dequeue();
    }

    public void helloWorldEnqueue() {
        myQueue.enqueue("Hello");
        myQueue.enqueue("Potato");
        myQueue.enqueue("World");
    }

    public void manyEnqueues(int enqueueCount) {
        for (int i = 0; i < enqueueCount; i++) {
            myQueue.enqueue("Hello");
        }
    }

    public void manyDequeues(int enqueueCount) {
        for (int i = 0; i < enqueueCount; i++) {
            myQueue.dequeue();
        }
    }
}
