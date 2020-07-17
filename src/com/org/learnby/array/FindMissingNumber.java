package com.org.learnby.array;

public class FindMissingNumber {

    public static void main(String args[]){
        int a[]={3,0,1};
        System.out.println(missingNumber1(a));
    }
    public static int missingNumber(int[] nums) {
        int missing= nums.length;
        for(int i=0;i<nums.length;i++){
            missing^=i^nums[i];
        }
        return missing;
    }

    // this algo will work for only array values from 1 to n. if less than 1 it wont work.
    public static int missingNumber1(int[] arr) {

        if(arr.length == 0) {
            return -1;
        }
        int i = 0;
        while(i < arr.length) {
            if(arr[i] <= arr.length && arr[i] != i + 1) {
                int otherIndex = arr[i] - 1;
                int x = arr[i];
                arr[i] = arr[otherIndex];
                arr[otherIndex] = x;
            } else {
                i++;
            }
        }
        for(i = 0; i < arr.length; i++) {
            if(arr[i] != i + 1) {
                return i + 1;
            }
        }
        return -1;
    }
}
