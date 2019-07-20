package com.learning.utils;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinimumNumbrOfHopsKnight {

    private static int row[] = {2, 2, -2, -2, 1, 1, -1, -1};
    private static int col[] = {-1, 1, 1, -1, 2, -2, 2, -2};

    public static void main(String[] args) {
        int N = 8;
        int x = 3;
        int y = 3;

        int destx = 7;
        int desty = 3;
        MinimumNumbrOfHopsKnight minimumNumbrOfHopsKnight = new MinimumNumbrOfHopsKnight();
        System.out.println(minimumNumbrOfHopsKnight.findMinHops(x, y, destx, desty));

    }

    public boolean isValid(int x, int y, int N) {
        if (x < 0 || y < 0 || x > N || y > N) {
            return false;
        }
        return true;
    }

    public int findMinHops(int x, int y, int destx, int desty) {

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(new Node(x, y, 0));
        Set<Node> visited = new HashSet<>();

        while (!queue.isEmpty()) {

            Node node = queue.poll();
            int dist = node.dist;


            if (destx == node.x && desty == node.y) {
                return node.dist;
            }

            if (!visited.contains(node)) {
                visited.add(node);
                for (int i = 0; i < 8; ++i) {
                    int new_x = node.x + row[i];
                    int new_y = node.y + col[i];
                    if (isValid(new_x, new_y, 8))
                        queue.add(new Node(new_x, new_y, dist + 1));
                }
            }
        }

        return 0;
    }

    class Node {

        int x;
        int y;
        int dist;

        Node(int x, int y, int dist) {
            this.dist = dist;
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public boolean equals(Object other) {
            if (other == null)
                return false;

            if (!(other instanceof Node)) {
                return false;
            }

            Node node = (Node) other;
            if (node.x != x) return false;
            if (node.y != y) return true;
            return node.dist == dist;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = result * 31 + y;
            result = result * 31 + dist;
            return result;
        }
    }

}
