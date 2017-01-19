package com.preparation.datastructures.trees;

/**
 * Created by aleth on 1/18/2017.
 */
public class LinkedBinaryTreeNode<E> implements BinaryTreeNode {
    private E data;
    private LinkedBinaryTreeNode<E> parent;
    private LinkedBinaryTreeNode<E> left;
    private LinkedBinaryTreeNode<E> right;

    LinkedBinaryTreeNode(E data) {
        this.data = data;
        this.parent = null;
        this.left = null;
        this.left = null;
        this.right = null;
    }

    LinkedBinaryTreeNode() {
        this(null);
    }

    public Object getData() {
        return this.data;
    }

    @Override
    public void setData(Object data) {
        this.data = (E) data;
    }

    public BinaryTreeNode getParent() {
        return parent;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setLeft(BinaryTreeNode newNode) {
        // Ask if casting is dangerous in a context like this
        // (i.e. if I implement a different kind of BinaryTreeNode using different data types
        // will it die on the checkNodeIsAncestor method?)

        checkNodeIsAncestor((LinkedBinaryTreeNode<E>) newNode);

    }

    public void setRight(BinaryTreeNode newNode) {

    }

    public void removeFromParent() {

    }

    public void traversePreOrder() {

    }

    public void traversePostOrder() {

    }

    public void traverseInOrder() {

    }

    public void print() {

    }

    // Helper functions
    private void checkNodeIsAncestor(LinkedBinaryTreeNode<E> check) {
        for (LinkedBinaryTreeNode<E> temp = this; temp.parent != null; temp = temp.parent) {
            if (temp == check)
                throw new IllegalArgumentException("Node is an ancestor");
        }
    }
}
