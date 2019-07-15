package com.learning.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class StringTest {

	 String str = "a";
	 void A() {
		 try {
			 str += "b";
			 B();
		 }
		 catch (Exception e) {
			 str += "c";
		 }
	 }
	 
	 void B() throws Exception{
		 try {
			 str += "d";
			 C();
		 }
		 catch (Exception e) {
			  throw new Exception();
		 }
		 
		 finally {
			 str +="e";
		 }
		 
		 str += "f";
	 }
	 void C() throws Exception {
		 throw new Exception();
	 }
	 
	 void display() {
		 System.out.println(str);
	 }
	 
	 public static void main(String args[]) {
		 //new Thread(new Two(),"gfg1").start();
		 Set set = new TreeSet();
			set.add(1);
			set.add(2);
			set.add(3);
			
			Iterator iter = set.iterator();
			while(iter.hasNext()){
				System.out.println(iter.next() + " ");
			}
			
			Map<String,String> map = new HashMap<String,String>();
			String a = new String("a");
			String b = new String("a");
			System.out.println("A == " + a.hashCode() );
			System.out.println("A == " + b.hashCode() );
			map.put(new String("a"),"Rajeesh");
			
				map.put(new String("a"), "Rajeesh123124");
			System.out.println(map);
	 }
	 
	 
}

class One implements Runnable {
		public void run() {
			System.out.print(Thread.currentThread().getName());
		}
		
}

class Two implements Runnable {
	public void run() {
		new One().run();
		new Thread(new One(),"gfg2").run();
		new Thread(new One(),"gfg3"). start();
	}
}

class Three {
	public static void main(String args[]) {
		new Thread(new Two(),"gfg1").start();
		
		
	}
}
