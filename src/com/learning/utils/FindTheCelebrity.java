package com.learning.utils;

import java.util.Stack;

/*
 * Everyone knows celebrity. But celebrity doesn't know anyone
 * Find the celebrity in the group
 *
 *     A  B  C  D
 *
 *  A  0  1  1  0
 *
 *  B  0  0  1  1
 *
 *  C  0  0  0  0
 *
 *  D  1  0  1  0
 *
 *
 * */
public class FindTheCelebrity {

    public static void main(String[] args) {
        FindTheCelebrity findTheCelebrity = new FindTheCelebrity();
        int[][] arr = new int[][]{
                {0, 1, 1, 0},
                {0, 0, 1, 1},
                {0, 0, 0, 0},
                {1, 0, 1, 0}
        };
        System.out.println(findTheCelebrity.celeb(arr));
    }

    public boolean doTheyKnow(int first, int second, int[][] arr) {
        return arr[first][second] == 1;
    }


    public int celeb(int[][] arr) {
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < arr.length; ++i) {
            stk.push(i);
        }

        while (!stk.isEmpty() && stk.size() > 1) {
            int first = stk.pop();
            int second = stk.pop();

            if (doTheyKnow(first, second, arr)) {
                stk.push(second);
            } else {
                stk.push(first);
            }
        }
        return stk.peek();
    }
}
