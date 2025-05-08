package com.org.prep.binarysearch;

public class SplitArrayLargestSum {
    public static void main(String[] args) {
        int a[] ={7,2,5,10,8};
        System.out.println(splitArray(a,2));

    }
    public static int splitArray(int[] nums, int k) {
        int n=nums.length;
        int maxValue=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<n;i++){
            sum=sum+nums[i];
            maxValue=Math.max(maxValue,nums[i]);
        }
        int l=maxValue;
        int h=sum;
        int ans=-1;
        while(l<=h){
            int m=(l+h)/2;
            if(checkSumPossible(nums,m,k,n)){
                ans=m;
                h=m-1;
            }else{
                l=m+1;
            }
        }
        return ans;
    }
    public static boolean checkSumPossible(int[] a,int val,int k,int n){
        int count=0;
        int sum=0;
        for(int i=0;i<n;i++){
            sum=sum+a[i];
            if(sum>val){
                count++;
                sum=a[i];
            }
        }
        if(sum>0){
            count++;
        }
        if(count<=k){
            return true;
        }
        return false;
    }
}
