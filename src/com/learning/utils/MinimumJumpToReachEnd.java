package com.learning.utils;

public class MinimumJumpToReachEnd {

    public static void main(String args[]) throws Exception {
        int arr[] = {2, 3, 1, 1, 2, 4, 2, 0, 1, 1};

        int T[] = new int[arr.length];
        for (int i = 0; i < arr.length; ++i) {
            T[i] = Integer.MAX_VALUE;
        }

        int pos[] = new int[arr.length];
        T[0] = 0;

        for (int i = 0; i < arr.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (arr[j] >= i - j) {
                    if (T[i] > T[j] + 1) {
                        T[i] = T[j] + 1;
                        pos[i] = j;
                    }
                }
            }
        }

        for (int i = 0; i < arr.length; ++i) {
            System.out.println(T[i]);
        }
    }

}
