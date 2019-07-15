/*Find the factorial of a big number
 * What is the value of 100! ? */

package com.learning.utils;

import java.util.Scanner;

public class Factorial {
	
	public static void main(String args[]) throws Exception {
		System.out.println("Enter the number");
		Scanner in = new Scanner(System.in);
		int number = in.nextInt();
		int res_size = 1;
		int res[] = new int[100];
		System.out.println(res[99]);
		res [0] = 1;
		for(int x = 2; x<=number; ++x){
			res_size =  multiply(x, res, res_size);
		}
		
		for(int i = res_size-1; i >= 0; --i)
			System.out.print(res[i]);
		
	}
	
	private static int multiply(int x, int res[], int res_size) {
		int carry = 0;
		int prod = 0;
		for (int i =0; i< res_size; ++i){
			prod = res[i] * x + carry;
			res[i] = prod % 10;
			carry = prod/10;
		}
		
		while(carry > 0) {
			res[res_size] =  carry%10;
			carry = carry/10;
			++res_size;
		}
		return res_size;
	}

}
