package com.preparation.datastructures.trees;

/**
 * Created by aleth on 1/18/2017.
 */
public class LinkedBinaryTreeNode<E> implements BinaryTreeNode {
    private E data;
    protected LinkedBinaryTreeNode<E> parent;
    protected LinkedBinaryTreeNode<E> left;
    protected LinkedBinaryTreeNode<E> right;

    LinkedBinaryTreeNode(E data) {
        this.data = data;
        this.parent = null;
        this.left = null;
        this.right = null;
    }

    LinkedBinaryTreeNode() {
        this(null);
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = (E) data;
    }

    public BinaryTreeNode getParent() {
        return parent;
    }

    public BinaryTreeNode getLeft() {
        return this.left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setLeft(BinaryTreeNode newNode) {
        LinkedBinaryTreeNode fixedNode = (LinkedBinaryTreeNode<E>) newNode;
        checkNodeIsAncestor(fixedNode);
        if (this.left != null) {
            left.parent = null;
        }
        setNodeBelowThis(fixedNode);
        this.left = fixedNode;
    }

    public void setRight(BinaryTreeNode newNode) {
        LinkedBinaryTreeNode fixedNode = (LinkedBinaryTreeNode<E>) newNode;
        checkNodeIsAncestor(fixedNode);
        if (this.right != null)
            right.parent = null;
        setNodeBelowThis(fixedNode);
        this.right = fixedNode;
    }

    public void removeFromParent() {
        if (parent != null) {
            if (parent.left == this) {
                parent.left = null;
            } else if (parent.right == this) {
                parent.right = null;
            }
        }
        this.parent = null;
    }

    public void traversePreOrder(Visitor visitor) {
        visitor.visit(this);
        if (this.left != null) this.left.traversePreOrder(visitor);
        if (this.right != null) this.right.traversePreOrder(visitor);
    }

    public void traversePostOrder(Visitor visitor) {
        if (this.left != null) this.left.traversePostOrder(visitor);
        if (this.right != null) this.right.traversePostOrder(visitor);
        visitor.visit(this);
    }

    public void traverseInOrder(Visitor visitor) {
        if (this.left != null) this.left.traverseInOrder(visitor);
        visitor.visit(this);
        if (this.right != null) this.right.traverseInOrder(visitor);
    }

    public void print() {
        String printData = String.valueOf(data);
        int n = printData.length() + 2;
        String headAndFoot = "";
        for (int i = 0; i < n; i++) {
            headAndFoot = headAndFoot + "#";
        }
        String outString = headAndFoot + "\n#" + printData + "#\n" + headAndFoot + "\n";
        System.out.print(outString);
    }

    // Helper functions
    private void checkNodeIsAncestor(LinkedBinaryTreeNode<E> check) {
        for (LinkedBinaryTreeNode<E> temp = this; temp.parent != null; temp = temp.parent) {
            if (temp == check)
                throw new IllegalArgumentException("Node is an ancestor");
        }
    }

    private void setNodeBelowThis(LinkedBinaryTreeNode newNode) {
        if (newNode != null) {
            newNode.removeFromParent();
            newNode.parent = this;
        }
    }

    public boolean isLeaf() {
        return this.left == null && this.right == null;
    }

    public LinkedBinaryTreeNode getRandomLeaf() {
        boolean goLeft = Math.random() - 0.5 > 0;

        if (this.isLeaf()) {
            return this;
        } else {
            if (goLeft) {
                try {
                    return this.left.getRandomLeaf();
                } catch (Exception e) {
                    return this.right.getRandomLeaf();
                }
            } else {
                try {
                    return this.right.getRandomLeaf();
                } catch (Exception e) {
                    return this.left.getRandomLeaf();
                }
            }
        }
    }

}
