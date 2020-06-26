package com.org.learnby.hash;

import java.util.*;

public class LongestSubarrayWithSumZero {

    static class Postion{
        int start;
        int end;
        public Postion(int start,int end){
            this.end=end;
            this.start=start;
        }
    }

    public static void main(String args[]){

        int a[]= {4, -3, 1, -2, 3, 2, -1, -5, 1, 6, -1,-1};
        List<Postion> list=new ArrayList<>();
        System.out.println(longestSubArray(a,a.length,list));
        for(Postion p:list){
         //   System.out.println("Subarray indes strat from "+p.start+" to end "+p.end);
        }
    }

    private static int longestSubArray(int[] a, int n,List<Postion> list) {
        int longestSubArray=Integer.MIN_VALUE;
        Map<Integer,Integer> map=new HashMap<>();
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=a[i];
           if(sum==0 || map.containsKey(sum)){
               Postion p=new Postion(map.getOrDefault(sum,0),i);
               list.add(p);
               int prev=map.getOrDefault(sum,0);
               longestSubArray=Math.max(longestSubArray,i-prev);
               //longestSubArray=(i-map.getOrDefault(sum,0))+1>longestSubArray?(i-map.getOrDefault(sum,0))+1:longestSubArray;
           }else{
               map.put(sum,i);
           }
        }
        return longestSubArray;


    }
}
