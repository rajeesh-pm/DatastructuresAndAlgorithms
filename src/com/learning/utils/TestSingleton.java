package com.learning.utils;

public class TestSingleton {
	public static void main(String args[]) throws Exception {
		Singleton instance = Singleton.getInstance();
		Base b = new Base();
		System.out.println(b.testMethod());
		
		b = new Child("");
		System.out.println(b.testMethod());		
	}
}
