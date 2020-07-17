package com.org.learnby.array;

public class ShuffleArray {

    public static void main(String rags[]){
        int a[]={2,5,1,3,4,7};
        shuffle(a,3);
    }

    public static int[] shuffle(int[] nums, int n) {
        int a[]=new int[nums.length];
           int counter=0;
        for(int i=0;i<nums.length/2;i++){
            a[counter]=nums[i];
            a[counter+1]=nums[i+n];
            counter=counter+2;

        }
        return a;
    }
    public static int[] shuffle1(int[] nums, int n) {
        int[] a = new int[nums.length];
        for(int i=0;i<nums.length/2;i++){
            a[2*i]=nums[i];
            a[2*1+1]=nums[i+n];


        }
        return a;
    }
}
