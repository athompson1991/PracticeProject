package com.preparation.datastructures.trees;

/**
 * Created by Alex on 2/15/2017 at 12:51 PM.
 */
public interface BinaryTree {
    void add(Integer value);
    void delete(Integer value);
    Boolean search(Integer value);
    TreeNode get(Integer value);
    Boolean isComplete();
    Boolean isFull();
    Integer getHeight();
    void print();
    void traverseInOrder();
    void traversePreOrder();
    void traversePostOrder();
    void traverseLevelOrder();
}
