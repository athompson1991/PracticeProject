package com.preparation.datastructures.stacks;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by aleth on 12/4/2016.
 */
public class BoundedStackTest extends StackInterfaceTest {
    private static int CAPACITY = 40;

    @Before
    public void makeBoundedStatck() {
        myStack = new BoundedStack(CAPACITY);
    }

    @Test(expected = IllegalStateException.class)
    public void testPushToFullStack() {
        for (int i = 0; i < CAPACITY; i++) {
            myStack.push("potato");
        }
        myStack.push("over potato");
    }
}
