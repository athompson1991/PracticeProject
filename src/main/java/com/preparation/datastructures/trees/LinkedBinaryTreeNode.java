package com.preparation.datastructures.trees;

/**
 * Created by aleth on 12/6/2016.
 */
public class LinkedBinaryTreeNode<E> implements BinaryTreeNode<E> {

    private E data;
    protected LinkedBinaryTreeNode<E> parent;
    protected LinkedBinaryTreeNode<E> left;
    protected LinkedBinaryTreeNode<E> right;



    public LinkedBinaryTreeNode(E data) {
        this.data = data;
    }

    public E getData(){
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public BinaryTreeNode<E> getParent() {
        return parent;
    }

    public BinaryTreeNode<E> getLeft() {
        return left;
    }

    public BinaryTreeNode<E> getRight() {
        return right;
    }

    public void setLeft(BinaryTreeNode<E> child) {

        checkAncestors((LinkedBinaryTreeNode)child);

        LinkedBinaryTreeNode<E> childNode = (LinkedBinaryTreeNode<E>)child;

        if (this.left != null) {
            left.parent = null;
        }

        if (childNode != null) {
            childNode.removeFromParent();
            childNode.parent = this;
        }
        this.left = childNode;
    }

    public void setRight(BinaryTreeNode<E> child) {

    }

    public void removeFromParent() {
        this.parent = null;
    }

    public void traversePreorder() {

    }

    public void traversePostorder() {

    }

    public void traverseInorder() {

    }


    public void checkAncestors(LinkedBinaryTreeNode<E> child) {
        for (LinkedBinaryTreeNode<E> n = this; n != null; n = n.parent) {
            if (n == child) throw new IllegalArgumentException();
        }
    }

}
