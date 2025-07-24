package com.tree;

import java.util.Arrays;
import java.util.PriorityQueue;

public class NumberOfMeetingRooms_self {

    public static int getNUmberOfMeetingRooms(int[][] meeting_time){
        Arrays.sort(meeting_time, (a,b)-> a[0]-b[0]);
        PriorityQueue<Integer> pq =  new PriorityQueue<>();
        pq.add(meeting_time[0][1]);
        for(int i = 1; i <meeting_time.length; i++){

            if(meeting_time[i][0] >= pq.peek()){
                pq.poll();
            }

            pq.add(meeting_time[i][1]);

        }
        return pq.size();
    }

    public static void main(String[] args) {
        int meeting_times[][] = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println(getNUmberOfMeetingRooms(meeting_times));
        int[][] test2 = {{7, 10}, {2, 4}};
        System.out.println(getNUmberOfMeetingRooms(test2)); // Output: 1
    }
}
