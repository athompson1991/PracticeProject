package com.preparation.datastructures.stacks;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import org.junit.Test;

import java.util.NoSuchElementException;


/**
 * Created by aleth on 12/3/2016.
 */
public abstract class StackInterfaceTest {

    protected StackInterface myStack;

    @Test
    public void testEmpty(){
        assertTrue(myStack.isEmpty());
        assertEquals(myStack.size(), 0);
    }

    @Test
    public void testPushes() {
        int numberOfPushes = 10;
        for (int i = 0; i < numberOfPushes; i++) {
            myStack.push("Potato");
        }
        assertFalse(myStack.isEmpty());
        assertEquals(myStack.size(), numberOfPushes);
    }

    @Test
    public void testPushPop() {
        Object message = "Hello";
        myStack.push(message);
        assertEquals(message, myStack.pop());
    }

    @Test
    public void testPushTop() {
        String message = "Hello";
        myStack.push(message);
        assertEquals(myStack.top(), message);
    }

    @Test
    public void testPopToEmpty() {
        int numberOfPushes = 10;
        for (int i =0; i < numberOfPushes; i++){
            myStack.push("Potato");
        }
        for(int i = 0; i < numberOfPushes; i++) {
            myStack.pop();
        }
        assertTrue(myStack.isEmpty());
        assertEquals(myStack.size(), 0);
    }

    @Test(expected = NoSuchElementException.class)
    public void testPopOnEmpty() {
        assertTrue(myStack.isEmpty());
        myStack.pop();
    }

    @Test(expected=NoSuchElementException.class)
    public void testTopEmptyStack(){
        assertTrue(myStack.isEmpty());
        myStack.top();
    }
}



