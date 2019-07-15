package com.learning.utils;

import javax.sql.rowset.spi.SyncResolver;
import java.util.*;

import static java.lang.Math.sqrt;
import static java.util.stream.LongStream.rangeClosed;

public class AllSubsetsSumsToN {

    public static void main(String args[]) throws Exception {
        List<Integer> elements;
        Integer[] numbers = {3, 9, 8, 4, 5, 7, 10};
        elements = new ArrayList<>(Arrays.asList(numbers));
        int target = 15;
        List<Integer> partial = new ArrayList<>();
        findAllSubset(elements, partial, target);
        List<List<String>> some = new ArrayList<>();
        fetchItemsToDisplay(some);
    }

    public static void findAllSubset(List<Integer> elements, List<Integer> partial, int target) {

        // System.out.println("Processsing " + Arrays.toString(elements.toArray()));
        //System.out.println("With partial " + Arrays.toString(partial.toArray()));
        int s = partial.stream().mapToInt(Integer::intValue).sum();
        if (s == target)
            System.out.println("Sum(" + Arrays.toString(partial.toArray()) + ")" + target);
        if (s >= target)
            return;

        for (int i = 0; i < elements.size(); ++i) {
            List<Integer> remaining = new ArrayList<>();
            int n = elements.get(i);
            for (int j = i + 1; j < elements.size(); ++j) {
                remaining.add(elements.get(j));
            }
            List<Integer> partial_rec = new ArrayList<>(partial);
            partial_rec.add(n);
            findAllSubset(remaining, partial_rec, target);
        }
    }

    public static void numberOfSubset() {

    }

    private boolean isPrime(long n) {
        return n > 1 && rangeClosed(2, (long) sqrt(n)).noneMatch(divisor -> n % divisor == 0);
    }

    public static List<String> fetchItemsToDisplay(List<List<String>> items) {
        // Write your code here

        Collections.sort(items, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> o1, List<String> o2) {
                return (Integer.valueOf(o1.get(0)).compareTo(Integer.valueOf(o2.get(0))));
            }
        });
        int pageNumber = 5;
        int itemsPerPage = 8;

        for (int i = (pageNumber - 1) * itemsPerPage; i < pageNumber * itemsPerPage; ++i)
            items.get(i);

        return null;

    }

    public void timeOfBuffering(int arrivalRate, List<Integer> packets) {
        // Write your code here

        Set<Integer> bufferSet = new HashSet<>();
        int k = 0;

        for (int i = 0; i < packets.size(); i = i + arrivalRate) {
            ++k;
            for (int j = i; j < i + arrivalRate; ++j) {
                if (packets.get(j) > k) {
                    bufferSet.add(packets.get(j));
                    continue;
                }
                if (packets.get(j) == j + 1 || bufferSet.contains(packets.get(j))) {
                    continue;
                }
            }

        }
    }
}
