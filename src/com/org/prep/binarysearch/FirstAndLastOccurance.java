package com.org.prep.binarysearch;

public class FirstAndLastOccurance {
    public static void main(String args[]){
        int a[]={5,7,7,8,8,10};

        searchRange(a,8);
    }

    public static int[] searchRange(int[] nums, int target) {
        int n=nums.length;
        int a[]=new int[2];
        a[0]=firstOccurance(nums,target,n);
        a[1]=lastOccurance(nums,target,n);
        return a;

    }

    public static int firstOccurance(int a[],int target,int n){
        int l=0;
        int h=n-1;
        int ans=-1;

        while(l<=h){
            int m=(l+h)/2;

            if(a[m]==target){
                h=m-1;
                ans=m;
            }else {
                if (a[m] > target) {
                    h = m - 1;
                } else {
                    l = m + 1;
                }
            }
        }
        return ans;

    }

    public static int lastOccurance(int a[],int target,int n){
        int l=0;
        int h=n-1;
        int ans=-1;

        while(l<=h){
            int m=(l+h)/2;

            if(a[m]==target){
                l=m+1;
                ans=m;
            }
            if(a[m]>target){
                h=m-1;
            }else{
                l=m+1;
            }

        }
        return ans;


    }
}
