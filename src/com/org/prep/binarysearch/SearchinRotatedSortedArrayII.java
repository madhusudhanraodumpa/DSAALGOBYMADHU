package com.org.prep.binarysearch;

public class SearchinRotatedSortedArrayII {
    public static void main(String args[]){
        int[] a={1,2,2,2,0};
        System.out.println(search(a,0));
    }
    public static boolean search(int[] nums, int target) {
        int n=nums.length;
        int k=pivotIndex(nums,n);
        boolean val1=search(nums,target,0,k-1);
        if(val1){
            return true;
        }else{
            return search(nums,target,k,n-1);
        }
    }

    public static boolean search(int[] nums, int target,int l,int h) {

        while(l<=h){
            int m=(l+h)/2;

            if(nums[m]==target){
                return true;
            }else if(nums[m]>target){
                h=m-1;
            }else{
                l=m+1;
            }
        }

        return false;
    }

    public static int pivotIndex(int nums[],int n){

        int l=0;
        int h=n-1;
        if(n==2){
            if(nums[0]>nums[1]) return 1;
            else return 0;
        }
        int ans=0;
        while(l<=h){
            int m=(l+h)/2;

            if(nums[0]<nums[m]){
                if(nums[m]>nums[m+1] && nums[m]>nums[m-1]){
                    return m+1;
                }
                l=m+1;
            }else if(nums[0]>nums[m]){
                ans=m;
                h=m-1;
            }else if(nums[m]==nums[h]){
                h--;
            }else{
                l++;
            }

        }
        return ans;



    }
}
