package com.learning.utils;

public class BaseTest implements IBase{

	public void execute() {
		System.out.println("Execute");
		createOne();
	}
	
	protected void createOne() {
		System.out.println("Create One Base");
	}
	
	public static void main(String args[]) throws Exception {
		Base b = new Child("");
		Child c = new Child("");
		b.sing();
		c.sing();
		System.out.println(b.val);
		System.out.println(c.val);
		int x =0;
		try {
			//System.out.println(b.val/x);
			myMetod();
		}
		
		
        catch (Exception e){
			System.out.println("base caught");
		}
		
	}
	
	public static void myMetod() throws Exception{
		try{
			System.out.println(6/0);
		}
		catch(Exception e) {
			System.out.println("Exception devide by zero");
			throw e;
		}
		finally {
			System.out.println("finally");
		}
	}
}
