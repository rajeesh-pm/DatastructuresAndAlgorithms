package com.learning.utils;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinNumberOfMovementsRook {

    public static void main(String args[]){
        MinNumberOfMovementsRook minNumberOfMovementsRook = new MinNumberOfMovementsRook();
        int[][] board = new int[][] {
                {0,0,0,1,0},
                {0,0,0,1,1},
                {1,1,0,0,0},
                {0,1,0,0,0}
        };

        System.out.println(minNumberOfMovementsRook.minNumberOfMovements(board, 0, 0, 3, 4));
    }

    public int minNumberOfMovements(int[][] board, int a, int b, int c, int d){

        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        queue.add(new Node(a,b, 0));

        while(!queue.isEmpty()){
            Node node =  queue.poll();
            System.out.println("Exploring " + node.x + " " + node.y);
            if(c == node.x && d == node.y ){
                return node.dist;
            }
            for(int i = node.x; i < board.length; ++i){
                if(board[i][node.y] == 0){
                    addToQueue(i, node.y, node.dist, visited, queue);
                }
                else
                    break;
            }

            for(int i = node.x; i >=0; --i){
                if(board[i][node.y] == 0){
                    addToQueue(i, node.y, node.dist, visited, queue);
                }
                else {
                    break;
                }
            }

            for(int i = node.y; i < board[0].length; ++i){
                if(board[node.x][i] == 0) {
                    addToQueue(node.x, i, node.dist, visited, queue);
                }
                else
                    break;
            }

            for(int i = node.y; i >=0; --i){
                if(board[node.x][i] == 0){
                    addToQueue(node.x, i, node.dist, visited, queue);
                }
                else
                    break;
            }
        }

        return -1;
    }

    private void addToQueue(int x, int y, int dist, Set<Node> visited, Queue<Node> queue){
        Node newnode = new Node(x, y, dist);
        if(!visited.contains(newnode)){
            newnode.dist = newnode.dist + 1;
            visited.add(newnode);
            System.out.println("Adding " + newnode.x + " " + newnode.y);
            queue.add(newnode);
        }
    }

    class Node {

        int x;
        int y;
        int dist;

        Node(int x, int y, int dist) {
            this.dist = dist;
            this.x = x;
            this.y = y;
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
            if (node.y != y) return false;
            return true;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = result * 31 + y;
//            result = result * 31 + dist;
            return result;
        }
    }
}
