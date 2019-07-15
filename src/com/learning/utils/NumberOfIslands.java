package com.learning.utils;

public class NumberOfIslands {

    private int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        FormUnionFind find = new FormUnionFind(grid);

        System.out.println("Matrix");

        for (char[] interval : grid) {
            for (char anInterval : interval)
                System.out.print(anInterval + " ");
            System.out.println();
        }
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    if (i - 1 >= 0 && grid[i - 1][j] == '1') {
                        find.union(i * n + j, (i - 1) * n + j);
                    }
                    if (i + 1 < m && grid[i + 1][j] == '1') {
                        find.union(i * n + j, (i + 1) * n + j);
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] == '1') {
                        find.union(i * n + j, i * n + j - 1);
                    }

                    if (j + 1 < n && grid[i][j + 1] == '1') {
                        find.union(i * n + j, i * n + j + 1);
                    }
                }
            }
        }

        return find.getCount();


    }

    class FormUnionFind {
        int count;
        int[] parent;
        int[] rank;

        FormUnionFind(char[][] grid) {
            count = 0;
            int m = grid.length;
            int n = grid[0].length;

            parent = new int[m * n];
            rank = new int[m * n];

            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (grid[i][j] == '1') {
                        parent[i * n + j] = i * n + j;
                        rank[i * n + j] = 0;
                        ++count;
                    }
                }
            }
            System.out.println("Printing parent details");
            for (int i : parent) {
                System.out.print(i + " ");
            }
            System.out.println();
            System.out.println("Printing rank details");
            for (int i : rank) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        int find(int i) {
            if (parent[i] != i)
                parent[i] = find(parent[i]);
            return parent[i];
        }

        private void union(int x, int y) {
            System.out.println("Print x " + x);
            System.out.println("Print y " + y);
            int rootx = find(x);
            int rooty = find(y);


            if (rootx != rooty) {
                if (rank[rootx] > rank[rooty]) {
                    parent[rooty] = rootx;
                } else if (rank[rootx] < rank[rooty]) {
                    parent[rootx] = rooty;
                } else {
                    parent[rooty] = rootx;
                    rank[rootx] += 1;
                }
                --count;
            }
        }

        private int getCount() {
            return count;
        }

    }

    private int numOfIslandsDfs(char[][] islands) {
        int count = 0;
        for (int i = 0; i < islands.length; ++i) {
            for (int j =0 ; j < islands[0].length; ++j) {
                if (islands[i][j] == '1') {
                    dfs(islands, i ,j);
                    ++count;

                }

            }
        }
        return count;
    }

    private void dfs(char[][] islands, int i, int j) {

        if(i<0 || i >= islands.length || j < 0 || j >= islands[0].length){
            return;
        }
        if(islands[i][j] == '0')
            return;
        islands[i][j] = '0';
        dfs(islands, i + 1, j);
        dfs(islands, i - 1, j);
        dfs(islands, i, j-1);
        dfs(islands, i, j+1);
    }

    public static void main(String args[]) {
        NumberOfIslands numberOfIslands = new NumberOfIslands();
        char[][] islands = new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '1'}};
        System.out.println(numberOfIslands.numIslands(islands));

        islands = new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '1'}};
        System.out.println(numberOfIslands.numOfIslandsDfs(islands));

    }
}
