package com.learning.utils;

import javax.swing.plaf.synth.SynthTextAreaUI;

public class MaxSubSumOfSizeN {
    public int maxSumAfterPartitioning(int[] A, int K) {
        int N = A.length, dp[] = new int[N];
        for (int i = 0; i < N; ++i) {
            int curMax = 0;
            for (int k = 1; k <= K && i - k + 1 >= 0; ++k) {
                curMax = Math.max(curMax, A[i - k + 1]);
                dp[i] = Math.max(dp[i], (i >= k ? dp[i - k] : 0) + curMax * k);
            }
        }
        for(int i =0; i < N; ++i) {
            System.out.print(" " + dp[i]);

        }

        return dp[N - 1];
    }

    public static void main(String args[]) throws Exception {
        MaxSubSumOfSizeN maxSubSumOfSizeN = new MaxSubSumOfSizeN();
        System.out.println(maxSubSumOfSizeN.maxSumAfterPartitioning(new int[]{1,15,7,9,2,5,10}, 3));
    }
}
