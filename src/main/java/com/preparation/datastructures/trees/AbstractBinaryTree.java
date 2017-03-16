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
public abstract class AbstractBinaryTree<Object> implements BinaryTree<Object> {

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
        visitor.setNodeListing(new LinkedList());
        traverseInOrder(this);
    }

    public void traversePreOrder() {
        visitor.setNodeListing(new LinkedList());
        traversePreOrder(this);
    }

    public void traversePostOrder() {
        visitor.setNodeListing(new LinkedList());
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
        visitor.setNodeListing(new LinkedList());
        Queue<AbstractBinaryTree> queue = new LinkedBlockingQueue<>();
        queue.add(this);
        while (!queue.isEmpty()) {
            AbstractBinaryTree temp = dequeueValue(queue);
            visitor.addValue(temp);
        }
    }

    private AbstractBinaryTree dequeueValue(Queue<AbstractBinaryTree> printQueue) {
        AbstractBinaryTree poppedElement = printQueue.remove();
        if (poppedElement.getLeft() != null) printQueue.add(poppedElement.getLeft());
        if (poppedElement.getRight() != null) printQueue.add(poppedElement.getRight());
        return poppedElement;
    }


    public List treeListInOrder() {
        return visitor.getNodeListing();
    }


    @Data
    private class Visitor {
        public List<AbstractBinaryTree> nodeListing;

        void addValue(AbstractBinaryTree node) {
            nodeListing.add(node);
        }

    }

    @Override
    public String toString() {
        String out = String.format("Height: %d\nDepth: %d\nData: %d\nSize: %d", this.height, this.depth, this.data, this.size);
        return out;
    }

    public Boolean isEmpty() {
        return size == 0;
    }

}
