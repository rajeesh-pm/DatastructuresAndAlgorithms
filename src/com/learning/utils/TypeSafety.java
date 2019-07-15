package com.learning.utils;
import java.util.*;

public class TypeSafety {

	public static void main(String args[]) throws Exception {
		List ls = new LinkedList<>();
		ls.add("abc");
		ls.add(2);
		for(Object obj : ls){
			System.out.println(obj);
		}
	}
}
