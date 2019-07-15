package com.learning.utils;

import java.io.IOException;

public class Base {
	int testMethod() throws IOException {
		return 123;
	}
	
	public Base() {
		System.out.println("Inside base");
	}
	
	public void sing(){
		System.out.println("H");
	}
	public int val =10;
	

}

class Derived extends Base {
	
}
