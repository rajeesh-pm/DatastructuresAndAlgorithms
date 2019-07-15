package com.learning.utils;

public class LongestCommonSubsequence {
    public static void main(String args[]) throws Exception {
        String first = "abcd";
        String second = "abcd";

        int[][] arr = new int[first.length() + 1][second.length() + 1];
        int max = 0;

        for (int i = 1; i <= first.length(); ++i) {
            for (int j = 1; j <= second.length(); ++j) {
                if (first.charAt(i-1) == second.charAt(j-1)) {
                    arr[i][j] = arr[i - 1][j - 1] + 1;
                } else {
                    arr[i][j] = Integer.max(arr[i - 1][j], arr[i][j - 1]);
                }
                if (max < arr[i][j]) {
                    max = arr[i][j];
                }
            }
        }

        System.out.println(max);

    }
}
