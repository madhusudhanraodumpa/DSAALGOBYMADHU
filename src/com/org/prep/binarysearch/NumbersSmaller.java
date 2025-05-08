package com.org.prep.binarysearch;

public class NumbersSmaller {
    public static void main(String[] args) {
        int a[]={8,1,2,2,3};
        smallerNumbersThanCurrent(a);


    }
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int n=nums.length;
        int count[]=new int[101];
        for(int i=0;i<n;i++){
            count[nums[i]]= count[nums[i]]+1;
        }
        for(int i=1;i<101;i++){
            count[i]=count[i]+count[i-1];

        }
        int ans[]=new int[n];
        for(int i=0;i<n;i++){
            ans[i]=count[nums[i]]-1;
        }
        return ans;
    }
}
