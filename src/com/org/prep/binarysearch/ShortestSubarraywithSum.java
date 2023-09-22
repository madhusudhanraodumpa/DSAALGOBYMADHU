package com.org.prep.binarysearch;

public class ShortestSubarraywithSum {
    public static void main(String args[]){
        int a[]={44,-25,75,-50,-38,-42,-32,-6,-40,-47
        };
        System.out.println(shortestSubarray(a,19));
    }

    public static int shortestSubarray(int[] nums, int k) {
        int n=nums.length;
        int l=1;
        int h=n;
        int ans=-1;
        if(n==1) return nums[0];
        while(l<=h){
            int m=(l+h)/2;

            long sum=maxSumSubArray(nums,m,n);
            if(Math.abs(sum)>=k){
                h=m-1;
                ans=m;

            }else{
                l=m+1;
            }
        }
        return ans;
    }

    public static long maxSumSubArray(int a[],int k,int n){
        long sum=0;

        int start=0;
        int end=0;
        while(end<k){
            sum=sum+a[end++];
        }
        long ans=sum;
        while(end<n){
            sum=sum-a[start++];
            sum=sum+a[end++];
            ans=Math.max(sum,ans);

        }
        return ans;


    }
}
