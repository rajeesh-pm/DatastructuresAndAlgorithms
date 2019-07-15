package com.learning.utils;

import java.util.Scanner;

public class MaxSubSquareMatrix {
	public static void main(String args[]) throws Exception {
		System.out.println("Enter mXn");
		Scanner sc = new Scanner(System.in);
		int m  = sc.nextInt();
		int n = sc.nextInt();
		//sc.close();
		int arr[][] = new int[m][n];
		for(int i = 0; i<m ;++i) {
			for(int j =0 ; j< n ; ++j){
				arr[i][j] = sc.nextInt();
			}
		}
		int res[][] = new int[m][n];
		for(int i= 0; i<m; ++i ) {
			for (int j=0; j<n; ++j) {				
				if(arr[i][j] == 1){
					res[i][j] = Math.min(Math.min((j>0 ? res[i][j-1]: 0), (i>0 ? res[i-1][j] : 0)),(((i > 0 && j > 0)  ? res[i-1][j-1] : 0)));
				}
				else {
					res[i][j] = 0;
				}
			}
		}
	}

}
