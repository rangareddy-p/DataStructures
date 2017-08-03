package com.practice.utils;


import com.practice.binary_trees.TreeTraversals;

public class TreeUtils {

    public static int getHeight(TreeTraversals.Node node){
        if(node != null){
            int left = getHeight(node.getLeft());
            int right = getHeight(node.getRight());
            return Math.max(left, right) + 1;
        }
        return 0;
    }
}
