package com.learning.utils;

/*
*        6
*       / \
*      4   15
*          / \
*         10  20
*             /
*            18
*
*
* */

public class FindTheSecondLargestElementInBST {

    public static void main(String[] args){
        TreeNode treeNode = new TreeNode(6);
        treeNode.left = new TreeNode(4);
        treeNode.right =  new TreeNode(15);
        treeNode.right.left = new TreeNode(10);
        treeNode.right.right = new TreeNode(20);
        treeNode.right.right.left = new TreeNode(18);
        System.out.println(findSecondLargest(treeNode));
    }

    static int findSecondLargest(TreeNode root) {

        if(root == null || (root.right == null && root.left == null)){
            return -1;
        }

        if(root.right == null && root.left != null){
            return findLargest(root.left).data;
        }

        if(root.right != null && root.right.right == null && root.right.left == null){
           return root.data;
        }

        return findSecondLargest(root.right);


    }

    public static TreeNode findLargest(TreeNode root) {
        if(root == null){
            return null;
        }
        if (root.right != null){
            return findLargest(root.right);
        }
        return root;

    }
}
