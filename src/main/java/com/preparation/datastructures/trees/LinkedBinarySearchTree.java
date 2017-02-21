package com.preparation.datastructures.trees;

import sun.reflect.generics.tree.Tree;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by Alex on 2/15/2017 at 1:19 PM.
 */
public class LinkedBinarySearchTree extends AbstractBinaryTree implements BinaryTree {

    public LinkedBinarySearchTree() {
        super();
    }

    public LinkedBinarySearchTree(TreeNode treeNode) {
        super(treeNode);
    }

    @Override
    public void add(Integer value) {
        TreeNode treeNode = new TreeNode(value);

        if (root == null)
            root = treeNode;
        else {
            TreeNode currentNode = root;
            TreeNode parentNode;
            Boolean run = true;
            while (run) {
                parentNode = currentNode;
                if (value < currentNode.getData()) {
                    currentNode = currentNode.getLeft();
                    if (currentNode == null) {
                        parentNode.setLeft(treeNode);
                        parentNode.getLeft().setParent(parentNode);
                        run = false;
                    }
                } else {
                    currentNode = currentNode.getRight();
                    if (currentNode == null) {
                        parentNode.setRight(treeNode);
                        parentNode.getRight().setParent(parentNode);
                        run = false;
                    }
                }
            }
        }
        size++;
    }

    @Override
    public void delete(Integer value) {
        TreeNode deleteNode;
        if (!search(value))
            throw new NoSuchElementException("Value not in tree.");
        else {
            deleteNode = search(value, root);
            delete(deleteNode);
        }
        size--;
    }

    private void delete(TreeNode treeNode) {
        TreeNode parent = treeNode.getParent();
        Boolean isLeftChild = treeNode.getData() < parent.getData();
        if (treeNode.isLeaf()) {
            if (isLeftChild) {
                parent.setLeft(null);
            } else {
                parent.setRight(null);
            }
        } else if (treeNode.getRight() == null | treeNode.getLeft() == null) {
            TreeNode newNode;
            if (treeNode.getLeft() == null)
                newNode = treeNode.getRight();
            else
                newNode = treeNode.getLeft();
            if (isLeftChild)
                parent.setLeft(newNode);
            else
                parent.setRight(newNode);
        } else {

        }
    }

    @Override
    public Boolean search(Integer value) {
        boolean out = false;
        TreeNode tempNode = search(value, root);
        out = tempNode.getData() == value;
        return out;
    }

    public TreeNode search(Integer value, TreeNode treeNode) {
        TreeNode out = treeNode;
        if (treeNode.getData() < value & treeNode.getRight() != null) {
            return search(value, treeNode.getRight());
        } else if (treeNode.getData() > value & treeNode.getLeft() != null) {
            return search(value, treeNode.getLeft());
        } else if (treeNode.getData() == value) {
            out = treeNode;
        }
        return out;
    }

    @Override
    public List getTraversalList() {
        return super.getTraversalList();
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
