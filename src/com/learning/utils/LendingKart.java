package com.learning.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LendingKart {
	
	static int firstVertex = 0;
	static HashMap<Integer,HashSet<Integer>>  hm = new HashMap<Integer,HashSet<Integer>>();
    
    public static void main (String[] args) throws java.lang.Exception 
 	{    
    	Scanner in =  new Scanner(System.in);
        int n = in.nextInt();
        int distance = in.nextInt();
        
        
        
        
        for(int i = 0; i < n -1 ; ++i) {
        	int val = in.nextInt();
        	int val2 = in.nextInt();
        	System.out.println("val val" + val + " " + val2);
        	if(i == 0) {
        		firstVertex = val;
        	}
        	
        	if(hm.get(val) != null){
        		Set<Integer> values = hm.get(val);
        		values.add(val2);
        	}
        	
        	else {
        		HashSet<Integer> values = new HashSet<>();
        		values.add(val2);
        		hm.put(val, values);
        	}	
        }
        
        findLength(firstVertex,0,distance);
        
        
        
 	}
    
    public static void findLength(int vertex,int count, int distance) {
    	
    	
    	Set<Integer> values = hm.get(vertex);
    	for(Integer s : values){
    		if(count == distance){
    			System.out.println(vertex);
    			return;
    		} 			
    		findLength(s,count + 1, distance);
    	}
    	
    }
    
  
	
	/*public static void main (String[] args) throws java.lang.Exception 
 	{    
    	Scanner in =  new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int i =0 ; i < n ; ++i ){
        	 arr[i] = in.nextInt();        	 
        }
        int diff = Integer.MAX_VALUE;
        for(int i = 0 ; i < n; ++i) {
        	for(int j = 0; j < n; ++j){
        		if (i == j)
        			continue;
        		if(Math.abs(arr[i] - arr[j]) < diff) {
        			diff = Math.abs(arr[i] - arr[j]);
        		}
        	}       	
        }
        System.out.println(diff);
 	}*/
}
