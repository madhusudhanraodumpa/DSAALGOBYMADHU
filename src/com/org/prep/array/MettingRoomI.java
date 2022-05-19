package com.org.prep.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MettingRoomI {

    public static boolean mettingRoom(int[][] intervals) {


        Arrays.sort(intervals,(a, b)->Integer.compare(a[0],b[0]));

        int n=intervals.length;

        int endingPoint=intervals[0][1];
        for(int i=0;i<n;i++){

            if(endingPoint>intervals[i][0]){
                return false;
            }else {
                endingPoint=intervals[i][1];
            }

        }
        return  true;

    }
}
