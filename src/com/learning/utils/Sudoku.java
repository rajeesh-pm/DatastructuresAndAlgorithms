package com.learning.utils;

import java.util.HashSet;
import java.util.Set;

public class Sudoku {


    int[][] board = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
            {5, 2, 0, 0, 0, 0, 0, 0, 0},
            {0, 8, 7, 0, 0, 0, 0, 3, 1},
            {0, 0, 3, 0, 1, 0, 0, 8, 0},
            {9, 0, 0, 8, 6, 3, 0, 0, 5},
            {0, 5, 0, 0, 9, 0, 6, 0, 0},
            {1, 3, 0, 0, 0, 0, 2, 5, 0},
            {0, 0, 0, 0, 0, 0, 0, 7, 4},
            {0, 0, 5, 2, 0, 6, 3, 0, 0}};

    public boolean solveSudoku() {
        int i=-1, j=-1;
        boolean isEmpty = true;
        for (int m = 0; m < board.length; ++m) {
            for (int n = 0; n < board[0].length; ++n) {
                if (board[m][n] == 0) {
                    i = m;
                    j = n;
                    isEmpty = false;
                    break;
                }
            }
            if (!isEmpty)
                break;

        }
        if (isEmpty)
            return true;
        System.out.println("Processing ++ " + i + " " + j + " " + board[i][j]);


        Set<Integer> validElements = getValidElements(i, j);
        for (int element : validElements) {
            board[i][j] = element;
            if (!solveSudoku()) {
                board[i][j] = 0;
                continue;
            }
            return true;
        }
        return false;
    }

    public static void main(String args[]) {
        Sudoku sudoku = new Sudoku();
        sudoku.solveSudoku();
        sudoku.print();
    }

    public void print(){
        for(int i =0 ;i<board.length; ++i) {
            System.out.println();
            for (int j = 0; j < board[0].length; ++j)
                System.out.print(board[i][j] + " ");
        }
    }

    public Set<Integer> getValidElements(int i, int j) {
        Set<Integer> integerSet = new HashSet<>();
        for (int k = 1; k <= 9; ++k)
            integerSet.add(k);
        for (int m = 0; m < 9; ++m) {
            if (board[i][m] != 0) {
                integerSet.remove(board[i][m]);
            }
        }

        for (int m = 0; m < 9; ++m) {
            if (board[m][j] != 0) {
                integerSet.remove(board[m][j]);
            }
        }

        return integerSet;

    }
}
