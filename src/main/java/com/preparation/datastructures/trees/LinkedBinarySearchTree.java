package com.preparation.datastructures.trees;


import java.util.NoSuchElementException;

/**
 * Created by Alex on 2/15/2017 at 1:19 PM.
 */
public class LinkedBinarySearchTree extends AbstractBinaryTree implements BinaryTree {

    LinkedBinarySearchTree() {
        super();
    }

    LinkedBinarySearchTree(Integer data) {
        super(data);
    }

    LinkedBinarySearchTree(Integer data, AbstractBinaryTree parent) {
        super(data);
        this.depth = parent.getDepth() + 1;
        this.height = 0;
    }

    @Override
    public void add(Integer value) {
        if (this.getData() == null) {
            this.setData(value);
            this.setHeight(0);
            this.setDepth(0);
            this.setSize(1);
        } else add(value, this);
    }

    private void add(Integer value, AbstractBinaryTree tree) {
        tree.setSize(tree.getSize() + 1);
        if (value < tree.getData()) {
            if (tree.getLeft() == null) this.addHelper(value, tree);
            else add(value, tree.getLeft());
        } else {
            if (tree.getRight() == null) this.addHelper(value, tree);
            else add(value, tree.getRight());
        }
    }

    private void addHelper(Integer value, AbstractBinaryTree originalTree) {
        boolean isLeft = value < originalTree.getData();
        AbstractBinaryTree newNode = new LinkedBinarySearchTree(value);
        newNode.setParent(originalTree);
        newNode.setDepth(originalTree.getDepth() + 1);
        if (isLeft)
            originalTree.setLeft(newNode);
        else
            originalTree.setRight(newNode);
        reassignHeights(newNode);
    }

    private void reassignHeights(AbstractBinaryTree node) {
        AbstractBinaryTree parent = node.parent;
        if (parent == null) {
            node.height += 1;
        } else if (node.getHeight() == parent.getHeight()) {
            parent.height += 1;
            reassignHeights(parent);
        }
    }


    public void delete(Integer value) {
        BinaryTree deleteThis = get(value, this);
        boolean twoKids = deleteThis.getLeft() != null & deleteThis.getRight() != null;
        if (!twoKids) {

        } else {

        }
    }

    @Override
    public Boolean search(Integer value) {
        return get(value, this) != null;
    }

    @Override
    public BinaryTree get(Integer value) {
        return get(value, this);
    }

    private BinaryTree get(Integer value, AbstractBinaryTree tree) {
        BinaryTree out;
        if (value.equals(tree.getData()))
            out = tree;
        else {
            boolean goLeft = value < tree.getData();
            if (goLeft) {
                if (tree.getLeft() == null)
                    throw new NoSuchElementException("Not in tree.");
                else
                    out = get(value, tree.getLeft());
            } else {
                if (tree.getRight() == null)
                    throw new NoSuchElementException("Not in tree");
                else out = get(value, tree.getRight());
            }
        }
        return out;
    }


    public AbstractBinaryTree max() {
        return null;
    }

    public AbstractBinaryTree min() {
        return min(this);
    }

    private AbstractBinaryTree min(AbstractBinaryTree tree) {
        AbstractBinaryTree out = tree;
        if (tree.getLeft() != null)
            out = min(tree.getLeft());
        return out;
    }

    @Override
    public Boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Boolean isComplete() {
        return null;
    }
}
