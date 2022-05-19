package com.org.prep.array;

public class RemoveDuplicatesFromSortedArray {
public static void main(String[] args){
    int a[]={1,1,2};
    removeDuplicates(a);
}

    public static int removeDuplicates(int[] nums) {
        int n=nums.length;

        int count=0;
        int i=0;
        int j=0;
        for(i=0;i<n-1;i++){
            if(nums[i]!=nums[i+1]){
                nums[j]=nums[i];
                j++;
            }

            else{
                count++;
            }
        }
        nums[j]=nums[i];

        return n-count;
    }
}
