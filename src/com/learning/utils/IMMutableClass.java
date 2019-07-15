package com.learning.utils;
import java.math.*;

public final class  IMMutableClass{
	
	public final String immutableFiled1;
	public final Integer immuatableFiled2;
	
//	1. Make class final
//	2. Use only final instance variables
//	3. Make sure all instance vaiable classes are immuatble in nature. For eg : String and Integer are immutable classes.
//	but if you are using a date field make sure we are returning a copy of the object, so that consumers can't change instance variable values.
//	4. expose only getters. Setters are not allowed
	
	
	public IMMutableClass(String field1, Integer field2) {
		this.immutableFiled1 = field1;
		this.immuatableFiled2 = field2;
		
		
	}
	public static void main(String args[]) {
		Double d = 3.0;
		System.out.println(d.toString().split(".")[0]);
	}
		
}
