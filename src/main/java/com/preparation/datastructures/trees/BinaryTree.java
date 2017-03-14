package com.preparation.datastructures.trees;

import java.util.List;

/**
 * Created by Alex on 2/15/2017 at 12:51 PM.
 */
public interface BinaryTree<E> {
    void add(E value);

    void delete(E value);

    Boolean search(E value);

    BinaryTree get(E value);

    Boolean isEmpty();
    Integer getHeight();
    Integer getDepth();

    void traverseInOrder();
    void traversePreOrder();
    void traversePostOrder();
    void traverseLevelOrder();
}
