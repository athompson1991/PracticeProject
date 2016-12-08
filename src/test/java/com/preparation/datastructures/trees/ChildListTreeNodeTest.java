package com.preparation.datastructures.trees;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by aleth on 12/5/2016.
 */
public class ChildListTreeNodeTest extends TestCase {

    private SimpleTreeNode<String> root;
    private String firstChild;
    private String secondChild;
    private String firstGrandChild;
    private SimpleTreeNode.Visitor myVisitor;

    public void setUp() throws Exception {
        root = new ChildListTreeNode<String>("root");
        firstChild = "United States";
        secondChild = "Brazil";
        firstGrandChild = "Seattle";
        myVisitor = new SimpleTreeNode.Visitor() {
            public void visit(SimpleTreeNode node) {
                System.out.println(node.getData());
            }
        };
    }

    public void testEmptyTree() {
        assertEquals(root.getData(), "root");
        assertNull(root.getParent());
        assertEquals(root.getChildren().size(), 0);
    }

    public void testSetData() {
        root.setData("Nations");
        assertEquals(root.getData(), "Nations");
    }

    public void testInserts() {
        insertChildren();
        assertEquals(root.getChildren().get(0).getData(), firstChild);
        assertEquals(root.getChildren().get(1).getData(), secondChild);
        assertEquals(root.getChildren().get(0).getParent(), root);
        assertEquals(root.getChildren().get(1).getParent(), root);
    }

    public void testRemoveFromParent() {
        insertChildren();
        root.getChildren().get(0).getChildren().get(0).removeFromParent();
        assertEquals(root.getChildren().get(0).getChildren().size(), 0);
    }

    public void testTraversalPreorder() {
        insertChildren();
        root.traversePreorder(myVisitor);
    }

    public void insertChildren() {
        root.insertChildAt(0, new ChildListTreeNode<String>(firstChild));
        root.insertChildAt(1, new ChildListTreeNode<String>(secondChild));
        root.getChildren().get(0).insertChildAt(0, new ChildListTreeNode<String>(firstGrandChild));
    }
}
