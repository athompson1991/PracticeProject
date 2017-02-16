package com.preparation.datastructures.priorityqueues;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by aleth on 2/13/2017.
 */
public abstract class PriorityQueueTest {

    protected PriorityQueue priorityQueue;

    @Test
    public void initialize() {
        assertEquals(0, priorityQueue.getSize());
        assertTrue(priorityQueue.isEmpty());
    }

    @Test
    public void testAdd() {
        priorityQueue.add(100);
        assertEquals(101, priorityQueue.getSize());
    }

}
