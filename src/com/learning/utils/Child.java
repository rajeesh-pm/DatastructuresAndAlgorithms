package com.learning.utils;

import java.io.IOException;
import java.util.Scanner;

public class Child extends Base{
	
	public int val =50;
	
	public Child(String data) {
		System.out.println(data);
	}
	public int testMethod(){
		return 456;
		
	}
	
	public void sing() {
		System.out.println("LLALA");
	}
}
