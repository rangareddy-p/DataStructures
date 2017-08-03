package com.practice.binary_trees;

import com.practice.utils.FunctionType;
import com.practice.utils.TreeUtils;

import java.lang.System;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Different types of Tree traversals for Binary tree
 */
public class TreeTraversals {
    private Node root;

    public class Node {
        private Node left, right;
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

    public TreeTraversals(Node root){
        this.root = root;
    }

    /**
     * Inorder tree traversal
     */
    public void printInorderTraversal(FunctionType functionType){
        Node node = root;
        if(functionType == FunctionType.RECURSIVE){
            printInorderTraversalRec(node);
        } else {
            printInorderTraversalItr(node);
        }
        System.out.println();
    }

    /**
     * Iterative Implementation for Inorder Tree traversal
     * @param node
     */
    private void printInorderTraversalItr(Node node){
        Stack<Node> stack = new Stack<>();
        if(node != null){
            stack.push(node);
        }
        while(node != null && !stack.isEmpty()){
            if(node.left != null){
                stack.push(node.left);
                node = node.left;
            } else {
                node = stack.pop();
                System.out.print(node.data+" ");
                if(node.right != null){
                    node = node.right;
                    stack.push(node);
                }
            }
        }
    }

    /**
     * Iterative Implementation 2 for Inorder tree traversal
     * @param node
     */
    private void printInorderTraversalItr2(Node node) {
        Stack<Node> stack = new Stack<>();
        while(true){
            while(node != null){
                stack.push(node);
                node = node.left;
            }
            if(stack.isEmpty()){
                break;
            } else{
                node = stack.pop();
                System.out.print(node.data+" ");
                if(node.right != null){
                    node = node.right;
                }
            }

        }
    }

    /**
     * Recursive implementation for Inorder tree traversal
     */
    private void printInorderTraversalRec(Node node){
        if(node != null){
            printInorderTraversalRec(node.left);
            System.out.print(node.data+" ");
            printInorderTraversalRec(node.right);
        }
    }

    /**
     * Preorder tree traversal
     */
    public void printPreorderTraversal(FunctionType functionType){
        Node node = root;
        if(functionType == FunctionType.RECURSIVE){
            printPreorderTraversalRec(node);
        } else {
            printPreorderTraversalItr(node);
        }
        System.out.println();
    }

    /**
     * Recursive implementation for Preorder tree traversal
     * @param node
     */
    private void printPreorderTraversalRec(Node node) {
        if(node != null){
            System.out.print(node.data+" ");
            printPreorderTraversalRec(node.left);
            printPreorderTraversalRec(node.right);
        }
    }

    /**
     * Iterative implementation for Preorder tree traversal
     * @param node
     */
    private void printPreorderTraversalItr(Node node){
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while (node != null){
            node = stack.pop();
            System.out.print(node.data+" ");
            if(node.right != null){
                stack.push(node.right);
            }
            if(node.left != null){
                stack.push(node.left);
            }
        }
    }

    /**
     * Iterative implementation 2 for Preorder tree traversal
     * @param node
     */
    private void printPreorderTraversalItr2(Node node){
        Stack<Node> stack = new Stack<>();
        while(true){
            while(node != null){
                System.out.print(node.data+" ");
                stack.push(node);
                node = node.left;
            }
            if(stack.isEmpty()){
                break;
            } else {
                node = stack.pop();
                if(node.right != null){
                    node = node.right;
                }
            }
        }
    }

    public void printPostorderTraversal(FunctionType functionType){
        Node node = root;
        if(functionType == FunctionType.RECURSIVE){
            printPostorderTraversalRec(node);
            System.out.println();
        } else {
            printPostorderTraversalItr(node);
        }
    }

    /**
     * Iterative Implementation using one Stack for Postorder tree traversal
     * @param node
     */
    private void printPostorderTraversalItr(Node node) {
        Stack<Node> stack = new Stack<>();
        while(node != null || !stack.isEmpty()){
            if(node != null){
                stack.push(node);
                node = node.left;
            } else {
                node = stack.peek();
                if(node.right != null){
                    node = node.right;
                } else {
                    Node temp = stack.pop();
                    System.out.print(temp.data+" ");
                    while(!stack.isEmpty() && stack.peek().right == temp){
                        temp = stack.pop();
                        System.out.print(temp.data+" ");
                    }
                }
            }
        }
    }

    /**
     * Iterative Implementation using two Stacks for Postorder tree traversal
     * @param node
     */
    private void printPostorderTraversalItr2(Node node) {
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        if(node != null){
            stack1.push(node);
        }

        while(!stack1.isEmpty()){
            node = stack1.pop();
            if(node.right != null){
                stack1.push(node.right);
            }
            if(node.left != null){
                stack1.push(node.left);
            }
            stack2.push(node);
        }

        while(!stack2.isEmpty()){
            System.out.print(stack2.pop().data+" ");
        }
    }

    /**
     * Iterative Implementation using one Stack for Postorder tree traversal
     */
    private void printPostorderTraversalItr3(Node node){
        Stack<Node> stack = new Stack<>();
        if(node != null){
        stack.push(node);
        }
        while(node != null || !stack.isEmpty()){
            node = stack.peek();
            Node temp = null;
            if(node.right != null){
                stack.push(node.right);
                temp = node.right;
            }

            if(node.left != null){
                stack.push(node.left);
                temp = node.left;
            }

            node = temp;

            if(node == null){
                node = stack.pop();
                System.out.print(node.data+" ");
                while(!stack.isEmpty() && stack.peek().right == node){
                    node = stack.pop();
                    System.out.print(node.data+" ");
                }
            }
        }
    }

