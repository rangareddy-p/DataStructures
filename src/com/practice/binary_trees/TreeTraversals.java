package com.practice.binary_trees;

import com.practice.enums.FunctionType;
import com.practice.enums.TraversalType;
import com.practice.utils.TreeUtils;

import java.util.*;

/**
 * Different types of Tree traversals for Binary tree
 */
public class TreeTraversals {
    private Node root;

    public TreeTraversals(Node root) {
        this.root = root;
    }

    public static void main(String[] args) {
        System.out.println("main");
    }

    /**
     * Prints any type of tree traversal based on the traversal type and function type
     *
     * @param traversalType
     * @param functionType
     */
    public void printTreeTraversals(TraversalType traversalType, FunctionType functionType) {
        switch (traversalType) {
            case INORDER:
                printInorderTraversal(functionType);
                break;
            case PREORDER:
                printPreorderTraversal(functionType);
                break;
            case POSTORDER:
                printPostorderTraversal(functionType);
                break;
            case LEVEL_ORDER:
                printLevelOrderTraversal(functionType);
                break;
            case REVERSE_LEVEL_ORDER:
                printReverseLevelOrder(functionType);
                break;
            case SPIRAL_LEVEL_ORDER:
                printSpiralLevelOrder(functionType);
                break;
            case SPECIFIC_LEVEL_ORDER:
                printSpecificLevelOrder(functionType);
                break;
            case BOUNDARY_TRAVERSAL:
                printBoundaryTraversal(functionType);
                break;
            case VERTICAL_ORDER:
                printVerticalOrderTraversal(functionType);
                break;
            default:
                System.out.println(traversalType.name() + " Not Yet Implemented !!");
                break;
        }
    }

    /**
     * Prints Inorder tree traversal
     */
    private void printInorderTraversal(FunctionType functionType) {
        Node node = root;
        switch (functionType) {
            case RECURSIVE:
                printRecursiveInorderTraversal(node);
                break;
            case ITERATIVE:
                printIterativeInorderTraversal(node);
                break;
            case MORRIS:
                printInorderMorrisTraversal(node);
                break;
            default:
                System.out.println(functionType.name() + " Not Yet Implemented !!");
                break;
        }
        System.out.println();
    }

    /**
     * Prints Preorder tree traversal
     */
    private void printPreorderTraversal(FunctionType functionType) {
        Node node = root;
        switch (functionType) {
            case RECURSIVE:
                printRecursivePreorderTraversal(node);
                break;
            case ITERATIVE:
                printIterativePreorderTraversal(node);
                break;
            case MORRIS:
                printPreOrderMorrisTraversal(node);
                break;
            default:
                System.out.println(functionType.name() + " Not Yet Implemented !!");
                break;
        }
        System.out.println();
    }

    /**
     * Prints post order tree traversal
     *
     * @param functionType
     */
    private void printPostorderTraversal(FunctionType functionType) {
        Node node = root;
        switch (functionType) {
            case RECURSIVE:
                printRecursivePostorderTraversal(node);
                break;
            case ITERATIVE:
                printIterativePostorderTraversal(node);
                break;
            default:
                System.out.println(functionType.name() + " Not Yet Implemented !!");
                break;
        }
        System.out.println();
    }

    /**
     * Prints level order tree traversal
     *
     * @param functionType
     */
    private void printLevelOrderTraversal(FunctionType functionType) {
        Node node = root;
        switch (functionType) {
            case ITERATIVE:
                printIterativeLevelOrderTraversal(node);
                break;
            case RECURSIVE:
                printRecursiveLevelOrderTraversal(node);
                break;
            default:
                System.out.println(functionType.name() + " Not Yet Implemented !!");
                break;
        }
        System.out.println();
    }

    /**
     * Print reverse level order traversal for a binary tree
     *
     * @param functionType
     */
    private void printReverseLevelOrder(FunctionType functionType) {
        Node node = root;
        switch (functionType) {
            case ITERATIVE:
                printIterativeReverseLevelOrderTraversal(node);
                break;
            case RECURSIVE:
                printRecursiveReverseLeveOrderTraversal(node);
                break;
            default:
                System.out.println(functionType.name() + " Not Yet Implemented !!");
                break;
        }
    }

    /**
     * Print all the nodes in spiral level order format
     *
     * @param functionType
     */
    private void printSpiralLevelOrder(FunctionType functionType) {
        Node node = root;
        switch (functionType) {
            case ITERATIVE:
                printIterativeSpiralLevelOrderTraversal(node);
                break;
            case RECURSIVE:
                printRecursiveSpiralLevelOrderTraversal(node);
                break;
            default:
                System.out.println(functionType.name() + " Not Yet Implemented !!");
                break;
        }
    }

