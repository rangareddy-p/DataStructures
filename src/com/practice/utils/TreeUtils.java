package com.practice.utils;


import com.practice.binary_trees.TreeTraversals.Node;

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
    public static int getHeight(Node node){
        if(node != null){
            int left = getHeight(node.getLeft());
            int right = getHeight(node.getRight());
            return Math.max(left, right) + 1;
        }
        return 0;
    }

    public static int getSize(Node node){
        if(node != null){
            return getSize(node.getLeft()) + getSize(node.getRight()) + 1;
        }
        return 0;
    }

    public static boolean areTreesIdentical(Node node1, Node node2){
        return node1 != null && node2 != null && node1.getData() == node2.getData() &&
                areTreesIdentical(node1.getLeft(), node2.getLeft()) &&
                areTreesIdentical(node1.getRight(), node2.getRight());
    }

    /**
     * Deletes the entire binary tree
     *
     * @param root
     */
    public static void deleteTree(Node root){
        System.out.println("Deleted tree nodes are = ");
        deleteTreeRec(root);
        System.out.println();
    }

    /**
     * Helper method to delete a binary tree
     *
     * @param node
     */
    private static void deleteTreeRec(Node node) {
        if(node != null){
            deleteTreeRec(node.getLeft());
            deleteTreeRec(node.getRight());
            System.out.print(node.getData()+" ");
            node = null;
        }
    }
}