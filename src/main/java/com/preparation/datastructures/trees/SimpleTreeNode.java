package com.preparation.datastructures.trees;

import java.util.List;

/**
 * Created by aleth on 12/5/2016.
 */
public interface SimpleTreeNode<E> {
    E getData();
    void setData(E data);
    SimpleTreeNode<E> getParent();
    List<? extends SimpleTreeNode<E>> getChildren();
    void insertChildAt(int index, SimpleTreeNode<E> child);
    void removeFromParent();
    void traversePreorder(Visitor<E> visitor);
    void traversePostorder(Visitor<E> visitor);
    void traverseBreadthFirst(Visitor<E> visitor);

    public interface Visitor<E> {
        void visit(SimpleTreeNode<E> node);
    }
}
