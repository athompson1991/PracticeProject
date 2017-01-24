package com.preparation.datastructures.trees;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by aleth on 1/18/2017.
 */
public class LinkedBinaryTreeNodeTest {
    private LinkedBinaryTreeNode<Object> myTree;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setup() {
        myTree = new LinkedBinaryTreeNode<>("foo");
    }

    @Test
    public void setLeft() {
        LinkedBinaryTreeNode temp = new LinkedBinaryTreeNode("bar");
        myTree.setLeft(temp);
        assertEquals("bar", myTree.getLeft().getData());
        myTree.setLeft(null);
        assertNull(myTree.getLeft());
    }

    @Test
    public void setRight() {
        LinkedBinaryTreeNode temp = new LinkedBinaryTreeNode("bar");
        myTree.setRight(temp);
        assertEquals("bar", myTree.getRight().getData());
        myTree.setRight(null);
        assertNull(myTree.getLeft());
    }

    @Test
    public void print() {
        System.setOut(new PrintStream(outContent));
        myTree.print();
        String testString = "#####\n#foo#\n#####\n";
        assertEquals(testString, outContent.toString());
    }

    @Test
    public void traversals() {
        assignMany(10);
        SimpleVisitor visitor = new SimpleVisitor();
        myTree.traversePreOrder(visitor);
    }

    @Test
    public void getRandomLeaf() {
        BinaryTreeNode testNode;
        myTree.setLeft(new LinkedBinaryTreeNode("hello"));
        myTree.setRight(new LinkedBinaryTreeNode("world"));
        myTree.getLeft().setLeft(new LinkedBinaryTreeNode("!!!"));
        myTree.getLeft().getLeft().setLeft(new LinkedBinaryTreeNode("Potato"));
        myTree.getLeft().getLeft().getLeft().setRight(new LinkedBinaryTreeNode("Hashbrowns"));
        assertTrue(myTree.getRandomLeaf().isLeaf());
    }

    private void assignMany(int n) {
        for (int i = 0; i < n; i++) {
            int randData = (int) (Math.random() * 50 - 25);
            BinaryTreeNode tempNode = new LinkedBinaryTreeNode(randData);
            BinaryTreeNode targetNode = myTree.getRandomLeaf();
            if (Math.random() - 0.5 > 0) {
                targetNode.setLeft(tempNode);
            } else {
                targetNode.setRight(tempNode);
            }
        }
    }
}
