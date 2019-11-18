package com.learning.utils;
/*
 * Given a cost matrix find an algorithm to find the minmum cost to connect all the cities.
 *
 * */


import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MinimumCostToConnectAllCities {

    public static void main(String[] args) {
        int[][] cost = new int[][]{{0, 1, 2, 3, 4},
                {1, 0, 5, 0, 7},
                {2, 5, 0, 6, 0},
                {3, 0, 6, 0, 0},
                {4, 7, 0, 0, 0}
        };

        cost = new int[][]{
                {0, 1, 1, 100, 0, 0},
                {1, 0, 1, 0, 0, 0},
                {1, 1, 0, 0, 0, 0},
                {100, 0, 0, 0, 2, 2},
                {0, 0, 0, 2, 0, 2},
                {0, 0, 0, 2, 2, 0}
        };

        MinimumCostToConnectAllCities minimumCostToConnectAllCities = new MinimumCostToConnectAllCities();
        minimumCostToConnectAllCities.findMinimumCost(cost);
//        minimumCostToConnectAllCities.testPriorityQueue();
    }

    public int findMinimumCost(int[][] cost) {

        int[] parent = new int[cost[0].length];
        boolean[] isIncludedInMST = new boolean[cost[0].length];

        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>(Comparator.comparingInt((Vertex o) -> o.minCost));
        Map<Integer, Vertex> costMap = new HashMap<>();

        for (int i = 0; i < cost[0].length; ++i) {
            Vertex vertex = new Vertex(i, Integer.MAX_VALUE);
            priorityQueue.add(vertex);
            costMap.put(i, vertex);
            isIncludedInMST[i] = false;
        }

        parent[0] = -1;

        Vertex v = priorityQueue.poll();
        v.minCost = 0;
        priorityQueue.add(v);

        for (int i = 0; i < cost[0].length; ++i) {

            Vertex vertex = priorityQueue.poll();
            isIncludedInMST[vertex.vertex] = true;
            for (int j = 0; j < cost[0].length; ++j) {
                if (!isIncludedInMST[j] && cost[vertex.vertex][j] > 0 && cost[vertex.vertex][j] < costMap.get(j).minCost) {
                    parent[j] = vertex.vertex;
                    priorityQueue.remove(costMap.get(j));
                    costMap.get(j).minCost = cost[vertex.vertex][j];
                    priorityQueue.add(costMap.get(j));

                }
            }
        }

        int costVal = 0;

        for (int i = 1; i < parent.length; ++i) {
//            System.out.println("parent of " + i + " " + parent[i]);
//            System.out.println("Cost " + cost[parent[i]][i]);
            costVal += cost[parent[i]][i];
        }

        System.out.println("cost " + costVal);


        return costVal;

    }

    public class Vertex {
        int vertex;
        int minCost;

        Vertex(int vertexNum, int cost) {
            this.minCost = cost;
            this.vertex = vertexNum;
        }
    }

}
