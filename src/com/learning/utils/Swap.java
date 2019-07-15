package com.learning.utils;

public class Swap {
	
	public static void main(String args[]){
		String str = "Move Spaces to the begining";
		char[] A = str.toCharArray();
		int n = A.length-1;
		int count =  n;
		int i = n;
		for(;i>=0;i--){
			if(A[i] !=  ' '){
				A[count--] = A[i]; 
			}
		}
		while(count>=0){
			A[count--]=' ';
		}
		
		for(i=0;i<A.length;++i){
			System.out.print(A[i]);
		}
	}

}
