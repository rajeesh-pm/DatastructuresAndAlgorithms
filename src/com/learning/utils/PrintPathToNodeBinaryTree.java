package com.learning.utils;

import java.util.ArrayList;
import java.util.List;

public class PrintPathToNodeBinaryTree {

    public static void main(String[] args){
        List<Integer> pathList = new ArrayList<>();
        printPath(TreeNode.getRootRef(), 15, pathList);
        pathList.forEach(System.out::println);
    }

    public static boolean printPath(TreeNode treeNode, int key, List<Integer> path) {
        if(treeNode == null){
            return false;
        }

        if(treeNode.data == key){
            path.add(treeNode.data);
            return true;
        }

        boolean left = printPath(treeNode.left, key, path);
        boolean right = printPath(treeNode.right, key, path);

        if(left || right) {
            path.add(treeNode.data);
            return true;
        }

        return false;
    }
}
