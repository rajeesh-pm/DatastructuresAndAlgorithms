package com.learning.utils;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.awt.*;

public class LowesCommonAncesstor {
	public static void main(String args[]) {
		TreeNode root = TreeNode.getRootRef();
		System.out.println(findLCA(root,8,15).data); // binary tree
		//findLCABST(root,5,10);
	}
	
	private static TreeNode findLCA(TreeNode root,int data1, int data2){
//		System.out.println(root);
		if(root ==  null) {
			System.out.println("returning null");
			return null;
		}
		else if(root.data == data1 || root.data == data2){
			System.out.println("root.data: " + root.data);
			return root;
		}
		System.out.println("CAlling left");
		TreeNode left =  findLCA(root.left, data1, data2);
		System.out.println("CAlling right");
		TreeNode right = findLCA(root.right, data1, data2);
		if ( left != null && right !=  null){
			System.out.println("Both are not null");
			return root;
		}
		if(left == null && right == null ){
			System.out.println("Null Null");
			return null;
		}
		System.out.println("Returning left not null or right not null" + "left " + (left!=null) + "right " + (right !=null));
		return left!=null ? left : right;			
	}
	
	private static TreeNode findLCABST(TreeNode root, int data1, int data2) {
		if(root ==  null)
			return null;
		if(root.data < Math.min(data1, data2)){
			findLCABST(root.right, data1, data2);
		}
		else if (root.data > Math.max(data1, data2)) {
			findLCABST(root.left, data1, data2);
		}
		else 
			return root;
		return null;
	}
}
