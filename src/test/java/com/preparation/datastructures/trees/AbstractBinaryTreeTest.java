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
    public void height() {
        assertNull(tree.getHeight());
        tree.add(100);
        tree.traverseInOrder();
        System.out.print(tree.treeListInOrder());
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
    }

    protected void populate() {
        tree.add(100);
        tree.add(200);
        tree.add(50);
        tree.add(25);
        tree.add(75);
        tree.add(500);
        tree.add(700);
        tree.add(400);
        tree.add(300);
    }
}
