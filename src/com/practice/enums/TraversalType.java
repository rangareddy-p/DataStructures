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
     * nodes only on the boundaries of the tree
     */
    BOUNDARY_TRAVERSAL
}
