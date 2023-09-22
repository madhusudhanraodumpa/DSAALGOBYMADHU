package com.org.prep.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeInterval {
    public static void main(String[] args) {
        int[][] intervals= {{1,4},{5,6}};
        merge1(intervals);
    }


    public static int[][] merge1(int[][] intervals) {

        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        List<int[]> list=  new ArrayList<>();

        int[] prevInt=intervals[0];

        int[] currentInt=intervals[0];

        if(intervals.length==1){
            list.add(currentInt);
        }

        for(int i=1;i<intervals.length;i++){
            currentInt = intervals[i];
            if(prevInt[1]>=currentInt[0]) {
                currentInt[0] = Math.min(prevInt[0],currentInt[0]);
                currentInt[1] = Math.max(prevInt[1],currentInt[1]);
            }
            list.add(currentInt);
            prevInt=currentInt;

        }
        return list.toArray(new int[list.size()][]);
    }


    public static int[][] merge(int[][] intervals) {


        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));

        int n=intervals.length;

        List<int[]> list=new ArrayList<>();

        for(int i=0;i<n;i++){
            int[] inter=new int[2];
            inter[0]=intervals[i][0];
            inter[1]=intervals[i][1];
            if(i==0){
                list.add(inter);
            }else{

                int[] prevInter=list.get(list.size()-1);

                if(prevInter[1]>= inter[0]){
                    prevInter[1]=Math.max(prevInter[1],inter[1]);
                }else {
                    list.add(inter);
                }

            }
        }
        return  list.toArray(new int[list.size()][]);

    }
}
