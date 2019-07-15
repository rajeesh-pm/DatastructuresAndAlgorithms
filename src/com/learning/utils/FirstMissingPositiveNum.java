package com.learning.utils;

import java.util.ArrayList;

public class FirstMissingPositiveNum {

	public int firstMissingPositive(ArrayList<Integer> a) {
	    int[] bitmap = new int[a.size() / 32 + 1];
	    for (int x : a) {
	        x -= 1;
	        int i = x / 32;
	        if (i < bitmap.length) {
	            int mask = 1 << (x % 32);
	            bitmap[i] |= mask;
	        }
	    }
	    for (int i = 0; i < bitmap.length; i++) {
	        if (bitmap[i] != -1) {
	            int shift = 0;
	            while ((bitmap[i] & (1 << shift)) != 0) {
	                shift++;
	            }
	            return i * 32 + shift + 1;
	        }
	    }
	    return -1;
	}
}
