package com.learning.utils;

import java.util.HashMap;
import java.util.Map;

public class raj {


    static int kDifference(int[] a, int k) {

        Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
        int count = 0;
        for (int anA : a) {
            if (mp.get(Math.abs(anA - k)) != null) {
                ++count;
            } else {
                mp.put(anA, anA);
            }
        }
        return count;
    }

}
