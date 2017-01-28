package com.preparation.datastructures.trees;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by aleth on 1/24/2017.
 */
public class LinkedBinaryTreeTest {

    private LinkedBinaryTree myTree;

    @Before
    public void setUp() {
        myTree = new LinkedBinaryTree();
    }

    @Test
    public void makeRoot() {
        assertTrue(myTree.isEmpty());
        myTree.makeRoot(100);
        assertEquals(100, myTree.root().getData());
    }

}
