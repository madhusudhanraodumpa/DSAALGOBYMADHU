package com.org.prep.array;

public class FindPivotIndex {
        public static void main(String args[]){

            int a[]={1,7,3,6,5,6};
            pivotIndex(a);
        }

    public static int pivotIndex(int[] nums) {
        int n=nums.length;
        int a[]=new int[n];
        int sum=0;
        a[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
            a[i]=a[i+1]+nums[i];
        }
        if(a[0]==nums[0]) return 0;
        sum=nums[0];
        for(int i=1;i<n;i++){

            sum=sum+nums[i];
            if(a[i]==sum) return i;


        }
        return -1;

    }
}
