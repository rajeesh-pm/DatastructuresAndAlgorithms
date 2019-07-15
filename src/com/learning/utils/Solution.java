package com.learning.utils;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner in =  new Scanner(System.in);
        int n = in.nextInt();

        for(int k = 0 ; k<n ;++k) {
            String a = in.next();
            String b =  in.next();
            int x = a.length();
            int y = b.length();
            boolean res[][] = new boolean[y][x];
            char c,d;
            for(int i = 0 ; i<y ; ++i)
            {               
               for(int j = 0; j<x; ++j ){
                   d = b.charAt(i);
                   c = a.charAt(j);
                   if(Character.toUpperCase(c) == (Character.toUpperCase(d)) || !Character.isUpperCase(c) && j >= i)                                      {
                	   
                       if( i==0 ){
                           res[i][j] = true;
                       }
                       else if(!Character.isUpperCase(c) && Character.toUpperCase(c) != (Character.toUpperCase(d))){
                    	   res[i][j] = res[i][j-1];
                       }
                       else if(i>0 && j>0){
                            res[i][j] = res[i-1][j-1] || res[i][j-1];
                       }    
                   }
                   else {
                       res[i][j] =  false;
                   }
               }
            }
            System.out.println(res[y-1][x-1] ? "YES": "NO");
        }
        
        
        
    }
    
    static void fancySort(String[] exps) {
    	SortedMap<Integer, String> map = new TreeMap<Integer, String>();
    	for(int i=0; i< exps.length; ++i){
    		String[] values = exps[i].split(",");
    		int[] res = parseString(values);
    		if(values[0].equals("ADD")) {
    			int sum = 0;
    			for(int j =0 ; j< res.length; ++j){
    				sum+=res[j];
    			}
    				
    			map.put(sum, exps[i]);
    		}
    		else if(values[0].equals("SUBSTRACT")) {
    			int sum = 0;
    			for(int j =0 ; j< res.length; ++j){
    				sum-=res[j];
    			}
    			map.put(sum, exps[i]);
    		}
    		else if(values[0].equals("MULTIPLY")) {
    			int mult = 1;
    			for(int j =0 ; j< res.length; ++j){
    				mult*=res[j];
    			}
    			map.put(mult, exps[i]);
    		}
    		else if(values[0].equals("DIVIDE")) {
    			int val = res[0];
    			for(int j =1 ; j< res.length; ++j){
    				val /= res[j];
    			}
    			map.put(val, exps[i]);
    		}
    		else if(values[0].equals("MIN")) {
    			int min = res[0];
    			for(int j =1 ; j< res.length; ++j){
    				if(res[j] < min) {
    					min = res[j];
    				}
    			}
    			map.put(min, exps[i]);
    		}
    		else if(values[0].equals("MAX")) {
    			int max = res[0];
    			for(int j =1 ; j< res.length; ++j){
    				if(res[j] > max) {
    					max = res[j];
    				}
    			}
    			map.put(max, exps[i]);
    		}    		        
    }
    	
    	for (Map.Entry<Integer, String> entry : map.entrySet()) {
    	     System.out.println(entry.getValue());
    	}
    	


    }
    
    static int[] parseString( String[] values) {
    	if(values != null && values.length < 2){
    		return null;
    	}
    	int[] res =  new int[values.length - 1];
    	for(int i = 1, j =0; i<values.length;++i, ++j) {
    		res[j] = Integer.parseInt(values[i]);
    	}
    	
    	return res;
    }
}