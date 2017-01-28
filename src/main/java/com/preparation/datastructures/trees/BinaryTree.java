package com.preparation.datastructures.trees;

/**
 * Created by aleth on 1/24/2017.
 */
public interface BinaryTree<E> {
    void BinaryTree();

    void BinaryTree(E data);

    BinaryTreeNode BinaryTree(BinaryTree leftTree, E data, BinaryTree rightTree);

    void makeRoot(E data);

    void makeLeftChild(BinaryTreeNode parent, E data);

    void makeRightChild(BinaryTreeNode parent, E data);

    void remove(BinaryTreeNode target);

    BinaryTreeNode root();

    boolean contains(E data);

    boolean isEmpty();
}
