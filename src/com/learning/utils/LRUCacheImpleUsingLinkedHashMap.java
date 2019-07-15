package com.learning.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LRUCacheImpleUsingLinkedHashMap extends LinkedHashMap<Integer, String> {
	
	private int capacity;

    public LRUCacheImpleUsingLinkedHashMap(int capacity, float loadfactor){
    	super(capacity,loadfactor,true);
    	this.capacity = capacity;
    }

    protected boolean removeEldestEntry(Map.Entry<Integer, String> eldest){
    	return size() > this.capacity;
    }
	public static void main(String args[]) {
		LRUCacheImpleUsingLinkedHashMap impl = new LRUCacheImpleUsingLinkedHashMap(4, 0.75f);
		impl.put(1, "One");
		impl.put(2, "Two");
		impl.put(3, "Three");
		impl.get(1);
		impl.put(4, "Four");
		impl.put(5, "Five");
		impl.put(6, "Six");
		System.out.println(impl);

		LinkedHashMap<Integer, String> ls = new LinkedHashMap<>(4, 0.75f, true);
		ls.put(1, "One");
		ls.put(2, "Two");
		ls.put(3, "Three");
		ls.put(4, "Four");
		ls.get(1);
		ls.put(5, "Five");
		ls.put(6, "Six");
		System.out.println(ls);


		Map<String, String> cuncurrentHashmap = new ConcurrentHashMap<>();
		cuncurrentHashmap.put("Raj", "Ponn");

		for(Map.Entry entry : cuncurrentHashmap.entrySet()){
			System.out.println(entry.getKey());
			cuncurrentHashmap.put("Sam", "Sam");
		}

		Map<String,String> normalMap =  new HashMap<>();
		normalMap.put("Raj", "Ponn");
		Iterator iterator = normalMap.keySet().iterator();
		while (iterator.hasNext()){
			System.out.println(iterator.next());
			normalMap.put("Sam", "Sam");
		}

		ConcurrentHashMap<String, Integer> map
				= new ConcurrentHashMap<String, Integer>();

		map.put("ONE", 1);
		map.put("TWO", 2);
		map.put("THREE", 3);
		map.put("FOUR", 4);

		// Getting an Iterator from map
		Iterator it = map.keySet().iterator();

		while (it.hasNext()) {
			String key = (String)it.next();
			System.out.println(key + " : " + map.get(key));

			// This will reflect in iterator.
			// Hence, it has not created separate copy
			map.put("SEVEN", 7);
		}

		map = new ConcurrentHashMap<String, Integer>();

		//Adding elements to map

		map.put("ONE", 1);

		map.put("TWO", 2);

		map.put("THREE", 3);

		map.put("FOUR", 4);

		//Getting an Iterator from map

		it = map.keySet().iterator();

		System.out.println("-------");

		while (it.hasNext())
		{
			String key = (String) it.next();

			System.out.println(key+" : "+map.get(key));

			map.put("FIVE", 7);     //This will not be reflected in the Iterator
		}
	}
}



