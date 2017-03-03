package com.preparation.datastructures.trees;

import java.util.List;

/**
 * Created by Alex on 2/15/2017 at 12:51 PM.
 */
public interface BinaryTree {
    void add(Integer value);
    void delete(Integer value);
    Boolean search(Integer value);
    BinaryTree get(Integer value);

    Boolean isEmpty();
    Boolean isComplete();

    Integer getHeight();
    Integer getDepth();

    Object getData();

    BinaryTree getLeft();

    BinaryTree getRight();

    BinaryTree min();

    BinaryTree max();

    void traverseInOrder();
    void traversePreOrder();
    void traversePostOrder();
    void traverseLevelOrder();
}
