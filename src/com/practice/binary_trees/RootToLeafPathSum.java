package com.practice.binary_trees;

import com.practice.binary_trees.TreeTraversals.Node;

public class RootToLeafPathSum {

    /**
     * Returns if sum of all node values from root to leaf is equal to the given value
     *
     * @param node
     * @param sum
     * @return true, if root to leaf sum is equal to the given value
     */
    private boolean hasRootToLeafPathSum(Node node, int sum){
        if(node == null && sum == 0){
            return true;
        }

        if(node != null){
            int remainingSum = sum - node.getData();
            if(node.getLeft() == null && node.getRight() == null && remainingSum == 0){
                    return true;
            }

            if(hasRootToLeafPathSum(node.getLeft(), remainingSum) ||
                    hasRootToLeafPathSum(node.getRight(), remainingSum)){
                return true;
            }
        }
        return false;
    }
}
