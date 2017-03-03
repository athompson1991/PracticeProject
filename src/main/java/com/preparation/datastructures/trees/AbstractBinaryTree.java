package com.preparation.datastructures.trees;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by aleth on 2/17/2017.
 */
public abstract class AbstractBinaryTree implements BinaryTree {

    @Getter
    @Setter
    protected AbstractBinaryTree parent;
    @Getter
    @Setter
    protected AbstractBinaryTree left;
    @Getter
    @Setter
    protected AbstractBinaryTree right;
    @Getter
    @Setter
    protected Integer data;

    @Getter
    @Setter
    protected Visitor visitor;
    @Getter
    @Setter
    protected Integer size;
    @Getter
    @Setter
    protected Integer height;
    @Getter
    @Setter
    protected Integer depth;


    AbstractBinaryTree() {
        this.parent = null;
        this.left = null;
        this.right = null;
        this.data = null;

        this.visitor = new Visitor();
        this.size = 0;
        this.height = null;
        this.depth = null;
    }

    AbstractBinaryTree(Integer data) {
        this();
        this.data = data;
        this.size = 1;
        this.height = 0;
        this.depth = 0;
    }

    public void traverseInOrder() {
        visitor.setValuesList(new LinkedList());
        traverseInOrder(this);
    }

    public void traversePreOrder() {
        visitor.setValuesList(new LinkedList());
        traversePreOrder(this);
    }

    public void traversePostOrder() {
        visitor.setValuesList(new LinkedList());
        traversePostOrder(this);
    }

    private void traverseInOrder(AbstractBinaryTree treeNode) {
        if (treeNode.getLeft() != null) traverseInOrder(treeNode.getLeft());
        visitor.addValue(treeNode);
        if (treeNode.getRight() != null) traverseInOrder(treeNode.getRight());
    }

    public void traversePreOrder(AbstractBinaryTree treeNode) {
        visitor.addValue(treeNode);
        if (treeNode.getLeft() != null) traversePreOrder(treeNode.getLeft());
        if (treeNode.getRight() != null) traversePreOrder(treeNode.getRight());
    }

    private void traversePostOrder(AbstractBinaryTree treeNode) {
        if (treeNode.getLeft() != null) traversePostOrder(treeNode.getLeft());
        if (treeNode.getRight() != null) traversePostOrder(treeNode.getRight());
        visitor.addValue(treeNode);
    }

    public void traverseLevelOrder() {
        visitor.setValuesList(new LinkedList());
        Queue<AbstractBinaryTree> queue = new LinkedBlockingQueue<>();
        queue.add(this);
        while (!queue.isEmpty()) {
            Integer temp = dequeueValue(queue);
            visitor.addValue(temp);
        }
    }

    private Integer dequeueValue(Queue<AbstractBinaryTree> printQueue) {
        AbstractBinaryTree poppedElement = printQueue.remove();
        if (poppedElement.getLeft() != null) printQueue.add(poppedElement.getLeft());
        if (poppedElement.getRight() != null) printQueue.add(poppedElement.getRight());
        return poppedElement.getData();
    }

    @Data
    private class Visitor {
        private List valuesList;

        void visit(AbstractBinaryTree node) {
            System.out.print(node.getData() + "  ");
        }

        void addValue(AbstractBinaryTree node) {
            valuesList.add(node.getData());
        }

        void addValue(Integer value) {
            valuesList.add(value);
        }
    }

    @Override
    public String toString() {
        String out = String.format("Height: %d\nDepth: %d\nData: %d\nSize: %d", this.height, this.depth, this.data, this.size);
        return out;
    }

}
