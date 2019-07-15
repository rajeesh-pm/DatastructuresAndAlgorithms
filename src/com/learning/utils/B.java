package com.learning.utils;

public class B extends Thread{
	public static void main(String args[]) {
		B b = new B();
		b.run();
	}
	public void  start() {
		for(int  i = 0; i < 10;++i){
			System.out.println(i);
		}
	}

}
