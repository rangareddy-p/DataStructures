package com.practice.binary_trees;

import com.practice.utils.FunctionType;

import java.lang.System;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeTraversals {
    private Node root;

    class Node {
        Node left, right;
        int data;
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
     * Recursive Implementation for Postorder tree traversal
     * @param node
     */
    private void printPostorderTraversalRec(Node node) {
        if(node != null){
            printPostorderTraversalRec(node.left);
            printPostorderTraversalRec(node.right);
            System.out.print(node.data+" ");
        }
    }

    /**
     * Level order traversal for a binary tree using Queue
     */
    private void printLevelOrderTraversal(Node node){
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            node = queue.poll();
            System.out.print(node.data+" ");
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("main");
    }
}
