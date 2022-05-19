package com.org.prep.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeInterval {


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
