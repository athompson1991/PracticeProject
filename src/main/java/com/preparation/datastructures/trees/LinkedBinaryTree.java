package com.preparation.datastructures.trees;

/**
 * Created by aleth on 1/24/2017.
 */
public class LinkedBinaryTree implements BinaryTree {

    BinaryTreeNode root = null;

    public void BinaryTree() {

    }

    @Override
    public void BinaryTree(Object data) {
        root = new LinkedBinaryTreeNode(data);
    }

    @Override
    public BinaryTreeNode BinaryTree(BinaryTree leftTree, Object data, BinaryTree rightTree) {
        return null;
    }

    @Override
    public void makeRoot(Object data) {
        root = new LinkedBinaryTreeNode(data);
    }

    @Override
    public void makeLeftChild(BinaryTreeNode parent, Object data) {
    }

    @Override
    public void makeRightChild(BinaryTreeNode parent, Object data) {
    }

    @Override
    public void remove(BinaryTreeNode target) {

    }

    @Override
    public BinaryTreeNode root() {
        return root;
    }

    @Override
    public boolean contains(Object data) {
        return false;
    }

    public boolean isEmpty() {
        return root == null;
    }
}
