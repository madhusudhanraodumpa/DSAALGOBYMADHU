package com.org.prep.array;

public class RemoveDuplicateFromSortedArray {
    public static void main(String[] args) {
        int a[]={1,1,2};
        removeDuplicates(a);
    }

    private static int removeDuplicates(int[] nums) {
        int n=nums.length;
        int start=0;
        int end=1;

        while(end<n) {

            if(!(nums[start]==nums[end])) {
                int temp=nums[end];
                nums[end]=nums[start+1];
                nums[start+1]=temp;
                start++;
            }

            end++;
        }
        return start+1;
    }
}
