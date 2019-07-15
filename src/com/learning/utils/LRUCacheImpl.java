package com.learning.utils;

import java.util.HashMap;

public class LRUCacheImpl {
    int capacity;
    class Node{
        int data;
        Node next;
        Node prev;
        Node(int data){
            this.data = data;
            this.next = null;
            this.prev =null;
        }
    }

    Node head = null;
    Node last = null;

    HashMap<Integer, Node> map = new HashMap<Integer, Node>();

    public LRUCacheImpl(int capacity){
        this.capacity = capacity;
    }

    public void addElement(int data){
        if(map.get(data) != null){
            //update the links
            Node element  =  map.get(data);
            element.next.prev = element.prev;
            element.prev.next = element.next;

            element.next = head;
            head.prev =element;
            element.prev = null;
            head = element;
        }



        if(this.capacity > 0){

        }

        Node node = new Node(data);
        if(head == null && last == null){
            last = node;
        }
        node.next =  head;
        head = node;

    }



    public int getElement(int key) {

        return 0;
    }
}
