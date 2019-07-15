package com.learning.utils;

import java.util.*;

public class Test {
	static String a = "ABCD";
	
	public Test() {
		// TODO Auto-generated constructor stub
		List<String> list = new ArrayList<String>();
		String str = "Abc";
		list.add("A");
		Map<String, List<String>> mp = new HashMap<String, List<String>>();
	    Map<String, List<String>> mp1 = new HashMap<>();
	    mp.put("",list);
	    mp.put("", list);
		List<String> ls = new ArrayList<>();
		ls.add("A");
		//ls.addAll(new ArrayList<>()); It fails compilation error.
		ls.addAll(new ArrayList<String>());
	    List<String> strs = new ArrayList<String>();
	    for (String st : strs){
	    	System.out.print(st);
	    }
	    System.out.print("Rajeesh Done");
	    String a = "";
	    System.out.println(a.equals(""));
	    System.out.println(a.length());
	}
	public static void main(String args[]) throws Exception{
		Test ts = new Test();
		/*ChildTest ch = new ChildTest();
		ch.execute();
		
		Child child = new Child("Chuma");*/
		System.out.println(a);
		
	}
    
}
