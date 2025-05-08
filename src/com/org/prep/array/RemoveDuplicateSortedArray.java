package com.org.prep.array;

public class RemoveDuplicateSortedArray {
    public static void main(String[] args) {
        int a[]={0,0,1,1,1,2,2,3,3,3};
        removeDuplicates(a);

    }
    public static int removeDuplicates(int[] nums) {
        int n=nums.length;
        int start=0;
        int end=0;

        while(end<n-1) {
            if(nums[end]!=nums[end+1]) {
                nums[start++]= nums[end];
            }
            end++;

        }
       nums[start++]=nums[end];
        return start;

    }
}
