
/*	Given two arrays A & B of size N each.
Find the maximum n elements from the sum combinations (Ai + Bj) formed from elements in array A and B.

For example if A = [1,2], B = [3,4], then possible pair sums can be 1+3 = 4 , 1+4=5 , 2+3=5 , 2+4=6
and maximum 2 elements are 6, 5*/

/*
 * Sort both the arrays in ascending order.
Let us take priority queue (heap).
First max element is going to be the sum of the last two elements of array A and B i.e. (A[n-1] + B[n-1]).
Insert that in heap with indices of both array i.e (n-1, n-1).
Start popping from heap (n-iterations).
And insert the sum (A[L-1]+A[R]) and (A[L]+B[R-1]).
Take care that repeating indices should not be there in the heap (use map for that).
 * */
package com.learning.utils;

public class NMaxPair {

}
