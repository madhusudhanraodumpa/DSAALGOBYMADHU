package com.org.learnby.hash;

import java.util.HashMap;

public class LongetSubArrayWithSumK {
    public static void main(String args[]){
        int a[]={4,1,1,1,2,3,5};
        int k=5;
        System.out.println(longestSubArrayWithSum(a,a.length,k));
    }

    private static int longestSubArrayWithSum(int[] a, int n, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int sum=0;
        int longetSubarray=Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            sum+=a[i];


            if(sum==k){
                longetSubarray=Math.max(i+1,longetSubarray);
            }
            if(map.containsKey(sum-k)){
                int prev=map.get(sum-k);
                longetSubarray=Math.max(longetSubarray,i-prev);

            }else{
                map.put(sum,i);

            }

        }

        return longetSubarray;

    }
}
