package com.preparation.datastructures.trees;


import sun.awt.image.ImageWatched;

import java.util.NoSuchElementException;

/**
 * Created by Alex on 2/15/2017 at 1:19 PM.
 */
public class LinkedBinarySearchTree extends AbstractBinaryTree<Integer> {

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
        AbstractBinaryTree deleteThis = get(value, this);
        AbstractBinaryTree parentNode = deleteThis.getParent();

        boolean twoKids = deleteThis.getLeft() != null & deleteThis.getRight() != null;
        boolean leaf = deleteThis.getLeft() == null & deleteThis.getRight() == null;
        boolean oneKid = !twoKids & !leaf;

        boolean deletionIsLeft = deleteThis.getData() < deleteThis.getParent().getData();

        AbstractBinaryTree replacement;
        if (oneKid) {
            boolean replacementToLeft = deleteThis.getLeft() != null;
            if (replacementToLeft) {
                replacement = deleteThis.getLeft();
                replacement.setParent(parentNode);
                replaceForParent(parentNode, replacement, deletionIsLeft);
            } else {
                replacement = deleteThis.getRight();
                replacement.setParent(parentNode);
                replaceForParent(parentNode, replacement, deletionIsLeft);
            }
        } else if (twoKids) {
            LinkedBinarySearchTree rightKid = (LinkedBinarySearchTree) deleteThis.getRight();
            LinkedBinarySearchTree rightMin = (LinkedBinarySearchTree) rightKid.min();
            rightMin.getParent().setLeft(null);
            rightMin.setParent(parentNode);
            rightMin.setLeft(deleteThis.left);
            rightMin.setRight(deleteThis.right);
            deleteThis.getRight().setParent(rightMin);
            deleteThis.getLeft().setParent(rightMin);
            replaceForParent(parentNode, rightMin, deletionIsLeft);
        } else {
            replaceForParent(parentNode, null, deletionIsLeft);
        }
    }

    private void replaceForParent(AbstractBinaryTree parentNode, AbstractBinaryTree replacement, boolean logic) {
        if (logic)
            parentNode.setLeft(replacement);
        else
            parentNode.setRight(replacement);
    }

    @Override
    public Boolean search(Integer value) {
        return get(value, this) != null;
    }

    @Override
    public AbstractBinaryTree get(Integer value) {
        return get(value, this);
    }

    private AbstractBinaryTree get(Integer value, AbstractBinaryTree tree) {
        AbstractBinaryTree out;
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

    public LinkedBinarySearchTree max() {
        return minOrMax(this, false);
    }

    public LinkedBinarySearchTree min() {
        return minOrMax(this, true);
    }

    private LinkedBinarySearchTree minOrMax(LinkedBinarySearchTree tree, boolean isLeft) {
        LinkedBinarySearchTree out = tree;
        if (isLeft) {
            if (tree.getLeft() != null)
                out = minOrMax((LinkedBinarySearchTree) tree.getLeft(), true);
        } else {
            if (tree.getRight() != null)
                out = minOrMax((LinkedBinarySearchTree) tree.getRight(), false);
        }
        return out;
    }

}
