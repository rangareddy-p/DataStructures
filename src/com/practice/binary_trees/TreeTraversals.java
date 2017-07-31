package com.practice.binary_trees;

import com.practice.utils.FunctionType;

import java.lang.System;
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
     * Iterative Implementation for Inorder tree traversal
     * @param node
     */
    private void printInorderTraversalItr(Node node) {
        Stack<Node> stack = new Stack<Node>();
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
            System.out.println();
        } else {
            printPreorderTraversalItr(node);
        }
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
     * Iterative Implementation for Postorder tree traversal
     * @param node
     */
    private void printPostorderTraversalItr(Node node) {

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

    public static void main(String[] args) {
        System.out.println("main");
    }
}
