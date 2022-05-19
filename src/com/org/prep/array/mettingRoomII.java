package com.org.prep.array;

import java.util.Arrays;
import java.util.PriorityQueue;

public class mettingRoomII {

    public static int mettingRoom(int[][] intervals) {


        Arrays.sort(intervals,(a, b)->Integer.compare(a[0],b[0]));

        int n=intervals.length;
        PriorityQueue<Integer> pq= new PriorityQueue<>();



        for(int i=0;i<n;i++){
            if(i==0){
                pq.add(intervals[i][1]);
            }else{

                if(pq.peek()>intervals[i][0]){
                    pq.add(intervals[i][1]);
                }else {
                    pq.remove();
                    pq.add(intervals[i][1]);
                }


            }



        }
        return pq.size();

    }
}
