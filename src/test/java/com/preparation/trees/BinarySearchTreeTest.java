package com.preparation.trees;

import com.preparation.datastructures.trees.BinaryTree;
import com.preparation.datastructures.trees.LinkedBinarySearchTree;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Alex on 2/15/2017 at 3:55 PM.
 */
public class BinarySearchTreeTest {
    public BinaryTree binarySearchTree;

    @Before
    public void setup() {
        binarySearchTree = new LinkedBinarySearchTree();
    }

    @Test
    public void add() {
        binarySearchTree.add(17);
        binarySearchTree.add(2);
        binarySearchTree.add(20);
        binarySearchTree.add(16);
        binarySearchTree.add(19);
        binarySearchTree.traversePreOrder();
        binarySearchTree.traversePostOrder();
        binarySearchTree.traverseInOrder();
    }

    @Test
    public void search() {
        addABunch();
        assertTrue(binarySearchTree.search(12));
        assertFalse(binarySearchTree.search(100));
        assertTrue(binarySearchTree.search(15));
    }

    @Test
    public void delete() {
    }

    public void addABunch() {
        binarySearchTree.add(10);
        binarySearchTree.add(17);
        binarySearchTree.add(5);
        binarySearchTree.add(12);
        binarySearchTree.add(15);
        binarySearchTree.add(11);

    }
}
