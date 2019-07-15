package com.learning.utils;

/*
 * Sort the array which contains only zero, one and two
 * input = [0,1,0,2,0,1,1,2,0]
 * output = [0,0,0,0,1,1,1,2,2]
 * */
public class ArrayContainingZeroOneTwo {

    public static void main(String args[]) {
        int[] input = {0, 0, 0, 2, 0, 0, 0, 0, 0};
        int lb = 0;
        int mid = 0;
        int hi = input.length - 1;
        while (mid < hi)
            switch (input[mid]) {
                case 0:
                    int temp = input[lb];
                    input[lb] = input[mid];
                    input[mid] = temp;
                    ++lb;
                    ++mid;
                    break;

                case 1:
                    ++mid;
                    break;
                case 2:
                    temp = input[hi];
                    input[hi] = input[mid];
                    input[mid] = temp;
                    --hi;
            }

        System.out.println("The array is");
        for (int i : input) {
            System.out.println(i);
        }

    }

}
