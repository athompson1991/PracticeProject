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

    public E getData() {
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

        LinkedBinaryTreeNode<E> childNode = (LinkedBinaryTreeNode<E>) child;
        checkAncestors(childNode);


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

        LinkedBinaryTreeNode<E> childNode = (LinkedBinaryTreeNode<E>) child;
        checkAncestors(childNode);

        if (this.right != null) {
            right.parent = null;
        }

        if (childNode != null) {
            childNode.removeFromParent();
            childNode.parent = this;
        }
        this.right = childNode;
    }

    public void removeFromParent() {
        if (parent != null) {
            if (parent.left == this) {
                parent.left = null;
            } else if (parent.right == this) {
                parent.right = null;
            }
            this.parent = null;
        }
    }


    public void traversePreorder(BinaryTreeNode.Visitor visitor) {
        visitor.visit(this);
        if (left != null) left.traversePreorder(visitor);
        if (right != null) right.traversePreorder(visitor);
    }

    public void traversePostorder(BinaryTreeNode.Visitor visitor) {
        if (left != null) left.traversePreorder(visitor);
        if (right != null) right.traversePreorder(visitor);
        visitor.visit(this);
    }

    public void traverseInorder(BinaryTreeNode.Visitor visitor) {
        if (left != null) left.traversePreorder(visitor);
        visitor.visit(this);
        if (right != null) right.traversePreorder(visitor);
    }

    public void checkAncestors(LinkedBinaryTreeNode<E> child) {
        for (LinkedBinaryTreeNode<E> n = this; n != null; n = n.parent) {
            if (n == child) throw new IllegalArgumentException();
        }
    }

}
