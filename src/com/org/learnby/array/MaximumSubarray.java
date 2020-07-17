package com.org.learnby.array;

public class MaximumSubarray {

    public static void main(String args[]){
        int a[]={-3,2,5,-1,6,3,-2,7,-5,2};
        System.out.println(maxSubArray(a));
    }

    public static int maxSubArray(int[] nums) {
        int sum=0;
        int maxSum=Integer.MIN_VALUE;
        int max_element=Integer.MIN_VALUE;
        boolean isPositiveExits=false;

        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                isPositiveExits=true;
            }
            max_element=Math.max(max_element,nums[i]);
            sum+=nums[i];
            if(sum<0){
                sum=0;
                continue;
            }
            maxSum=Math.max(maxSum,sum);
        }
        return isPositiveExits?maxSum:max_element;



    }

}
