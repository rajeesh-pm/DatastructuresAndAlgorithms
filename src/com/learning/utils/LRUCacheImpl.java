package com.learning.utils;

import java.util.HashMap;

public class LRUCacheImpl {
    int capacity;
    Node head = null;
    Node last = null;
    HashMap<Integer, Node> map = new HashMap<Integer, Node>();

    public static void main(String args[]) {
        LRUCacheImpl lruCache = new LRUCacheImpl(5);
        lruCache.addElement(1, 1);
        lruCache.addElement(2, 2);
        lruCache.addElement(3, 3);
        lruCache.addElement(4, 4);
        lruCache.addElement(5, 5);
        lruCache.addElement(6, 6);
        lruCache.printList();


        System.out.println(lruCache.getElement(1));
        lruCache.addElement(7, 7);
        lruCache.printList();


    }
    public LRUCacheImpl(int capacity) {
        this.capacity = capacity;
    }

    public void printList(){
        Node head = this.head;
        while(head!=null){
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public int addElement(int key, int val) {
        Node element = map.get(key);
        if (element != null) {
            rearrangeElements(element);
            element.data = val;
        }

        else{
            element = new Node(key, val);


            if(map.size() == 0){
                last = element;
                head = element;
            }
            else{
                element.next = head;
                head.prev = element;
                head = element;
            }

            System.out.println("Size= " + map.size());

            if(map.size() >= capacity){
                System.out.println("last" + last.key + " " + last.data);
                Node rm = map.remove(last.key);
                System.out.println("removing" + rm.data);
                last = last.prev;
                rm.prev = null;
                last.next = null;
            }

            map.put(key, element);
        }

        return val;

    }

    public int getElement(int key) {
        Node element = map.get(key);
        if (element != null) {

            rearrangeElements(element);
            return element.data;
        }
        return -1;
    }

    public void rearrangeElements(Node element) {
        if (element != head && element != last) {
            element.prev.next = element.next;
            element.next.prev = element.prev;
            element.prev = head;
            element.next = head;
            element.prev = null;
            head = element;
        } else if (element == last) {
            element.prev.next = null;
            last = element.prev;
            element.next = head.next;
            element.prev = null;
            head = element;
        }
    }

    class Node {
        int data;
        Node next;
        Node prev;
        int key;

        Node(int key, int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
            this.key = key;
        }
    }
}
