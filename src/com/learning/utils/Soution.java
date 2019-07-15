package com.learning.utils;

import java.util.HashMap;
import java.util.Map;

public class Soution {

    static void countNumbers(int[][] arr) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            int count = 0;
            for (int start = arr[i][0]; start <= arr[i][1]; ++start) {

                HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
                boolean repeat = false;
                while (start > 0) {
                    int temp = start % 10;
                    if (m.get(temp) != null) {
                        repeat = true;
                        break;
                    } else {
                        m.put(temp, 0);
                    }
                    start = start / 10;
                }
                if (!repeat) {
                    count++;
                }
            }
            System.out.println(count);
        }


    }

    public static  String getBullCowHintUsingHashMap(String secret, String guess) {
        // This solution can be improved handling all the scenarios.
        int a = 0;
        int b = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < secret.length(); ++i) {
            if (secret.charAt(i) == guess.charAt(i)) {
                a++;
            }
            else{
                if(map.containsKey(guess.charAt(i))){
                    ++b;
                    map.remove(guess.charAt(i));
                    continue;
                }
                map.put(secret.charAt(i), 1);
                map.put(guess.charAt(i), 1);
            }
        }

        return a+"A"+b+"B";

    }

    public static  String getBullCowHintUsingArray(String secret, String guess) {
        int countBull = 0;
        int countCow =  0;

        int[] arr1 = new int[10];
        int[] arr2 = new int[10];

        for(int i=0 ; i < secret.length(); ++i) {
            char c1 = secret.charAt(i);
            char c2 = guess.charAt(i);

            if(c1 == c2){
                ++countBull;
            }
            else {
                arr1[c1 - '0']++;
                arr2[c2 - '0']++;
            }
        }

        for(int i = 0; i < arr1.length; ++i){
            countCow += Math.min(arr1[i], arr2[i]);
        }

        return countBull + "A" + countCow + "B";
    }


    static void mergeArrays() {

        int[] a = {1, 5, 7, 7};
        int[] b = {0, 1, 2, 3};
        int m = a.length;
        int res[] = new int[2 * m];
        int i = 0, j = 0, k = 0;
        while (i != m && j != m) {
            if (a[i] < b[j]) {
                res[k] = a[i];
                System.out.println("if " + res[k]);
                ++k;
                ++i;
            } else {
                res[k] = b[j];
                System.out.println("val " + res[k]);
                ++k;
                ++j;
            }
        }

        while (i < m) {
            res[k] = a[i];
            ++k;
            ++i;
        }
        while (j < m) {
            res[k] = b[j];
            ++k;
            ++j;
        }


        for (i = 0; i < 2 * m; ++i) {
            System.out.println(res[i]);
        }

    }

    public static void main(String args[]) {
        mergeArrays();
        System.out.println(getBullCowHintUsingArray("1807", "7810"));
    }
}
