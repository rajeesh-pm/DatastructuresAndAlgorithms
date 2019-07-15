package com.learning.utils;

public class FindMaxNum {
	public static void main(String args[]) throws Exception{
		int arr[] = {7,9,6};
		Integer max = 796;
		max = findMaxAfterKRotation(arr,max,2);
		System.out.println(max);
	}
	
	public static int findMaxAfterKRotation(int[] arr, Integer max, int k) {
		if (k==0) 
			return max;
		int n = arr.length;
		int val;
		for(int i =0; i<n-1; ++i) {
			for(int j= i+1;j<n;++j) {
				if(arr[i] < arr[j]) {
					swap(i,j,arr);
					System.out.println("Swapped: New " + getIntval(arr));
				}
				val = getIntval(arr);
				if(val > max){
					max=val;
				}
				System.out.println("rotating " + val);	
				findMaxAfterKRotation(arr, max, k-1);
				swap(i,j,arr);
				System.out.println("Reswapping " + getIntval(arr));
			}
		}
		return max;
	}
	
	public static void swap(int i, int j, int[] arr) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	private static int getIntval(int arr[]) {
		int val = 0;
		
		for(int i=0,j=arr.length -1 ; i < arr.length; ++i,--j) {
			val += arr[i] * Math.pow(10, j);
		}
		return val;
	}

}
