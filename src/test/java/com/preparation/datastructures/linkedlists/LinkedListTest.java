package com.preparation.datastructures.linkedlists;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


/**
 * Created by aleth on 12/2/2016.
 */
public class LinkedListTest {

    public static LinkedList myList = new LinkedList();

    @BeforeClass
    public static void setUp() {
        System.out.println("Testing");
        System.out.println("-------");
        myList.addFirst("Alex");
        myList.addFirst("Lucas");
        myList.addFirst("Bob");
        myList.addFirst("Sue");
        myList.addFirst("Old MacDonald");
        myList.addFirst("Dinosaurs");
        myList.printListOneliner();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testDelete() {
        myList.delete(4);
        assertEquals(myList.get(4), "Alex");
        myList.delete(0);
        assertEquals(myList.get(0), "Old MacDonald");
        myList.delete(100);
    }

    @Test
    public void testInsert() {
        myList.insertBefore("Hello", 1);
        assertEquals(myList.get(1), "Hello");
    }

}
