//Find a triplet with zero sum
package com.learning.utils;
import java.util.*;
public class TripletsZeroSum {

	public static void main(String args[]) throws Exception {
		int arr[] = {0, -1, 2, -3, 1};
		int n = arr.length;
		Arrays.sort(arr);
		boolean found = true;
		for(int i = 0 ; i < n-1 ; ++i) {
			int l = i+ 1;
			int r = n -1;
			int x = arr[i];
			
			while(l<r) {
				if(x + arr[l] + arr[r] == 0){
					System.out.println(x + " "  + arr[l] + " " + arr[r]);
					l++;
					r--;
				}
				else if (x + arr[l] + arr[r] < 0) {
					l++;
				}
				else {
					r--;
				}
			}
		}
		
		if(found == false) {
			System.out.println("No Triplet found");
		}
	}
}
