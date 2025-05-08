package com.org.prep.array;

public class FindDuplicateNumber {
    public static void main(String[] args) {
        int a[]={1,3,4,2,2};
        System.out.println(findDuplicate(a));

    }
    public static int findDuplicate(int[] nums) {
        if(nums.length<=1){
            return -1;
        }
        int i=0;
        while(i<nums.length){
            if(nums[i]!=nums[nums[i]-1]){
                int index=nums[i]-1;
                int temp=nums[i];
                nums[i]=nums[index];
                nums[index]=temp;

            }else{
                i++;
            }
        }
        return nums[nums.length-1];
    }
}