    /**
     * Recursive Implementation for Postorder tree traversal
     * @param node
     */
    private void printPostorderTraversalRec(Node node) {
        if(node != null){
            printPostorderTraversalRec(node.left);
            printPostorderTraversalRec(node.right);
            System.out.print(node.data + " ");
        }
    }

    private void printLevelOrderTraversal(FunctionType functionType){
        Node node = root;
        if(functionType == FunctionType.ITERATIVE){
            printLevelOrderTraversalItr(node);
        } else {
            printLevelOrderTraversalRec(node);
        }
        System.out.println();
    }

    /**
     * Level order traversal for a binary tree using Queue
     */
    private void printLevelOrderTraversalItr(Node node){
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            node = queue.poll();
            System.out.print(node.data + " ");
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
    }

    /**
     * Print all nodes on each level using iterative method
     * @param node
     */
    private void printLevelOrderLineByLineItr(Node node){
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            int nodeCount = queue.size();
            while(nodeCount > 0){
                node = queue.poll();
                System.out.print(node.data+" ");
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
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
    private void printLevelOrderTraversalRec(Node node){
        int height = TreeUtils.getHeight(node);
        for(int i=1; i<=height; i++){
            printGivenLevelRec(node, i);
        }
    }

    /**
     * Print reverse level order traversal for a binary tree
     * @param functionType
     */
    private void printReverseLevelOrder(FunctionType functionType){
        Node node = root;
        if(functionType == FunctionType.ITERATIVE){
            printReverseLevelOrderTraversalItr(node);
        } else {
            printReverseLeveOrderTraversalRec(node);
        }
    }

    /**
     * Print reverse level order traversal using iteration
     * @param node
     */
    private void printReverseLevelOrderTraversalItr(Node node) {
        Queue<Node> queue = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        if(node != null){
            queue.add(node);
        }
        while (!queue.isEmpty()){
            node = queue.poll();
            stack.push(node);
            if(node.right != null){
                queue.add(node.right);
            }
            if(node.left != null){
                queue.add(node.left);
            }
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
    }

    /**
     * Print reverse level order traversal using recursion
     * @param node
     */
    private void printReverseLeveOrderTraversalRec(Node node){
        int height = TreeUtils.getHeight(node);
        for(int i = height; i>0; i--){
            printGivenLevelRec(node, i);
        }
    }

    /**
     * Print all the nodes at each level using recursion
     * @param node
     * @param level
     */
    private void printGivenLevelRec(Node node, int level) {
        if(node != null){
            if(level == 1) {
                System.out.print(node.data+" ");
            } else if(level > 1){
                printGivenLevelRec(node.left, level - 1);
                printGivenLevelRec(node.right, level - 1);
            }
        }
    }

    /**
     * Print all the nodes in spiral level order format
     * @param functionType
     */
    private void printSpiralLevelOrder(FunctionType functionType){
        Node node = root;
        if(functionType == FunctionType.ITERATIVE){
            printSpiralLevelOrderTraversalItr(node);
        } else {
            printSpiralLevelOrderTraversalRec(node);
        }
    }

    /**
     * Recursive implementation of printing nodes in spiral level order format
     * @param node
     */
    private void printSpiralLevelOrderTraversalRec(Node node) {
        int height = TreeUtils.getHeight(node);
        for(int i=1; i<=height; i++){
            printSpiralGivenLevelRec(node, i, i&1);
        }
        System.out.println();
    }

    /**
     * Print nodes in each level in spiral order format
     * @param node
     * @param level
     * @param evenOddIndicator
     */
    private void printSpiralGivenLevelRec(Node node, int level, int evenOddIndicator) {
        if(node != null){
            if(level == 1){
                System.out.print(node.data + " ");
            } else if(level > 1){
                if(evenOddIndicator == 1){
                    printSpiralGivenLevelRec(node.right, level-1, evenOddIndicator);
                    printSpiralGivenLevelRec(node.left, level-1, evenOddIndicator);
                } else {
                    printSpiralGivenLevelRec(node.left, level-1, evenOddIndicator);
                    printSpiralGivenLevelRec(node.right, level-1, evenOddIndicator);
                }
            }
        }
    }

    /**
     * Iterative implementation of printing nodes in spiral level order format
     * @param node
     */
    private void printSpiralLevelOrderTraversalItr(Node node) {
        Deque<Node> queue = new LinkedList<>();
        if(node != null){
            queue.add(node);
        }

        boolean evenLevel = false;
        while(!queue.isEmpty()){
            int nodeCount = queue.size();
            while(nodeCount > 0){
                if(!evenLevel){
                    node = queue.pollLast();
                    System.out.print(node.data+" ");
                    if(node.right != null){
                        queue.addFirst(node);
                    }
                    if(node.left != null){
                        queue.addFirst(node);
                    }
                } else {
                    node = queue.pollFirst();
                    System.out.print(node.data+" ");
                    if(node.left != null){
                        queue.addLast(node);
                    }
                    if(node.right != null){
                        queue.addLast(node);
                    }
                }
            }
            evenLevel = !evenLevel;
        }
    }

    public static void main(String[] args) {
        System.out.println("main");
    }
}