    /**
     * Prints perfect binary tree specific level order traversal
     * @see <a href="http://www.geeksforgeeks.org/perfect-binary-tree-specific-level-order-traversal">
     *     Perfect Binary Tree Specific Level Order Traversal</a>
     * @param functionType
     */
    private void printSpecificLevelOrder(FunctionType functionType) {
        Node node = root;
        switch (functionType){
            case ITERATIVE:
                printIterativeSpecificLevelOrder(node);
                break;
            default:
                System.out.println(functionType.name() + " Not Yet Implemented !!");
                break;
        }
    }

    /**
     * Prints all the boundary nodes in a tree based on the function type
     *
     * @param functionType
     */
    private void printBoundaryTraversal(FunctionType functionType) {
        Node current = root;
        switch (functionType) {
            case RECURSIVE:
                printRecursiveBoundaryTraversal(current);
                break;
            default:
                System.out.println(functionType.name() + " Not Yet Implemented !!");
                break;
        }
    }

    /**
     * Prints vertical order traversal
     *
     * @param functionType
     */
    private void printVerticalOrderTraversal(FunctionType functionType) {
        Node node = root;
        switch (functionType) {
            case RECURSIVE:
                printRecursiveVerticalOrderTraversal(node);
                break;
            default:
                System.out.println(functionType.name() + " Not Yet Implemented !!");
                break;
        }
    }

    /**
     * Iterative Implementation for Inorder Tree traversal
     *
     * @param node
     */
    private void printIterativeInorderTraversal(Node node) {
        Stack<Node> stack = new Stack<>();
        if (node != null) {
            stack.push(node);
        }
        while (node != null && !stack.isEmpty()) {
            if (node.left != null) {
                stack.push(node.left);
                node = node.left;
            } else {
                node = stack.pop();
                System.out.print(node.data + " ");
                if (node.right != null) {
                    node = node.right;
                    stack.push(node);
                }
            }
        }
    }

