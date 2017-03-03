package com.preparation.datastructures.trees;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by Alex on 2/15/2017 at 3:55 PM.
 */
public abstract class AbstractBinaryTreeTest {

    protected AbstractBinaryTree tree;

    @Test
    public void testHeight() {
        assertNull(tree.getHeight());
        tree.add(100);
        assertEquals(0, tree.getHeight().intValue());
        tree.add(200);
        assertEquals(1, tree.getHeight().intValue());
    }

    @Test
    public void testDepth() {
        assertNull(tree.getDepth());
        tree.add(100);
        assertEquals(0, tree.getDepth().intValue());
        tree.add(200);
        assertEquals(0, tree.getDepth().intValue());
        System.out.println(tree.getRight().getRight().toString());
    }

}
