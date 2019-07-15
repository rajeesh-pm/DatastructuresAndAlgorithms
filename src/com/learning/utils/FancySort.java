package com.learning.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;


/*
 * 
 * 
 * 
 * ADD,2,3
ADD,8,3
SUBTRACT,1,1
SUBTRACT,8,3

Answer - they are sorted based upon the results of each operation. If the results are equal sort based on the operation string value
-------
SUBTRACT,1,1
ADD,2,3
SUBTRACT,8,3
ADD,8,3
 * */

public class FancySort {
	
	public static void main(String args[]) throws Exception{
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		String[] exps = new String[num];
		for(int i = 0; i< num ; i++) {
			exps[i] =  in.next();
			//System.out.println("Raj");
		}
		//System.out.println(exps.length);
		//for(int i =0; i<exps.length;++i) {
		//	System.out.println(exps[i]);
		//}
		fancySort(exps);
	}
	
	static void fancySort(String[] exps) {
    	Map<Integer,List<String>> map = new HashMap<Integer,List<String>>();
    	for(int i=0; i< exps.length; ++i){
    		String[] values = exps[i].split(",");
    		int[] res = parseString(values);
    		if(values[0].equals("ADD")) {
    			int sum = 0;
    			for(int j =0 ; j< res.length; ++j){
    				sum+=res[j];
    			}    				
    			addToMap(sum,map,exps[i]);
    		}
    		else if(values[0].equals("SUBTRACT")) {
    			int sum = 0;
    			for(int j =0 ; j< res.length; ++j){
    				sum-=res[j];
    			}
    			addToMap(sum,map,exps[i]);
    		}
    		else if(values[0].equals("MULTIPLY")) {
    			int mult = 1;
    			for(int j =0 ; j< res.length; ++j){
    				mult*=res[j];
    			}
    			addToMap(mult,map,exps[i]);
    		}
    		else if(values[0].equals("DIVIDE")) {
    			int val = res[0];
    			for(int j =1 ; j< res.length; ++j){
    				val /= res[j];
    			}
    			addToMap(val,map,exps[i]);
    		}
    		else if(values[0].equals("MIN")) {
    			int min = res[0];
    			for(int j =1 ; j< res.length; ++j){
    				if(res[j] < min) {
    					min = res[j];
    				}
    			}
    			addToMap(min,map,exps[i]);
    		}
    		else if(values[0].equals("MAX")) {
    			int max = res[0];
    			for(int j =1 ; j< res.length; ++j){
    				if(res[j] > max) {
    					max = res[j];
    				}
    			}
    			addToMap(max,map,exps[i]);
    		}    		        
    }
    	
    	for (Entry<Integer, List<String>> entry : map.entrySet()) {
    	     List<String> list = entry.getValue();
    	     Collections.sort(list);
    	     for(String s : list) {
    	    	 System.out.println(s);
    	     }
    	}
    	


    }
	
	static void addToMap(int val , Map<Integer,List<String>> map, String exp) {
		if(map.get(val) != null) {
			map.get(val).add(exp);
		}
		
		else {
			List<String> list = new ArrayList<String>();
			list.add(exp);
			map.put(val, list);
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
