package com.learning.utils;

import java.util.Arrays;

public class GFG {
    // A Dynamic Programing based function
    // to find maximum value of
    // arr[l] - arr[k] + arr[j] - arr[i]
    // is maximum and i < j < k < l
    static int findMaxValue(int[] arr, int n) {

        // If the array has less than 4 elements
        if (n < 4) {
            System.out.println("The array should have" +
                    " atleast 4 elements");
        }

        // We create 4 DP tables
        int[] table1 = new int[n + 1];
        int[] table2 = new int[n];
        int[] table3 = new int[n - 1];
        int[] table4 = new int[n - 2];

        // Initialize all the tables to minus Infinity
        Arrays.fill(table1, Integer.MIN_VALUE);
        Arrays.fill(table2, Integer.MIN_VALUE);
        Arrays.fill(table3, Integer.MIN_VALUE);
        Arrays.fill(table4, Integer.MIN_VALUE);

        // table1[] stores the maximum value of arr[l]
        for (int i = n - 1; i >= 0; i--) {
            table1[i] = Math.max(table1[i + 1], arr[i]);
        }

        // table2[] stores the maximum value of
        // arr[l] - arr[k]
        for (int i = n - 2; i >= 0; i--) {
            table2[i] = Math.max(table2[i + 1],
                    table1[i + 1] - arr[i]);
        }

        // table3[] stores the maximum value of
        // arr[l] - arr[k] + arr[j]
        for (int i = n - 3; i >= 0; i--)
            table3[i] = Math.max(table3[i + 1],
                    table2[i + 1] + arr[i]);

        // table4[] stores the maximum value of
        // arr[l] - arr[k] + arr[j] - arr[i]
        for (int i = n - 4; i >= 0; i--)
            table4[i] = Math.max(table4[i + 1],
                    table3[i + 1] - arr[i]);

        return table4[0];
    }

    // Driver Code
    public static void main(String[] args) {
        int[] arr = {4, 8, 9, 2, 20};
        int n = arr.length;
        System.out.println(findMaxValue(arr, n));
    }
}
