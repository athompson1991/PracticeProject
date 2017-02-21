package com.preparation.datastructures.trees;

import lombok.Data;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by aleth on 2/17/2017.
 */
public abstract class AbstractBinaryTree implements BinaryTree {

    protected TreeNode root;
    protected Visitor visitor;
    protected Integer size;

    @Data
    private class Visitor {
        private List valuesList;

        void visit(TreeNode node) {
            System.out.print(node.getData() + "  ");
        }

        void addValue(TreeNode node) {
            valuesList.add(node.getData());
        }

        void addValue(Integer value) {
            valuesList.add(value);
        }
    }

    AbstractBinaryTree() {
        this.root = null;
        this.visitor = new Visitor();
        this.size = 0;
    }

    AbstractBinaryTree(TreeNode root) {
        this.root = root;
        this.visitor = new Visitor();
        this.traverseLevelOrder();
        this.size = this.getTraversalList().size();
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

    public TreeNode getMin() {
        return getMinOrMax(root, "min");
    }

    private TreeNode getMinOrMax(TreeNode treeNode, String option) {
        TreeNode out = null;
        if (treeNode.isLeaf())
            out = treeNode;
        else {
            if (option == "min")
                getMinOrMax(treeNode.getLeft(), "min");
            else if (option == "max")
                getMinOrMax(treeNode.getRight(), "max");
        }
        return out;
    }

    public TreeNode getMax() {
        return getMinOrMax(root, "max");
    }

    public void print() {

    }

    public List getTraversalList() {
        return visitor.getValuesList();
    }

    public void traverseInOrder() {
        visitor.setValuesList(new LinkedList());
        traverseInOrder(root);
    }

    public void traversePreOrder() {
        visitor.setValuesList(new LinkedList());
        traversePreOrder(root);
    }

    public void traversePostOrder() {
        visitor.setValuesList(new LinkedList());
        traversePostOrder(root);
    }

    private void traverseInOrder(TreeNode treeNode) {
        if (treeNode.getLeft() != null) traverseInOrder(treeNode.getLeft());
        visitor.visit(treeNode);
        visitor.addValue(treeNode);
        if (treeNode.getRight() != null) traverseInOrder(treeNode.getRight());
    }

    public void traversePreOrder(TreeNode treeNode) {
        visitor.visit(treeNode);
        visitor.addValue(treeNode);
        if (treeNode.getLeft() != null) traversePreOrder(treeNode.getLeft());
        if (treeNode.getRight() != null) traversePreOrder(treeNode.getRight());
    }

    private void traversePostOrder(TreeNode treeNode) {
        if (treeNode.getLeft() != null) traversePostOrder(treeNode.getLeft());
        if (treeNode.getRight() != null) traversePostOrder(treeNode.getRight());
        visitor.visit(treeNode);
        visitor.addValue(treeNode);
    }

    public void traverseLevelOrder() {
        visitor.setValuesList(new LinkedList());
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Integer temp = dequeueValue(queue);
            System.out.print(temp + "  ");
            visitor.addValue(temp);
        }
    }

    private Integer dequeueValue(Queue<TreeNode> printQueue) {
        TreeNode poppedElement = printQueue.remove();
        if (poppedElement.getLeft() != null) printQueue.add(poppedElement.getLeft());
        if (poppedElement.getRight() != null) printQueue.add(poppedElement.getRight());
        return poppedElement.getData();
    }


}
