package com.practice.utils;


import com.practice.binary_trees.TreeTraversals;

/**
 * Utils class for Binary trees
 */
public class TreeUtils {

    /**
     * Gets the height of a given binary tree
     *
     * @param node binary tree node
     * @return height of a binary tree
     */
    public static int getHeight(TreeTraversals.Node node){
        if(node != null){
            int left = getHeight(node.getLeft());
            int right = getHeight(node.getRight());
            return Math.max(left, right) + 1;
        }
        return 0;
    }
}
