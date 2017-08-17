package com.practice.binary_trees;

import com.practice.binary_trees.TreeTraversals.Node;

import java.util.ArrayList;
import java.util.List;

public class RootToLeafPath {


    /**
     * Prints all the root to leaf paths
     *
     * @param node
     */
    private void printAllRootToLeafPaths(Node node) {
        List<Node> list = new ArrayList<>();
        printAllRootToLeafPathsRec(node, list);
    }

    /**
     * Helper method that prints all the root to leaf paths
     *
     * @param node
     * @param list
     */
    private void printAllRootToLeafPathsRec(Node node, List<Node> list) {
        if (node == null) {
            return;
        }

        list.add(node);
        if (node.getLeft() == null && node.getRight() == null) {
            for (Node printNode : list) {
                System.out.print(printNode.getData() + " ");
            }
        } else {
            printAllRootToLeafPathsRec(node.getLeft(), list);
            printAllRootToLeafPathsRec(node.getRight(), list);
        }
    }

    /**
     * Returns if sum of all node values from root to leaf is equal to the given value
     *
     * @param node
     * @param sum
     * @return true, if root to leaf sum is equal to the given value
     */
    private boolean hasRootToLeafPathSum(Node node, int sum) {
        if (node == null && sum == 0) {
            return true;
        }

        if (node != null) {
            int remainingSum = sum - node.getData();
            if (node.getLeft() == null && node.getRight() == null && remainingSum == 0) {
                return true;
            }

            if (hasRootToLeafPathSum(node.getLeft(), remainingSum) ||
                    hasRootToLeafPathSum(node.getRight(), remainingSum)) {
                return true;
            }
        }
        return false;
    }
}
