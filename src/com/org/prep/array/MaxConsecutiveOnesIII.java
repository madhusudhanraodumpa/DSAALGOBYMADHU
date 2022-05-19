package com.org.prep.array;

public class MaxConsecutiveOnesIII {
    public static void main(String args[]){
        int a[]={1,1,1,0,0,0};
        System.out.println(longestOnes(a,1));
    }



    public static int longestOnes(int[] nums, int k) {

        int start=0;
        int end=0;
        int count=0;
        int max=Integer.MIN_VALUE;
        while(end<nums.length){
            if(nums[end]==0){
                count++;
            }

            while(count>k){

                if(nums[start]==0){
                    count--;
                }
                start++;
            }

            max=Math.max(max,end-start+1);

            end++;

        }
        return max;
    }
}
