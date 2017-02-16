package com.preparation.datastructures.trees;

import sun.reflect.generics.tree.Tree;

import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Alex on 2/15/2017 at 1:19 PM.
 */
public class LinkedBinarySearchTree implements BinaryTree {


    private TreeNode root;
    private Visitor visitor;

    private class Visitor {
        void visit(TreeNode node) {
            System.out.print(node.getData() + "  ");
        }
    }

    public LinkedBinarySearchTree() {
        root = null;
        visitor = new Visitor();
    }

    public LinkedBinarySearchTree(Integer rootValue) {
        root = new TreeNode(rootValue);
        visitor = new Visitor();
    }

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
    }

    public void delete(Integer value) {
        if(!search(value))
            throw new NoSuchElementException("Value not in tree.");
        else {

        }

    }

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
        } else if (treeNode.getData() == value){
            out = true;
        }
        return out;
    }

    public TreeNode get(Integer value) {
        return null;
    }

    public Boolean isComplete() {
        return null;
    }

    public Boolean isFull() {
        return null;
    }

    public Integer getHeight() {
        return null;
    }

    public void print() {

    }

    @Override
    public void traverseInOrder() {
        traverseInOrder(root);
    }

    private void traverseInOrder(TreeNode treeNode) {
        if (treeNode.getLeft() != null) traverseInOrder(treeNode.getLeft());
        visitor.visit(treeNode);
        if (treeNode.getRight() != null) traverseInOrder(treeNode.getRight());
    }


    public void traversePreOrder(TreeNode treeNode) {
        visitor.visit(treeNode);
        if (treeNode.getLeft() != null) traversePreOrder(treeNode.getLeft());
        if (treeNode.getRight() != null) traversePreOrder(treeNode.getRight());
    }

    public void traversePreOrder() {
        traversePreOrder(root);
    }

    public void traversePostOrder() {
        traversePostOrder(root);
    }

    private void traversePostOrder(TreeNode treeNode) {
        if (treeNode.getLeft() != null) traversePostOrder(treeNode.getLeft());
        if (treeNode.getRight() != null) traversePostOrder(treeNode.getRight());
        visitor.visit(treeNode);
    }

    public void traverseLevelOrder() {
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            dequeuePrint(queue);
        }
    }

    private void dequeuePrint(Queue<TreeNode> printQueue) {
        TreeNode poppedElement = printQueue.remove();
        if (poppedElement.getLeft() != null) printQueue.add(poppedElement.getLeft());
        if (poppedElement.getRight() != null) printQueue.add(poppedElement.getRight());
        System.out.print(poppedElement.getData() + "  ");

    }
}
