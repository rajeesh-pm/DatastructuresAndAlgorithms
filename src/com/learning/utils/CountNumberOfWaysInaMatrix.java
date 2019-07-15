/*
 * Count number of ways to reach the bottom right end of matrix starting from top left corner.
 * 1 indicate open and 0 indicates blocked space
 * */

package com.learning.utils;

public class CountNumberOfWaysInaMatrix {
	
	public static void main(String args[]) throws Exception {
		int[][] arr = {{1,1,1,1},
				       {1,0,1,1},
				       {1,1,1,1}};
		
		
		for(int i =0 ; i < 3 ; ++i) {
			for(int j =0 ; j < 4; ++j) {
				if(i == 0 && j == 0)
					continue;
				if(arr[i][j] > 0) {
					arr[i][j] = 0;
					if(i> 0 && arr[i-1][j] > 0)
					  arr[i][j] +=  arr[i-1][j];
					if(j> 0 && arr[i][j-1] > 0)
						arr[i][j] +=  arr[i][j-1];
				}
				System.out.println("Val" + arr[i][j]);
			}
		}
		
		System.out.println(arr[2][3]);
	}

}
