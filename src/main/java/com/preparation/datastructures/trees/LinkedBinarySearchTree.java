package com.preparation.datastructures.trees;



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
        }
        else {
            add(value, this);
        }
    }

    private void add(Integer value, AbstractBinaryTree tree) {
        tree.setSize(tree.getSize() + 1);
        if (value < tree.getData()) {
            if (tree.getLeft() == null) {
                AbstractBinaryTree newNode = new LinkedBinarySearchTree(value);
                newNode.setParent(tree);
//                newNode.setDepth(tree.depth+1);
                tree.setLeft(newNode);
            } else {
                add(value, tree.getLeft());
            }
        } else {
            if (tree.getRight() == null) {
                AbstractBinaryTree newNode = new LinkedBinarySearchTree(value);
                newNode.setParent(tree);
//                newNode.setDepth(tree.getDepth() + 1);
                tree.setRight(newNode);
            } else add(value, tree.getRight());
        }
    }

    @Override
    public void delete(Integer value) {

    }

    @Override
    public Boolean search(Integer value) {
        return null;
    }

    @Override
    public BinaryTree get(Integer value) {
        return null;
    }

    @Override
    public Boolean isEmpty() {
        return null;
    }

    @Override
    public Boolean isComplete() {
        return null;
    }
}
