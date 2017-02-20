package com.preparation.datastructures.trees;

import sun.reflect.generics.tree.Tree;

import java.util.NoSuchElementException;

/**
 * Created by Alex on 2/15/2017 at 1:19 PM.
 */
public class LinkedBinarySearchTree extends AbstractBinaryTree implements BinaryTree {

    public LinkedBinarySearchTree() {
        super();
    }

    public LinkedBinarySearchTree(Integer rootValue) {
        super(rootValue);
    }

    @Override
    public void add(Integer value) {
        TreeNode treeNode = new TreeNode(value);

        if (root == null)
            root = treeNode;
        else {
            TreeNode currentNode = root;
            TreeNode parentNode = null;
            Boolean run = true;
            while (run) {
                parentNode = currentNode;
                if (value < currentNode.getData()) {
                    currentNode = currentNode.getLeft();
                    if (currentNode == null) {
                        parentNode.setLeft(treeNode);
                        run = false;
                    }
                } else {
                    currentNode = currentNode.getRight();
                    if (currentNode == null) {
                        parentNode.setRight(treeNode);
                        run = false;
                    }
                }
            }
        }
        size++;
    }

    @Override
    public void delete(Integer value) {
        TreeNode deleteNode = root;
        if (!search(value))
            throw new NoSuchElementException("Value not in tree.");
        else {
            deleteNode = search(value,root, deleteNode);
            delete(deleteNode);
        }
        size--;
    }

    public void delete(TreeNode treeNode) {

    }

    @Override
    public Boolean search(Integer value) {
        boolean out = false;
        TreeNode tempNode = root;
        if (root == null)
            out = false;
        else if (value < root.getData()) {
            tempNode = search(value, root.getLeft(), tempNode);
        } else if (value > root.getData()) {
            tempNode = search(value, root.getRight(), tempNode);
        }
        out = tempNode.getData() == value;
        return out;
    }

    public TreeNode search(Integer value, TreeNode treeNode, TreeNode in) {
        TreeNode out = in;
        if (treeNode.getData() < value & treeNode.getRight() != null) {
            return search(value, treeNode.getRight(), in);
        } else if (treeNode.getData() > value & treeNode.getLeft() != null) {
            return search(value, treeNode.getLeft(), in);
        } else if (treeNode.getData() == value) {
            out = treeNode;
        }
        return out;
    }

    @Override
    public TreeNode get(Integer value) {
        return null;
    }

    @Override
    public Boolean isEmpty() {
        return size == 0;
    }

}
