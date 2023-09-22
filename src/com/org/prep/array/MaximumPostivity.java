package com.org.prep.array;

import java.util.ArrayList;
import java.util.List;

public class MaximumPostivity {
    public static void main(String[] args) {
        int a[]={8986143,-5026827,5591744,4058312,2210051,5680315,-5251946,-607433,1633303,2186575};
        int[] b = solve(a);
        System.out.println(b);
    }


    public static int[] solve(int[] A) {

        int n=A.length;
        int start=0;
        int end=0;
        int startIndex=0;
        int endIndex=n-1;
        int maxLen=Integer.MIN_VALUE;
        int len=0;

        while(end<n){

            if(A[end]<0) {

                len=end-start;
                if(len>maxLen) {
                    startIndex=start;
                    endIndex =end-1;
                    maxLen=len;

                }
                start = end+1;


            }



            end++;
        }



        List<Integer> list = new ArrayList<>();
        for (int k = startIndex; k <= endIndex; k++) {
            list.add(A[k]);
        }
        return list.stream().mapToInt(x -> x).toArray();
    }


}
