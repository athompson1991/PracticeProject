package com.preparation.datastructures.trees;

import junit.framework.TestCase;

/**
 * Created by aleth on 12/6/2016.
 */
public class LinkedBinaryTreeNodeTest extends TestCase {

    private BinaryTreeNode root;

    public void setUp() {
        root = new LinkedBinaryTreeNode("root");
    }

    public void testEmptyTree() {
        assertEquals(root.getData(), "root");
    }

    public void testSetData() {
        root.setLeft(new LinkedBinaryTreeNode("leftData"));
        root.setRight(new LinkedBinaryTreeNode("rightData"));
        assertEquals(root.getLeft().getData(), "leftData");
        assertEquals(root.getRight().getData(), "rightData");
    }

    public void testRemoveFromParent() {
        root.setLeft(new LinkedBinaryTreeNode("Testing"));
        root.getLeft().removeFromParent();
        assertNull(root.getLeft());
    }
}
