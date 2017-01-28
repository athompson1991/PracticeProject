package com.preparation.datastructures.trees;

/**
 * Created by aleth on 1/19/2017.
 */
public class SimpleVisitor implements BinaryTreeNode.Visitor {
    @Override
    public <E> void visit(BinaryTreeNode<E> node) {
        node.print();
    }
}
