package com.preparation.datastructures.hashtable;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by aleth on 12/12/2016.
 */
public class HashTableTest {

    public HashTable myHashTable;

    @Before
    public void setUp() {
        myHashTable = new HashTable();
    }

    @Test
    public void testConstructor() {
        assertEquals(100, myHashTable.getSize());
    }

    @Test
    public void testHash() {
        int index = myHashTable.hash("Hello world");
        assertEquals(index, 84);
    }

    @Test
    public void testAddAndGet() {
        myHashTable.add("Alex", "Analyst");
        myHashTable.add("Lucas", "Clerk");
        myHashTable.add("Dana", "Driver");
        myHashTable.add("Linda", "Manager");
        assertEquals(myHashTable.get("Alex"), "Analyst");
        assertEquals(myHashTable.get("Lucas"), "Clerk");
        assertEquals(myHashTable.get("Dana"), "Driver");
        assertEquals(myHashTable.get("Linda"), "Manager");
    }

    @Test
    public void testAddCollision() {
        myHashTable.add("Hello world", "First value");
        myHashTable.add("T", "Second value");
        assertEquals(myHashTable.get("Hello world"), "First value");
        assertEquals(myHashTable.get("T"), "Second value");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testMissingGet() {
        myHashTable.get("Blah");
    }

    @Test
    public void testIndexIsEmpty() {
        assertTrue(myHashTable.indexIsEmpty(84));
        myHashTable.add("Hello world", "!");
        assertFalse(myHashTable.indexIsEmpty(84));
    }

}
