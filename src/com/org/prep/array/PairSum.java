package com.org.prep.array;

import java.util.*;

public class PairSum {
    public static void main(String args[]){
        int a[]={1,2,3,4,5};
        solve(a,2);
    }


    public static int solve(int[] A, int B) {
        int n=A.length;
        int count=0;

        Map<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<n;i++){
            A[i]=A[i]%B;
        }

        for(int i=0;i<n;i++){

            if(map.containsKey(A[i])){
                count=count+map.get(A[i]);
            }
            if(A[i]==0){
                map.put(A[i], map.getOrDefault(A[i], 0) + 1);
            }else {

                map.put(B - A[i], map.getOrDefault(B - A[i], 0) + 1);
            }



        }
        return count;
    }

}
