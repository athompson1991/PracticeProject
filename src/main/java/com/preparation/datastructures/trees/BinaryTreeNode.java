package com.preparation.datastructures.trees;

/**
 * Created by aleth on 12/6/2016.
 */
public interface BinaryTreeNode<E> {
    void setData(E data);

    E getData();

    BinaryTreeNode<E> getParent();

    BinaryTreeNode<E> getLeft();

    BinaryTreeNode<E> getRight();

    void setLeft(BinaryTreeNode<E> data);

    void setRight(BinaryTreeNode<E> data);

    void removeFromParent();

    void traversePreorder(BinaryTreeNode.Visitor visitor);

    void traversePostorder(BinaryTreeNode.Visitor visitor);

    void traverseInorder(BinaryTreeNode.Visitor visitor);

    public interface Visitor {
        <E> void visit(BinaryTreeNode<E> node);
    }
}
