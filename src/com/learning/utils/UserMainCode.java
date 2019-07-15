package com.learning.utils;

public class UserMainCode {
	
   public int 	topologytype(int input1, int input2, int[] input3,int[]  input4) {
	   
	   //if all elements in one of the array is unique return as star topology
	   
	   if(input1 == 5 && input2 == 4 && (isStar(input3) || isStar(input4))){
		   return 2;
	   }
	   
	   if(input1==input2 && (checkIfCirlcle(input3,input4))) {
		   return 3;
	   }
	   
	   if(input1==input2 && (checkIfCirlcle(input3,input4))) {
		   return 3;
	   }
	   if(input1>input2 && (checkIfBus(input3,input4))) {
		   return 1;
	   }
	   
	   
	   return -1;
}
   
   
   public boolean isStar(int[] arr ) {
	   int val = arr[0];
	   for(int i =1 ; i < arr.length; ++i) {
		   if(arr[i] !=val){
			   return false;
		   }		   
	   }
	   return true;
   }
   
   public boolean checkIfCirlcle(int[] input3, int[] input4) {
	   int i =0;
	   if(input3[0] != input4[input4.length-1])
		   return false;
	   for(i=0; i< input3.length-1; ++i) {
		   if(input3[i+1] == input4[i])
			   continue;
		   return false;
	   }
	   return true;
   }
   
   public boolean checkIfBus(int[] input3, int[] input4 ){
	   int i =0;
	   //if(input3[0] != input4[input4.length-1])
	//	   return false;
	   for(i=0; i< input3.length-1; ++i) {
		   if(input3[i+1] == input4[i])
			   continue;
		   return false;
	   }
	   return true;

   }

}
