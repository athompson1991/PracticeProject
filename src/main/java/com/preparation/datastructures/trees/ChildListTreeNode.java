package com.preparation.datastructures.trees;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by aleth on 12/5/2016.
 */
public class ChildListTreeNode<E> implements SimpleTreeNode<E> {

    private E data;
    private ChildListTreeNode<E> parent = null;
    private LinkedList<ChildListTreeNode<E>> children = new LinkedList<ChildListTreeNode<E>>();

    public ChildListTreeNode(E data) {
        this.data = data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public E getData() {
        return data;
    }

    public List<? extends SimpleTreeNode<E>> getChildren() {
        return children;
    }

    public void insertChildAt(int index, SimpleTreeNode<E> child) {

        for(ChildListTreeNode node = this; node != null; node = node.parent) {
            if (node == child) {
                throw new IllegalArgumentException();
            }
        }

        ChildListTreeNode<E> childNode = (ChildListTreeNode<E>)child;
        children.add(index, childNode);

        if(childNode != null) {
            childNode.removeFromParent();
            childNode.parent = this;
        }
    }

    public void removeFromParent() {
        if (parent != null) {
            parent.children.remove(this);
            parent = null;
        }
    }

    public void traverseBreadthFirst(Visitor<E> visitor) {

    }

    public void traversePostorder(Visitor<E> visitor) {

    }

    public void traversePreorder(Visitor<E> visitor) {
        visitor.visit(this);
        for (SimpleTreeNode<E> child : children) {
            child.traversePreorder(visitor);
        }
    }

    public SimpleTreeNode<E> getParent() {
        return parent;
    }

}
