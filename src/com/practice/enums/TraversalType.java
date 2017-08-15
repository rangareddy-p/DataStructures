package com.practice.enums;

public enum TraversalType {

    /**
     * Left, Root, Right in order
     */
    INORDER,

    /**
     * Root, Left, Right in order
     */
    PREORDER,

    /**
     * Left, Right, Root in order
     */
    POSTORDER,

    /**
     * nodes at each level
     */
    LEVEL_ORDER,

    /**
     * nodes at each level from bottom to top
     */
    REVERSE_LEVEL_ORDER,

    /**
     * nodes in spiral order
     */
    SPIRAL_LEVEL_ORDER,

    /**
     * Perfect binary tree specific level order traversal
     * <a href="http://www.geeksforgeeks.org/perfect-binary-tree-specific-level-order-traversal">
     *     Perfect Binary Tree Specific Level Order Traversal</a>
     */
    SPECIFIC_LEVEL_ORDER,

    /**
     * nodes only on the boundaries of the tree
     */
    BOUNDARY_TRAVERSAL,

    /**
     * nodes in vertical order
     */
    VERTICAL_ORDER
}
