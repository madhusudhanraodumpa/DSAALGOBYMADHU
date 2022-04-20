package com.org.prep.sliding;

public class MaximumSumSubarrayofsizeK {
    public static void main(String args[]){
        int a[]={2,5,1,8,2,9,1};
        System.out.println(maxSubArrayLen(3,a));
    }

    private static int maxSubArrayLen(int i, int[] a) {
        int start = 0;
        int end  =0;
        int k = i;
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;

        while (end<a.length){
            sum = sum+a[end];
            if(end-start+1 == k){
                maxSum = Integer.max(sum,maxSum);
                sum = sum-a[start];
                start++;
            }
            end++;
        }
        return maxSum;
    }

}
