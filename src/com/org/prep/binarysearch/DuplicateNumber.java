package com.org.prep.binarysearch;

public class DuplicateNumber {
    public static void main(String[] args) {
        int[] a={1,3,4,2,2};
        System.out.println(findDuplicate(a));
    }
    public static int findDuplicate(int[] nums) {
        int n=nums.length;

        for(int i=0;i<n;i++){
            int val=Math.abs(nums[i]);
            if(nums[val]<0) return Math.abs(nums[i]);
            else {
                nums[val]=-nums[val];
            }
        }
        return -1;

    }
}
