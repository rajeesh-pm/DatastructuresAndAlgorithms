package com.learning.utils;

import java.util.LinkedList;
import java.util.List;

public class AllNodeKDistanceFromGivenNode {

    TreeNode treeNode;
    List<Integer> ans;
    TreeNode target;
    int K;

    public static void main(String[] args) {
        TreeNode node = TreeNode.getRootRef();
        findNodesAtKDistance(node, 0, 1);
    }

    public static void findNodesAtKDistance(TreeNode node, int currentDistance, int distance) {
        if (node == null)
            return;

        if (currentDistance == distance) {
            System.out.println(node.data);
            return;
        }

        findNodesAtKDistance(node.left, currentDistance + 1, distance);
        findNodesAtKDistance(node.right, currentDistance + 1, distance);
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        ans = new LinkedList();
        this.target = target;
        this.K = K;
        dfs(root);
        return ans;
    }

    // Return vertex distance from node to target if exists, else -1
    // Vertex distance: the number of vertices on the path from node to target
    public int dfs(TreeNode node) {
        if (node == null)
            return -1;
        else if (node == target) {
            subtree_add(node, 0);
            return 1;
        } else {
            int L = dfs(node.left);
            int R = dfs(node.right);
            if (L != -1) {
                if (L == K)
                    ans.add(node.data);

                subtree_add(node.right, L + 1);
                return L + 1;
            } else if (R != -1) {
                if (R == K)
                    ans.add(node.data);

                subtree_add(node.left, R + 1);
                return R + 1;
            } else {
                return -1;
            }
        }
    }

    // Add all nodes 'K - dist' from the node to answer.
    public void subtree_add(TreeNode node, int dist) {
        if (node == null) return;
        if (dist == K)
            ans.add(node.data);
        else {
            subtree_add(node.left, dist + 1);
            subtree_add(node.right, dist + 1);
        }
    }
}
