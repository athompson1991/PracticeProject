package com.preparation.datastructures.trees;

import junit.framework.TestCase;

/**
 * Created by aleth on 12/8/16.
 */
public class BinarySearchTreeTest extends TestCase {

    public BinarySearchTree myTree;
    public BinaryTreeNode newRoot;

    public void setUp() {
        myTree = new BinarySearchTree();
    }

    public void testEmptyTree() {
        assertTrue(myTree.isEmpty());
    }

    public void testInsertOneNode() {
        initializeTree();
        myTree.setRoot(newRoot);
        myTree.insert(10);
    }

    public void initializeTree() {
        BinaryTreeNode newRoot = new LinkedBinaryTreeNode(20);
        myTree.setRoot(newRoot);
    }

}
