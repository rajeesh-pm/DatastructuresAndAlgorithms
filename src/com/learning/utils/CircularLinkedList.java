package com.learning.utils;
/*
* Problem Statement
*
* There are n knights standing in a circular fashion.
* One sword is given to the first knight. Each knight has to kill a person right next to him and hand over the node to next to next person.
* Find the last person who survives.
*
*
* */

public class CircularLinkedList {

    class Node{
        Node next;
        int data;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public Node findSurvivor(Node current){
        while(current.next != current){
            current.next = current.next.next;
            current = current.next;
        }

        return current;
    }

    public Node createList(int data){
        Node node ;
        Node prev=null;
        Node first = null;
        for(int i = 1; i <= data; ++i){
            node = new Node(i);
            if(prev != null){
                prev.next = node;
            }
            else{
                first = node;
            }
            prev=node;
        }
        prev.next = first;
        return first;
    }

    public static void main(String[] args){
        CircularLinkedList circularLinkedList = new CircularLinkedList();
        Node head = circularLinkedList.createList(100);
        System.out.println("The survivor is: " + circularLinkedList.findSurvivor(head).data);

        System.out.println("The survivor is: " + circularLinkedList.recursive(100));
    }

    public int recursive(int n){
        if(n == 1)
            return 1;
        if(n%2 ==0){
            return 2*recursive(n/2) - 1;
        }
        else{
            return 2*recursive(n/2) + 1;
        }
    }
}