    /**
     * Iterative Implementation 2 for Inorder tree traversal
     *
     * @param node
     */
    private void printIterativeInorderTraversal2(Node node) {
        Stack<Node> stack = new Stack<>();
        while (true) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (stack.isEmpty()) {
                break;
            } else {
                node = stack.pop();
                System.out.print(node.data + " ");
                if (node.right != null) {
                    node = node.right;
                }
            }
        }
    }

    /**
     * Prints Inorder Morris Tree traversal
     *
     * @param node
     */
    private void printInorderMorrisTraversal(Node node) {
        Node current = node;
        while (current != null) {
            if (current.left == null) {
                System.out.print(current.data + " ");
                if (current.flag) {
                    Node temp = current.right;
                    current.right = null;
                    current = temp;
                    System.out.print(current.data + " ");
                }
                current = current.right;
            } else {
                Node previous = current.left;
                while (previous.right != null) {
                    previous = previous.right;
                }
                previous.right = current;
                previous.flag = true;
                current = current.left;
            }
        }
    }

    /**
     * Recursive implementation for Inorder tree traversal
     */
    private void printRecursiveInorderTraversal(Node node) {
        if (node != null) {
            printRecursiveInorderTraversal(node.left);
            System.out.print(node.data + " ");
            printRecursiveInorderTraversal(node.right);
        }
    }

    /**
     * Recursive implementation for Preorder tree traversal
     *
     * @param node
     */
    private void printRecursivePreorderTraversal(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            printRecursivePreorderTraversal(node.left);
            printRecursivePreorderTraversal(node.right);
        }
    }

    /**
     * Iterative implementation for Preorder tree traversal
     *
     * @param node
     */
    private void printIterativePreorderTraversal(Node node) {
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while (node != null) {
            node = stack.pop();
            System.out.print(node.data + " ");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    /**
     * Iterative implementation 2 for Preorder tree traversal
     *
     * @param node
     */
    private void printIterativePreorderTraversal2(Node node) {
        Stack<Node> stack = new Stack<>();
        while (true) {
            while (node != null) {
                System.out.print(node.data + " ");
                stack.push(node);
                node = node.left;
            }
            if (stack.isEmpty()) {
                break;
            } else {
                node = stack.pop();
                if (node.right != null) {
                    node = node.right;
                }
            }
        }
    }

    /**
     * Prints Preorder Morris Tree Traversal
     *
     * @param current
     */
    private void printPreOrderMorrisTraversal(Node current) {
        while (current != null) {
            if (current.left == null) {
                System.out.print(current.data + " ");
                current = current.right;
            } else {
                Node left = current.left;
                while (left.right != null && left.right != current) {
                    left = left.right;
                }
                if (left.right == null) {
                    left.right = current;
                    System.out.print(current.data + " ");
                    current = current.left;
                } else {
                    left.right = null;
                    current = current.right;
                }
            }
        }
    }

    /**
     * Iterative Implementation using one Stack for Postorder tree traversal
     *
     * @param node
     */
    private void printIterativePostorderTraversal(Node node) {
        Stack<Node> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.peek();
                if (node.right != null) {
                    node = node.right;
                } else {
                    Node temp = stack.pop();
                    System.out.print(temp.data + " ");
                    while (!stack.isEmpty() && stack.peek().right == temp) {
                        temp = stack.pop();
                        System.out.print(temp.data + " ");
                    }
                }
            }
        }
    }

    /**
     * Iterative Implementation using two Stacks for Postorder tree traversal
     *
     * @param node
     */
    private void printIterativePostorderTraversal2(Node node) {
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        if (node != null) {
            stack1.push(node);
        }

        while (!stack1.isEmpty()) {
            node = stack1.pop();
            if (node.right != null) {
                stack1.push(node.right);
            }
            if (node.left != null) {
                stack1.push(node.left);
            }
            stack2.push(node);
        }

        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().data + " ");
        }
    }

    /**
     * Iterative Implementation using one Stack for Postorder tree traversal
     */
    private void printIterativePostorderTraversal3(Node node) {
        Stack<Node> stack = new Stack<>();
        if (node != null) {
            stack.push(node);
        }
        while (node != null || !stack.isEmpty()) {
            node = stack.peek();
            Node temp = null;
            if (node.right != null) {
                stack.push(node.right);
                temp = node.right;
            }

            if (node.left != null) {
                stack.push(node.left);
                temp = node.left;
            }

            node = temp;

            if (node == null) {
                node = stack.pop();
                System.out.print(node.data + " ");
                while (!stack.isEmpty() && stack.peek().right == node) {
                    node = stack.pop();
                    System.out.print(node.data + " ");
                }
            }
        }
    }

    /**
     * Recursive Implementation for Postorder tree traversal
     *
     * @param node
     */
    private void printRecursivePostorderTraversal(Node node) {
        if (node != null) {
            printRecursivePostorderTraversal(node.left);
            printRecursivePostorderTraversal(node.right);
            System.out.print(node.data + " ");
        }
    }

    /**
     * Level order traversal for a binary tree using Queue
     */
    private void printIterativeLevelOrderTraversal(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            node = queue.poll();
            System.out.print(node.data + " ");
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    /**
     * Print all nodes on each level using iterative method
     *
     * @param node
     */
    private void printIterativeLevelOrderLineByLine(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            int nodeCount = queue.size();
            while (nodeCount > 0) {
                node = queue.poll();
                System.out.print(node.data + " ");
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                nodeCount--;
            }
            System.out.println();
        }
    }

    /**
     * Level order traversal for a binary tree using recursion
     */
    private void printRecursiveLevelOrderTraversal(Node node) {
        int height = TreeUtils.getHeight(node);
        for (int i = 1; i <= height; i++) {
            printGivenLevelRec(node, i);
        }
    }

    /**
     * Print reverse level order traversal using iteration
     *
     * @param node
     */
    private void printIterativeReverseLevelOrderTraversal(Node node) {
        Queue<Node> queue = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        if (node != null) {
            queue.add(node);
        }
        while (!queue.isEmpty()) {
            node = queue.poll();
            stack.push(node);
            if (node.right != null) {
                queue.add(node.right);
            }
            if (node.left != null) {
                queue.add(node.left);
            }
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    /**
     * Print reverse level order traversal using recursion
     *
     * @param node
     */
    private void printRecursiveReverseLeveOrderTraversal(Node node) {
        int height = TreeUtils.getHeight(node);
        for (int i = height; i > 0; i--) {
            printGivenLevelRec(node, i);
        }
    }

    /**
     * Print all the nodes at each level using recursion
     *
     * @param node
     * @param level
     */
    private void printGivenLevelRec(Node node, int level) {
        if (node != null) {
            if (level == 1) {
                System.out.print(node.data + " ");
            } else if (level > 1) {
                printGivenLevelRec(node.left, level - 1);
                printGivenLevelRec(node.right, level - 1);
            }
        }
    }

    /**
     * Recursive implementation of printing nodes in spiral level order format
     *
     * @param node
     */
    private void printRecursiveSpiralLevelOrderTraversal(Node node) {
        int height = TreeUtils.getHeight(node);
        for (int i = 1; i <= height; i++) {
            printRecursiveSpiralGivenLevel(node, i, i & 1);
        }
        System.out.println();
    }

    /**
     * Print nodes in each level in spiral order format
     *
     * @param node
     * @param level
     * @param evenOddIndicator
     */
    private void printRecursiveSpiralGivenLevel(Node node, int level, int evenOddIndicator) {
        if (node != null) {
            if (level == 1) {
                System.out.print(node.data + " ");
            } else if (level > 1) {
                if (evenOddIndicator == 1) {
                    printRecursiveSpiralGivenLevel(node.right, level - 1, evenOddIndicator);
                    printRecursiveSpiralGivenLevel(node.left, level - 1, evenOddIndicator);
                } else {
                    printRecursiveSpiralGivenLevel(node.left, level - 1, evenOddIndicator);
                    printRecursiveSpiralGivenLevel(node.right, level - 1, evenOddIndicator);
                }
            }
        }
    }

    /**
     * Iterative implementation of printing nodes in spiral level order format
     *
     * @param node
     */
    private void printIterativeSpiralLevelOrderTraversal(Node node) {
        Deque<Node> queue = new LinkedList<>();
        if (node != null) {
            queue.add(node);
        }

        boolean evenLevel = false;
        while (!queue.isEmpty()) {
            int nodeCount = queue.size();
            while (nodeCount != 0) {
                if (!evenLevel) {
                    node = queue.pollLast();
                    System.out.print(node.data + " ");
                    if (node.right != null) {
                        queue.addFirst(node);
                    }
                    if (node.left != null) {
                        queue.addFirst(node);
                    }
                } else {
                    node = queue.pollFirst();
                    System.out.print(node.data + " ");
                    if (node.left != null) {
                        queue.addLast(node);
                    }
                    if (node.right != null) {
                        queue.addLast(node);
                    }
                }
            }
            evenLevel = !evenLevel;
        }
    }

    /**
     * Prints perfect binary tree specific level order traversal using iterative approach
     *
     * @param node
     */
    private void printIterativeSpecificLevelOrder(Node node) {
        Queue<Node> queue = new LinkedList<>();
        if(node != null){
            System.out.print(node.data+" ");
            if(node.left != null){
                System.out.print(node.left.data+" "+node.right.data);
                queue.add(node.left);
                queue.add(node.right);
            }
            Node first, last;
            while(!queue.isEmpty()){
                first = queue.remove();
                last = queue.remove();
                if(first.left != null){
                    System.out.print(first.left.data+" "+last.right.data+" "+first.right.data+" "+last.left.data);
                    queue.add(first.left);
                    queue.add(last.right);
                    queue.add(first.right);
                    queue.add(last.left);
                }
            }
        }
    }

    /**
     * Prints all the boundary nodes in a tree using recursive helper functions
     *
     * @param current
     */
    private void printRecursiveBoundaryTraversal(Node current) {
        if (current != null) {
            printLeftBoundaryNodes(current);

            if (current.left != null) {
                printSubtreeLeaves(current.left);
            }

            if (current.right != null) {
                printSubtreeLeaves(current.right);
            }

            printRightBoundaryNodes(current);
        }
    }

    /**
     * Prints all the subtree leaves
     *
     * @param current
     */
    private void printSubtreeLeaves(Node current) {
        if (current.left != null) {
            printSubtreeLeaves(current.left);
        } else if (current.right != null) {
            printSubtreeLeaves(current.right);
        } else {
            System.out.print(current.data + " ");
        }
    }

    /**
     * Prints right boundary nodes except the rightmost leaf node
     *
     * @param current
     */
    private void printRightBoundaryNodes(Node current) {
        if (current.right != null) {
            printRightBoundaryNodes(current.right);
        } else if (current.left != null) {
            printRightBoundaryNodes(current.left);
        }
        System.out.print(current.data + " ");
    }

    /**
     * Prints left boundary nodes including the root and except the leftmost leaf node
     *
     * @param current
     */
    private void printLeftBoundaryNodes(Node current) {
        System.out.print(current.data + " ");
        if (current.left != null) {
            printLeftBoundaryNodes(current.left);
        } else if (current.right != null) {
            printLeftBoundaryNodes(current.right);
        }
    }

    /**
     * Prints binary tree nodes in vertical order
     *
     * @param node
     */
    private void printRecursiveVerticalOrderTraversal(Node node) {
        //tree map is sorted in increasing order of keys by default
        TreeMap<Integer, List<Node>> treeMap = new TreeMap<>();
        int distance = 0;
        getVerticalOrderHelper(node, treeMap, distance);

        for (Map.Entry<Integer, List<Node>> entry : treeMap.entrySet()) {
            System.out.println(entry.getValue());
        }
        System.out.println();
    }

    /**
     * Gets the map that stores the node elements in the vertical order using preorder traversal
     *
     * @param node
     * @param treeMap
     * @param distance
     */
    private void getVerticalOrderHelper(Node node, TreeMap<Integer, List<Node>> treeMap, int distance) {
        if (node != null) {
            List<Node> list = treeMap.get(distance);
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(node);
            treeMap.put(distance, list);

            getVerticalOrderHelper(node.left, treeMap, distance - 1);
            getVerticalOrderHelper(node.right, treeMap, distance + 1);
        }
    }

    public class Node {
        private Node left, right;
        private boolean flag;
        private int data;

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }
    }
}
