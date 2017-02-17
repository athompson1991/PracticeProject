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
        if (!search(value))
            throw new NoSuchElementException("Value not in tree.");
        else {
            delete(value, root);
        }
    }

    private void delete(Integer value, TreeNode treeNode) {
        if (treeNode.isLeaf()) {
            if (treeNode.getData() == value)
                treeNode = null;
        } else if (treeNode.numberOfChildren() == 1) {
            if (treeNode.getLeft() == null) {

            } else {

            }
        } else if (treeNode.numberOfChildren() == 2) {

        }
    }

    @Override
    public Boolean search(Integer value) {
        boolean out = false;
        if (root == null)
            out = false;
        else if (value < root.getData()) {
            out = search(value, root.getLeft(), out);
        } else if (value > root.getData()) {
            out = search(value, root.getRight(), out);
        }
        return out;
    }

    public Boolean search(Integer value, TreeNode treeNode, Boolean in) {
        Boolean out = in;
        if (treeNode.getData() < value & treeNode.getRight() != null) {
            return search(value, treeNode.getRight(), in);
        } else if (treeNode.getData() > value & treeNode.getLeft() != null) {
            return search(value, treeNode.getLeft(), in);
        } else if (treeNode.getData() == value) {
            out = true;
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
