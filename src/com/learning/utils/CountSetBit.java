package com.learning.utils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.*;


public class CountSetBit {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		Integer[] arr = new Integer[size];
		for(int i =0 ; i<size; ++i) {
			arr[i] = sc.nextInt();
			
		}
	   
	   sortArray(arr);
	   for(int i = 0; i<arr.length;++i) {
		   System.out.println(arr[i]);
	   }
	   /*int a[] = {5,2,8,6,5,9};
	   sorrArraySecondMethod(a);*/
	}
	
	public static void sortArray(Integer[] arr) {
		//final int[] data = new int[] { 5, 4, 2, 1, 3 };
		//final Integer[] sorted = ArrayUtils.toObject(data);
		Arrays.sort(arr, new Comparator<Integer>() {
		    public int compare(Integer o1, Integer o2) {
		        Integer a = countBits(o1);
		        Integer b = countBits(o2);
		        if(a.compareTo(b) == 0) {
		        	return o1.compareTo(o2);
		        }
		        else 
		           return a.compareTo(b);
		    }
		});
	}
	
	public static Integer countBits(Integer val) {
		int a = (int) val;
		int count =  0;
		while(a > 0) {
			if((a & 1) >0){
				count++;
			}
			
			 a = a >> 1;
		}		
		return Integer.valueOf(count);		
	}
	
	public static void sorrArraySecondMethod(int arr[]) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>(32);
		System.out.println("size" + list.size());
		
		for(int i=0; i<31;++i){
			list.add(i, null);
		}
	
		for(int i = 0; i< arr.length; ++i) {
			int val = countBits(arr[i]);
			if(list.get(val) !=  null ) {
				list.get(val).add(arr[i]);
			}
			else {
				ArrayList<Integer> a = new ArrayList<Integer>();
				a.add(arr[i]);
				list.set(val, a);
			}
		}	
		
		for(ArrayList<Integer> arrList : list) {
			if(arrList != null){
			Collections.sort(arrList);
			for(Integer a : arrList){
				System.out.println(a);
			}}
		}
	}
}


