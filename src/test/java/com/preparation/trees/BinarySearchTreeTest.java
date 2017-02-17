package com.preparation.trees;

import com.preparation.datastructures.trees.BinaryTree;
import com.preparation.datastructures.trees.LinkedBinarySearchTree;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
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
        binarySearchTree.add(30);
        binarySearchTree.add(19);
        binarySearchTree.add(10);
        binarySearchTree.add(14);
        assertEquals((Integer) 9, binarySearchTree.getSize());
        System.out.print("preorder:     ");
        binarySearchTree.traversePreOrder();
        System.out.print("\n");
        System.out.print("postorder:    ");
        binarySearchTree.traversePostOrder();
        System.out.print("\n");
        System.out.print("inorder:      ");
        binarySearchTree.traverseInOrder();
        System.out.print("\n");
        System.out.print("levelorder:   ");
        binarySearchTree.traverseLevelOrder();
        System.out.print("\n");
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
        addABunch();
        binarySearchTree.delete(11);
        assertEquals((Integer) 5, binarySearchTree.getSize());
        assertFalse(binarySearchTree.search(11));
        binarySearchTree.traverseInOrder();
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
