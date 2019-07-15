package com.learning.utils;

import java.util.*;

public class PriorityQueueExample {

    public static void main(String[] args) {

        //natural ordering example of priority queue
        Queue<Integer> integerPriorityQueue = new PriorityQueue<>(7, Collections.reverseOrder());
        Random rand = new Random();
        for (int i = 0; i < 7; i++) {
            integerPriorityQueue.add(new Integer(rand.nextInt(100)));
        }
        for (int i = 0; i < 7; i++) {
            Integer in = integerPriorityQueue.poll();
            System.out.println("Processing Integer:" + in);
        }

        //PriorityQueue example with Comparator
        Queue<Customer> customerPriorityQueue = new PriorityQueue<>(7, idComparator);
        addDataToQueue(customerPriorityQueue);

        pollDataFromQueue(customerPriorityQueue);

    }

    //Comparator anonymous class implementation
    public static Comparator<Customer> idComparator = new Comparator<Customer>() {

        @Override
        public int compare(Customer c1, Customer c2) {
            return (int) (c2.getId() - c1.getId());
        }
    };

    public static Comparable<Customer> id = new Comparable<Customer>() {
        @Override
        public int compareTo(Customer o) {
            return 0;
        }
    };

    //utility method to add random data to Queue
    private static void addDataToQueue(Queue<Customer> customerPriorityQueue) {
        Random rand = new Random();
        for (int i = 0; i < 7; i++) {
            int id = rand.nextInt(100);
            customerPriorityQueue.add(new Customer(id, "Pankaj " + id));
        }
    }

    //utility method to poll data from queue
    private static void pollDataFromQueue(Queue<Customer> customerPriorityQueue) {
        while (true) {
            Customer cust = customerPriorityQueue.poll();
            if (cust == null) break;
            System.out.println("Processing Customer with ID=" + cust.getId());
        }
    }
}

