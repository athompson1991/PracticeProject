package com.preparation.datastructures.trees;

/**
 * Created by aleth on 1/24/2017.
 */
public interface BinaryTree<E> {
    void BinaryTree();

    void BinaryTree(E data);

    BinaryTreeNode BinaryTree(BinaryTree leftTree, E data, BinaryTree rightTree);

    BinaryTreeNode makeRoot(E data);

    BinaryTreeNode makeLeftChild(BinaryTreeNode parent, E data);

    BinaryTreeNode makeRightChild(BinaryTreeNode parent, E data);

    void remove(BinaryTreeNode target);

    BinaryTreeNode root();

    boolean contains(E data);
}
