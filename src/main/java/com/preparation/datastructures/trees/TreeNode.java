package com.preparation.datastructures.trees;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by Alex on 2/15/2017 at 1:09 PM.
 */
public class TreeNode {
    @Getter @Setter private Integer data;
    @Getter @Setter private TreeNode left;
    @Getter @Setter private TreeNode right;

    TreeNode(Integer data){
        this.data = data;
    }

    TreeNode(Integer data, TreeNode left, TreeNode right){
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public Boolean isLeaf() {
        return this.left == null & this.right == null;
    }

    public int numberOfChildren() {
        int out = 0;
        if (this.left != null & this.right == null) out = 1;
        if (this.left == null & this.right != null) out = 1;
        if (this.left != null & this.right != null) out = 2;
        return out;
    }
}
