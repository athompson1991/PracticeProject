package com.preparation.datastructures.trees;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by Alex on 2/15/2017 at 1:09 PM.
 */
@Data
public class TreeNode {
    private Integer data;
    private TreeNode left;
    private TreeNode right;
    private TreeNode parent;

    TreeNode(Integer data){
        this.data = data;
    }

    TreeNode(Integer data, TreeNode left, TreeNode right){
        this.data = data;
        this.left = left;
        this.right = right;
        this.left.setParent(this);
        this.right.setParent(this);
    }

    public Boolean isLeaf() {
        return this.left == null & this.right == null;
    }


}
