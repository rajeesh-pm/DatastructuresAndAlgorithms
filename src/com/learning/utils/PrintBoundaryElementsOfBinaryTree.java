package com.learning.utils;

import apple.laf.JRSUIUtils;

import java.sql.Statement;
import java.util.Stack;

public class PrintBoundaryElementsOfBinaryTree {
    public static int max_level = 0;
    public Stack<TreeNode> stk = new Stack<TreeNode>();
    public void printLeftView(TreeNode root, int level){
        if(root != null){
            if(level > max_level){
                System.out.println(root.data);
                max_level = level;
            }
            printLeftView(root.left, level + 1);
            printLeftView(root.right, level+1);
        }
    }

    public void getRightView(TreeNode root, int level){
        if(root != null){
            if(level > max_level){
                stk.push(root);
                max_level = level;
            }
            getRightView(root.right, level + 1);
            getRightView(root.left, level + 1);
        }
    }

    public void printView(){
        while(!stk.empty()){
            System.out.println(stk.pop().data);
        }
    }

    public static void main(String args[]){
        TreeNode root = TreeNode.getRootRef();
        PrintBoundaryElementsOfBinaryTree boundary = new PrintBoundaryElementsOfBinaryTree();
//        boundary.printLeftView(root, 1);
        max_level = 0;
//        boundary.getRightView(root.right, 1);
//        boundary.printView();

        boundary.leftSubtree(root.left);
        boundary.rightSubTree(root.right);
    }

    public void leftSubtree(TreeNode root){
        if(root != null){
            System.out.println("Processing " + root.data);
            if(root.left != null){
                System.out.println(root.data);
                leftSubtree(root.left);
            }

            else if(root.right != null){
                System.out.println(root.data);
                leftSubtree(root.right);
            }
        }
    }

    /*
    *
    *
    * 5
    *
    * */

    public void rightSubTree(TreeNode root){
        if(root != null){
            if(root.right != null){
                rightSubTree(root.right);
                System.out.println(root.data);
            }
            else if(root.left != null){
                rightSubTree(root.left);
                System.out.println(root.data);
            }
        }
    }
}
