package com.org.prep.array;

public class MajorityElement {
    public static void main(String[] args){
        int[] a={2,2,1,1,1,2,2};
        majorityElement(a);
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
}
