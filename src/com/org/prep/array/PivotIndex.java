package com.org.prep.array;

public class PivotIndex {
    public static void main(String[] args) {
        int[] a={2,1,-1};
        pivotIndex(a);

    }

    public static int pivotIndex(int[] nums) {
        int n=nums.length;
        int[] left=new int[n];
        int[] right=new int[n];

        left[0]=nums[0];
        for(int i=1;i<n;i++){
            left[i]=left[i-1]+nums[i];
        }
        right[n-1]=nums[n-1];

        for(int i=n-2;i>=0;i--) {
            right[i]=right[i+1]+nums[i];
        }
        int pivotIndex=-1;
        int leftSum=0;
        int rightSum=0;

        for(int i=0;i<n;i++) {
            if(i==0){
                leftSum=0;
            }else {
                leftSum = left[i] - nums[i];
            }
            rightSum=right[i]-nums[i];

            if(leftSum==rightSum) {
                pivotIndex=i;
            }

        }

        return pivotIndex;

    }
}
