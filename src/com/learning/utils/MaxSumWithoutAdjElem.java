package com.learning.utils;

import java.util.ArrayList;
import java.util.List;

public class MaxSumWithoutAdjElem {
	
	public static void main(String arg[]) throws Exception {
		int arr[] = {31, 5, 10, 100, 10, 30};
		System.out.println(maxSum(arr));
		System.out.println(maxUsingVar(arr));
		System.out.println("cir" + maxCircular(arr));

		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);

		list.add(0,0);

		list.forEach(x -> System.out.println(x));
	}
	
	public static int maxSum(int arr[]) {
		int[] sum = new int[arr.length];
		sum[0] = arr[0];
		sum[1] = Math.max(arr[0],arr[1]);
		for(int i =2; i< arr.length; ++i) {
			sum[i] = Math.max(sum[i-2] + arr[i], sum[i-1]);
		}
		 return sum[arr.length-1];
	}
	
	public static int maxUsingVar(int arr[]) {
		int excl =0,incl = 0;
		int temp;
		for(int i =0; i<arr.length; ++i) {
			temp = incl;
			incl = Math.max(excl + arr[i], incl);
			excl = temp;
		}
		return incl;
	}
	
	public static int maxCircular(int arr[]) {
		int excl =0,incl = 0;
		int temp, first;
		for(int i =1; i<arr.length; ++i) {
			temp = incl;
			incl = Math.max(excl + arr[i], incl);
			excl = temp;
		}
		first = incl;
		excl =0;incl = 0;
		for(int i =0; i<arr.length-1; ++i) {
			temp = incl;
			incl = Math.max(excl + arr[i], incl);
			excl = temp;
		}

		return Math.max(incl, first);
		
		
	}

}
