package com.learning.utils;

import java.util.PriorityQueue;

public class Increment {
    public static void main(String[] args) throws Exception {
        int i = 0;

        for (; i < 8;) {
            int j = ++i;
            System.out.println("j" + j);

            System.out.println(i);
        }

        for (i = 0; i < 8;) {
            int j = i++;
            System.out.println("j" + j);
            System.out.println(i);
//            System.arraycopy();
        }


        PriorityQueue<Integer> heap =
                new PriorityQueue<>((n1, n2) -> n1 - n2);
        heap.add(1);
        heap.add(2);
        heap.add(3);

        System.out.println(heap.peek());
        System.out.println(heap.poll());
        System.out.println(heap.poll());
        System.out.println(heap.poll());

        for(Integer b : heap){
            System.out.println(b);
        }

    }
}
