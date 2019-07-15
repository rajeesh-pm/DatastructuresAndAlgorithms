package com.learning.utils;

public class FindDupElem {

	public static void main(String args[]) throws Exception {
		int arr[] = {1,2,3,3};
		for(int i =0; i< arr.length; ++i){
			if(arr[Math.abs(arr[i])] > 0){
				arr[Math.abs(arr[i])] =  -arr[Math.abs(arr[i])];
			}
			else{
				System.out.print(Math.abs(arr[i]) + " ");
			}
		}
	}

}
