package com.org.prep.test;

import java.util.*;
import java.util.stream.Collectors;

public class Test {
    public static void main(String args[]) {
        int a[] = {1,2,3,2,1};
          System.out.println(0%20);
    }


    public static int solve(int[] A, int B) {
        int sum =0;
        int count =0;
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<A.length;i++){

            if(map.containsKey(A[i])){
                count =count + map.get(A[i]);
                map.put(B-A[i], map.get(B-A[i])!=null ? map.get(B-A[i])+1 :1);

            }else{

                map.put(B-A[i], map.get(B-A[i]) !=null ? map.get(B-A[i])+1 : 1);
            }
        }

        return count;

    }

}
