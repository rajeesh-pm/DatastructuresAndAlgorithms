package com.learning.utils;

import java.awt.*;
import java.util.Arrays;
import java.util.Comparator;

class MinimumNumberOfMeetingRooms {

    public static void main(String args[]) throws Exception {
        MinimumNumberOfMeetingRooms meetingRooms = new MinimumNumberOfMeetingRooms();
//        [[0, 30],[5, 10],[15, 20]]

        int[][] arr = new int[][]{
                {5, 10},
                {0, 30},
                {15, 20}
        };
        System.out.println(meetingRooms.minMeetingRooms(arr));
    }


    public int minMeetingRooms(int[][] intervals) {
        Integer[] start = new Integer[intervals.length];
        Integer[] end = new Integer[intervals.length];
        for (int i = 0; i < intervals.length; ++i) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        for (int[] interval : intervals) {
            for (int anInterval : interval)
                System.out.print(anInterval + " ");
            System.out.println();
        }
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        System.out.println("------");
        for (int[] interval : intervals) {
            for (int anInterval : interval)
                System.out.print(anInterval + " ");
            System.out.println();
        }

        Arrays.sort(end, (a, b) -> (a - b));
        Arrays.sort(start, (a, b) -> (a - b));

        int startPointer = 0;
        int endPointer = 0;
        int usedRooms = 0;

        while (startPointer < intervals.length) {
            if (start[startPointer] >= end[endPointer]) {
                usedRooms -= 1;
                ++endPointer;
            }

            usedRooms += 1;
            startPointer += 1;
        }

        return usedRooms;
    }

    public int findMinArrowShots(int[][] points) {

//        [[10,16], [2,8], [1,6], [7,12]]


        if (points == null || points.length == 0) {
            return 0;
        }
        points = new int[][]{{10, 16}, {2, 8}, {7, 12}};
        // sort the array of balloons by ending position
        Arrays.sort(points, (a, b) -> (a[1] - b[1]));

        int arrowPos = points[0][1];
        int arrowCnt = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= arrowPos) {
                continue;
            }
            // if the balloon's starting position isn't in the range
            // then add the counter and update the arrowPos
            arrowCnt++;
            arrowPos = points[i][1];
        }

        return arrowCnt;
    }

}
