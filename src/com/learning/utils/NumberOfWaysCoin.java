package com.learning.utils;

import java.util.Scanner;

public class NumberOfWaysCoin {
    static long getWays(long n, long[] c) {
        // Complete this function
        long res[][] = new long[c.length][(int) n + 1];
        for (int i = 0; i < c.length; ++i) {
            for (int j = 0; j <= n; ++j) {
                if (j == 0) {
                    res[i][j] = 1;
                    continue;
                }
                if (c[i] > j && i > 0) {

                    res[i][j] = (i > 0 ? res[i - 1][j] : 0);
                } else {
                    res[i][j] = (i > 0 ? res[i - 1][j] : 0) + res[i][(int) (j - c[i])];
                }

            }
        }

        return res[c.length - 1][(int) n];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        long[] c = new long[m];
        for (int c_i = 0; c_i < m; c_i++) {
            c[c_i] = in.nextLong();
        }
        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'
        long ways = getWays(n, c);
        System.out.println(ways);
    }
}
