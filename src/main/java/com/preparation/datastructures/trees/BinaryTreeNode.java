package com.preparation.datastructures.trees;

/**
 * Created by aleth on 1/18/2017.
 */
public interface BinaryTreeNode<E> {
    E getData();

    void setData(E data);

    BinaryTreeNode<E> getParent();

    BinaryTreeNode<E> getLeft();

    BinaryTreeNode<E> getRight();

    void setLeft(BinaryTreeNode<E> newNode);

    void setRight(BinaryTreeNode<E> newNode);

    void removeFromParent();

    void traversePreOrder();

    void traversePostOrder();

    void traverseInOrder();

    void print();
}
