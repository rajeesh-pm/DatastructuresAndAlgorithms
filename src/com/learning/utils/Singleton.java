package com.learning.utils;

public class Singleton {
	private Singleton() {
		
	}
	
	public static Singleton instance = null;
	
	public static Singleton getInstance() {
		if(instance == null){
			synchronized(Singleton.class){
				if(instance == null){
					instance = new Singleton();
				}	
			}
		}
		return instance;
	}
}
