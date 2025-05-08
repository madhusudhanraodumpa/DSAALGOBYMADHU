package com.org.prep.binarysearch;

public class MinimumLimitsBallInBag {
    public static void main(String[] args) {
        int a[]={1000000000,1000000000,1000000000};
        System.out.println(minimumSize(a,1000000000));

    }
    public static int minimumSize(int[] nums, int maxOperations) {
        int n=nums.length;
        int h=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            h=Math.max(h,nums[i]);
        }
        int l=1;
        int ans=-1;
        while(l<=h){
            int m=(l+h)/2;
            if(checkIsPossiblePenaltyCost(nums,m,maxOperations,n)){
                ans=m;
                h=m-1;
            }else{
                l=m+1;
            }
        }
        return ans;
    }
    public static boolean checkIsPossiblePenaltyCost(int[] a,int cost,int maxOperations,int n) {
        int count=0;
        for(int i=0;i<n;i++){
            if(a[i]>cost){
                int opt=(a[i]-cost)/cost;
                count=count+opt;

            }

        }
        return ((int)count)<=maxOperations;


    }
}
