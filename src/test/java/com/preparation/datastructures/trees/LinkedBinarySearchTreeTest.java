package com.preparation.datastructures.trees;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by aleth on 3/2/2017.
 */
public class LinkedBinarySearchTreeTest extends AbstractBinaryTreeTest {

    @Before
    public void setup() {
        tree = new LinkedBinarySearchTree();
    }

    @Test
    public void height() {
        populate();
        assertEquals(4, tree.getHeight().intValue());
        assertEquals(3, tree.getRight().getHeight().intValue());
    }

    @Test(expected = NoSuchElementException.class)
    public void get() {
        populate();
        BinaryTree selected = tree.get(500);
        assertNotNull(selected);
        assertEquals(2, selected.getDepth().intValue());
        assertEquals(2, selected.getHeight().intValue());
        tree.get(-1);
    }

    @Test
    public void delete() {
        populate();
        tree.add(60);
        tree.delete(50);
        assertEquals(60, tree.getLeft().getData().intValue());
        tree.delete(300);
    }

    @Test
    public void minMax() {
        populate();
        assertEquals(25, tree.min().getData());
        assertEquals(700, tree.max().getData());

        LinkedBinarySearchTree temp = new LinkedBinarySearchTree(100);
        assertEquals(100, temp.min().getData().intValue());
        assertEquals(100, temp.max().getData().intValue());
    }
}
