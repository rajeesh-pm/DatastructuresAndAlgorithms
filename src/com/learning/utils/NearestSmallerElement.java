package com.learning.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
* Return the nearest smaller element on the left of array.
* return -1 if nothing is found
*
* */
public class NearestSmallerElement {
    public static void main(String[] args){
        int[] arr = {8, 7, 6, 5, 4};
        findNearestSmallerElement(arr);
    }

    public static void findNearestSmallerElement(int[] elem){
        Stack<Integer> stk = new Stack<>();
        List<Integer> arr = new ArrayList<>();
        for (int i : elem){
            while(!stk.isEmpty() && i <= stk.peek()){
                stk.pop();
            }

            if(stk.isEmpty()){
                arr.add(-1);
            }
            else{
                arr.add(stk.peek());
            }
            stk.push(i);
        }

        for(int i : arr){
            System.out.println(i);
        }
    }
}
