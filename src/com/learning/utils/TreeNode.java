package com.learning.utils;

public class TreeNode {
	int data;
	TreeNode left = null;
	TreeNode right = null;
	public TreeNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;		 
	}
	
	public static void main(String args[]) throws Exception {
		
	}
	
	private static TreeNode createTree() {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(15);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(8);
		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(20);

		root.left.right.right = new TreeNode(9);
		return root;
	}

	/*
	*           10
	*          /  \
	*         5    15
	*        / \  / \
	*       2  8 7  20
	*
	* */
	
	public static TreeNode getRootRef() {
		return createTree();
	}
	
}
