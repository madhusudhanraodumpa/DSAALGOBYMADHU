package com.org.prep.binarysearch;

import java.util.Arrays;

public class SpecialInteger {
    public static void main(String[] args) {
        int a[]={1,1000000000};
        System.out.println(solve(a,1000000000));

    }

    public static int solve(int[] A, int B) {
        int n=A.length;
        int l=1;
        int h=n;
        int ans=0;
        while(l<=h){
            int m=(l+h)/2;
            if(maxSubArraySum(A,m,B)){
                h=m-1;

            }else{
                ans=m;
                l=m+1;
            }


        }
        return ans;
    }
    public static boolean maxSubArraySum(int[] A,int k,int B){
        long sum=0;
        int start=0;
        int end=0;

        while(end<k){
            sum=sum+A[end++];
        }
        long maxSum=sum;
        while(end<A.length){
            sum=sum-A[start++];
            sum=sum+A[end++];
            maxSum=Math.max(maxSum,sum);
        }


        return maxSum>B;
    }
}
