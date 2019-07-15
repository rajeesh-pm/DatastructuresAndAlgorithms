package com.learning.utils;

import java.util.LinkedHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
 
/** Copyright (c), AnkitMittal JavaMadeSoEasy.com */
public class LinkedHashMapTest {
 public static void main(String args[]){
     
 
    Map<Integer,String> linkedHashMap=new LinkedHashMap<Integer,String>();
 
    linkedHashMap.put(11, "ankit");
    linkedHashMap.put(21, "javaMadeSoEasy");
    
 
    System.out.println("\n---1. Iterate on keys, by obtaining iterator on keySet---");
    //fail-fast
    Iterator<Integer> keyIterator=linkedHashMap.keySet().iterator();
    while(keyIterator.hasNext()){
           //linkedHashMap.put(4,"newEle1");//unComment to avoid ConcurrentModificationException
           System.out.println(keyIterator.next());
    }
    
 
    System.out.println("\n---2. Iterate on values, by obtaining iterator on values---");
    //fail-fast
    Iterator<String> valueIterator=linkedHashMap.values().iterator(); 
    while(valueIterator.hasNext()){
           //linkedHashMap.put(4,"newEle1");//unComment to avoid ConcurrentModificationException
           System.out.println(valueIterator.next());
    }
 
    System.out.println("\n---3. Iterate on entry, by obtaining iterator on entrySet---");
    //fail-fast
    Iterator<Entry<Integer, String>> entryIterator=linkedHashMap.entrySet().iterator();   
    while(entryIterator.hasNext()){
           //linkedHashMap.put(4,"newEle1");//unComment to avoid ConcurrentModificationException
           System.out.println(entryIterator.next());
    }
 
 }
 
}