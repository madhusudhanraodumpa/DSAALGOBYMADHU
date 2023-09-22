package com.org.prep.array;
import java.util.*;
public class SubarraySumZero {

    public static void main(String[] args){
        int a[]={-19, 8, 2, -8, 19, 5, -2, -23};
        lszero(a);
    }

    public static int[] lszero(int[] A) {
        int n=A.length;
        int preSum=0;
        Map<Integer,Integer> m=new HashMap<>();
        int start=0;
        int end=0;
        int len=0;
        m.put(0,-1);

        for(int i=0;i<n;i++){
            preSum=preSum+A[i];

            if(preSum==0 || m.containsKey(preSum)){
                int x= m.get(preSum);
                if(i-x>len){
                    len=i-x;
                    start=x+1;
                    end=i;

                }

            }else {
                m.put(preSum, i);
            }
        }

        int a[]=new int[len];
        if(len>0) {
            int j = 0;
            for (int i = start; i <= end; i++) {
                a[j++] = A[i];
            }
        }
        return a;

    }

}
