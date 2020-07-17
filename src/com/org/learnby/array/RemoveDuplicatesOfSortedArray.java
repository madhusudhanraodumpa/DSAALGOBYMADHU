package com.org.learnby.array;

public class RemoveDuplicatesOfSortedArray {
    public static void main(String args[]){
        int a[]={1,1,1,2,2,3};
        System.out.println(removeDuplicates1(a));
    }
    public static int removeDuplicates(int[] nums) {
        int start=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[i-1]){
                nums[start++]=nums[i];
            }
        }
        return start;

    }

    public static int removeDuplicates1(int[] nums) {
        int start=1;
        int count=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[i-1]){
                nums[start++]=nums[i];
                count=1;
            }else if(count<2 && nums[i]==nums[i-1]){
                nums[start++]=nums[i];
                count++;
            }
        }
        return start;
    }
}
