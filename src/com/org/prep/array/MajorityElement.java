package com.org.prep.array;

public class MajorityElement {
    public static void main(String[] args){
        int[] a={3,3,4};
        majorityElement1(a);
    }


    public static int majorityElement(int[] nums) {
        int val=-1;
        int count=0;
        for(int i=0;i<nums.length;i++){

            if(count==0){
                val=nums[i];
                count++;
            }

            else if(val==nums[i]){
                count++;
            }else{
                count--;
            }


        }
        return val;

    }

    public static int majorityElement1(int[] nums) {

        int n= nums.length;
        int val=-1;
        int count=0;

        for(int i=0;i<n;i++) {
            if(count==0) {
                val=nums[i];
            }else if(val==nums[i]) {
                count++;
            }else {
                count--;
            }


        }
        return val;
    }
}
