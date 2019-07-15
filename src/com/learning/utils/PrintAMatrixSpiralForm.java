package com.learning.utils;

public class PrintAMatrixSpiralForm {
	public static void main(String args[]) throws Exception {
		int arr[][] = { {1,  2,  3,  4,  5,  6},
                        {7,  8,  9,  10, 11, 12},
                        {13, 14, 15, 16, 17, 18}
              };
		
		// eliminate rows and columns 
		// Divide the directions and write loop for each
		
		int m = 3, n = 6;
		int l = 0; //col start
		
		int k = 0; // row start
		int i;
		while(k<m && l <n) {
			for(i=l; i < n ; ++i){
				System.out.println(arr[k][i]);
			}
			
			++k;
			
			for(i=k; i < m; ++i)
				System.out.println(arr[i][n-1]);
			n--;
			
			if(k<m) {
				for(i=n-1; i>=l;--i){
					System.out.println(arr[m-1][i]);}
				m--;
			}
			
			if(l<n) {
				for(i=m-1; i>=k;--i)
					System.out.println(arr[i][l]);
				l++;
			}			
		}
	}

}
