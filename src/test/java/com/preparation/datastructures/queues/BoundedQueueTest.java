package com.preparation.datastructures.queues;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by aleth on 12/4/2016.
 */
public class BoundedQueueTest extends QueueTest{
    private static int CAPACITY = 100;

    @Before
    public void makeBoundedQueue() {
        myQueue = new BoundedQueue(CAPACITY);
    }

    @Test(expected = IllegalStateException.class)
    public void overEnqueue(){
        manyEnqueues(CAPACITY);
        myQueue.enqueue("Big problem");
    }
}
