package com.learning.utils;

public class CheckIfBinaryTree {
	
	private class Node{
		int data;
		Node left;
		Node right;
	}
	
	public boolean isBst(Node root, int min, int max) {
		if(root == null){
			return true;
		}
		if(root.data <= min || root.data > max) {
			return false;
		}		
		return isBst(root.left, min, root.data) && isBst(root.right, root.data, max);
	}

}
