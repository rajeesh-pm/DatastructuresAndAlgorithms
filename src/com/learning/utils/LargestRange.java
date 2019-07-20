package com.learning.utils;

/*
 *
 *
 * Largest range of numbers contained in an array
 *
 * {2,3,4,5,6}
 * [2,6]
 *
 * {1, 11, 3, 0, 15, 5 2, 4, 10, 7, 12, 6}
 * [0,7]
 *
 *
 * */

import java.util.HashMap;
import java.util.Map;

/*
 * Profit With K transactions
 *
 *      5  11  3  50  60  90
 *    0 0  0   0  0   0   0
 *    1 0  6   6  47  57  87
 *    2 0  6   6  53  63  93
 *
 *  price[t][d-1]
 *  price[d] + max{-price[x] + profit[t-1][x]}
 *
 *
 * */
public class LargestRange {
    public static void main(String args[]) {
        LargestRange largestRange = new LargestRange();
        int[] numbers = {1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6};
        int[] ranges = largestRange.findLargestRange(numbers);
        System.out.print("[");
        for (int i : ranges) {
            System.out.print(i + ",");
        }
        System.out.println("]");

    }

    public int[] findLargestRange(int[] numbers) {
        Map<Integer, Boolean> mapNumbers = new HashMap<>();
        int[] range = new int[2];
        for (int i : numbers) {
            mapNumbers.put(i, true);
        }

        int maxLength = 0;
        for (int i : numbers) {

            if (!mapNumbers.get(i))
                continue;

            int currentLength = 1;
            int right = i + 1;
            int left = i - 1;
            mapNumbers.put(i, false);
            while (mapNumbers.containsKey(right)) {
                mapNumbers.put(right, false);
                currentLength += 1;
                right += 1;
            }

            while (mapNumbers.containsKey(left)) {
                mapNumbers.put(left, false);
                currentLength += 1;
                left -= 1;
            }
            if (currentLength > maxLength) {
                maxLength = currentLength;
                range[0] = left + 1;
                range[1] = right - 1;
            }
        }
        return range;
    }
}
