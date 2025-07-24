package com.tree;

import java.util.Arrays;
import java.util.PriorityQueue;

public class NumberOfMeetingRooms {
    public static void main(String[] args) {
        int meeting_times[][] = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println(findNumberOfMeetingRoomsNeeded(meeting_times));

        int[][] test2 = {{7, 10}, {2, 4}};
        System.out.println(findNumberOfMeetingRoomsNeeded(test2)); // Output: 1

        int[][] test3 = {{1, 5}, {8, 9}, {8, 9}};
        System.out.println(findNumberOfMeetingRoomsNeeded(test3));
    }

    private static int findNumberOfMeetingRoomsNeeded(int[][] meetingTimes) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        //Sort the timings wrt start time
        Arrays.sort(meetingTimes, (a, b) -> a[0]-b[0]);
        //Add 1st meeting end time in queue
        pq.add(meetingTimes[0][1]);
        for(int i = 1; i<meetingTimes.length; i++){
            if(meetingTimes[i][0] >= pq.peek()){
                // if stating time of next meeting is greater than ending time previous
                // then we can utilize the same meeting room
                pq.poll();
            }
            pq.add(meetingTimes[i][1]);
        }
        return pq.size();
    }
}
