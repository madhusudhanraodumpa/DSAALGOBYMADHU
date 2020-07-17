package com.org.learnby.array;

import java.util.HashMap;
import java.util.Map;

public class MinimumSizeSubarraySum {
    public static void main(String args[]){
        int a[]={2,3,1,2,4,3};
        System.out.println(minSubArrayLenNeg(7,a));
    }

    public static int minSubArrayLen(int s, int[] nums) {
        if(nums.length==0) return 0;
        int start=0;
        int end=0;
        int minLength=Integer.MAX_VALUE;
        int sum=0;
        while (end<nums.length){
            sum+=nums[end];

            while(s<=sum && end>=start){
                //// if(sum==s){
                minLength=Math.min(minLength,end-start+1);
                sum-=nums[start++];

                //  }
            }
            end++;
        }
        return minLength!=Integer.MAX_VALUE?minLength:0;
    }
    public static int minSubArrayLenNeg(int s, int[] nums) {
        if(nums.length==0) return 0;
        int start=0;
        int end=0;
        int minLength=Integer.MAX_VALUE;
        int sum=0;
        Map<Integer,Integer> map=new HashMap<>();

        while(nums.length>end){
            sum+=nums[end];
            if(map.containsKey(sum-s)){
                minLength=Math.min(end-map.get(sum-s),minLength);
                start++;

            }
                map.put(sum,end);

            end++;
        }
        return minLength!=Integer.MAX_VALUE?minLength:0;

    }
}
