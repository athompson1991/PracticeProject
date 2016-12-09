package com.preparation.datastructures.trees;

import java.util.Comparator;

/**
 * Created by aleth on 12/8/16.
 */
public class BinarySearchTree<E> {

    private BinaryTreeNode<E> root = null;
    private Comparator<E> comparator;

    public BinarySearchTree() {
        this(null);
    }

    public BinarySearchTree(Comparator<E> c) {
        comparator = c;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void setRoot(BinaryTreeNode<E> root) {
        this.root = root;
    }

    public BinaryTreeNode<E> getRoot() {
        return root;
    }

    public int compare(E x, E y) {
        if (comparator == null) {
            return((Comparable<E>)x).compareTo(y);
        } else {
            return comparator.compare(x, y);
        }
    }

    public void insert(E data) {
        if(isEmpty()) root = new LinkedBinaryTreeNode<E>(data);
        BinaryTreeNode<E> n = root;
        while(true) {
            int comparisonResult = compare(data, n.getData());
            if (comparisonResult == 0) {
                n.setData(data);
                return;
            } else if (comparisonResult < 0) {
                if(n.getLeft() == null) {
                    n.setLeft(new LinkedBinaryTreeNode<E>(data));
                    return;
                }
                n = n.getLeft();
            } else {
                if(n.getRight() == null) {
                    n.setRight(new LinkedBinaryTreeNode<E>(data));
                    return;
                }
                n = n.getRight();
            }
        }
    }
}
