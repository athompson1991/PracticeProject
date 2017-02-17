package com.preparation.datastructures.trees;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by aleth on 2/17/2017.
 */
public abstract class AbstractBinaryTree implements BinaryTree {

    protected TreeNode root;
    protected Visitor visitor;
    protected Integer size;

    private class Visitor {
        void visit(TreeNode node) {
            System.out.print(node.getData() + "  ");
        }
    }

    AbstractBinaryTree() {
        this.root = null;
        this.visitor = new Visitor();
        this.size = 0;
    }

    AbstractBinaryTree(Integer value) {
        TreeNode treeNode = new TreeNode(value);
        this.root = treeNode;
        this.visitor = new Visitor();
        this.size = 1;
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

    public Integer getSize() {
        return size;
    }

    public void print() {

    }

    public void traverseInOrder() {
        traverseInOrder(root);
    }

    public void traversePreOrder() {
        traversePreOrder(root);
    }

    public void traversePostOrder() {
        traversePostOrder(root);
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
