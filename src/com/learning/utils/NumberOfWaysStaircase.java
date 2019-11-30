package com.learning.utils;

import java.util.Arrays;

public class NumberOfWaysStaircase {

    public static void main(String[] args) {
        NumberOfWaysStaircase numberOfWaysStaircase = new NumberOfWaysStaircase();
        System.out.println(numberOfWaysStaircase.minimumNumberOfWays(7));
        System.out.println(numberOfWaysStaircase.minimumNumberOfWays(7, new int[]{1, 2, 3}));
    }

    public int minimumNumberOfWays(int n) {
        int one = 1;
        int two = 2;

        int[] numberOfWays = new int[n];

//        int[] ways = new int[];
        //1,2,3,5
        numberOfWays[0] = 1;
        numberOfWays[1] = 2;
        for (int i = 2; i < n; ++i) {
            numberOfWays[i] = numberOfWays[i - 1] + numberOfWays[i - 2];
        }
        System.out.println(numberOfWays[n - 1]);
        int old_two;

        for (int i = 2; i < n; ++i) {
            old_two = two;
            two = one + two;
            one = old_two;
        }

        return two;
    }

    public int minimumNumberOfWays(int n, int[] stepSize) {
        Arrays.sort(stepSize);

//        {1,2}
//
        int[] numberOfWays = new int[n+1];
        numberOfWays[0] = 1;
        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j < stepSize.length && stepSize[j] <= i ; ++j) {
                numberOfWays[i] += numberOfWays[i - stepSize[j]];
            }
        }
        return numberOfWays[n];
    }
}
