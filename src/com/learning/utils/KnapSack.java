package com.learning.utils;

public class KnapSack {
	public static void main(String args[]) {
		int totalWeight = 7;
		int wt[] = {1,3,4,5};
		int val[] = {1,4,5,7};
		int ans[][] = new int[val.length + 1][totalWeight + 1];
		
		for(int i=0; i<=wt.length;++i) {
			for(int j=0;j<=totalWeight; ++j) {
				if(i == 0 || j ==0 ){
					ans[i][j] = 0;
					continue;
				}
				
				if( j - wt[i-1] >=0 )
					//System.out.println(i + " " +j);
					ans[i][j] = Math.max(val[i-1] + ans[i-1][j-wt[i-1]],ans[i-1][j]);
				else {
					ans[i][j] =  ans[i-1][j];
				}
			}
		}
		
		System.out.println(ans[wt.length][totalWeight]);
		
	}

}
