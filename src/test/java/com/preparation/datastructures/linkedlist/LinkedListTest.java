package com.preparation.datastructures.linkedlist;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by aleth on 1/10/2017.
 */
public class LinkedListTest {

    private LinkedList myList;

    @Before
    public void setup() {
        myList = new LinkedList();
    }

    @Test
    public void testInitialize() {
        assertTrue(myList.isEmpty());
    }

    @Test
    public void testPushPeek() {
        myList.push("Hello World");
        assertEquals("Hello World", myList.peek());
        assertEquals(1, myList.getSize());
        myList.push("Foo");
        assertEquals("Foo", myList.peek());
        assertEquals(2, myList.getSize());
    }

    @Test
    public void testInsertBefore() {
        pushMany();
        myList.insertBefore("Test", 2);
        assertEquals("Test", myList.getDataAt(2));
        assertNull(myList.getDataAt(-1));
        assertNull(myList.getDataAt(100));
        assertEquals(5, myList.getSize());
    }

    @Test
    public void testDeleteAt() {
        pushMany();
        assertEquals("Potato", myList.getDataAt(1));
        myList.deleteDataAt(1);
        assertEquals("Thompson", myList.getDataAt(1));
        myList.deleteDataAt(0);
        assertEquals("Thompson", myList.getDataAt(0));
        myList.deleteDataAt(1);
        assertEquals(1, myList.getSize());
        myList.deleteDataAt(0);
        assertTrue(myList.isEmpty());
    }

    @Test
    public void testPop() {
        pushMany();
        assertEquals(123, myList.pop());
        assertEquals("Potato", myList.pop());
        assertEquals("Thompson", myList.pop());
        assertEquals("Alex", myList.pop());
        assertNull(myList.pop());
        assertTrue(myList.isEmpty());
        myList.push("Final test");
        assertEquals("Final test", myList.pop());
    }

    @Test
    public void testReverse() {
        pushMany();
        myList.reverse();
        assertEquals("Alex", myList.pop());
        assertEquals("Thompson", myList.pop());
        assertEquals("Potato", myList.pop());
        assertEquals(123, myList.pop());
    }

    private void pushMany() {
        myList.push("Alex");
        myList.push("Thompson");
        myList.push("Potato");
        myList.push(123);
    }

}
