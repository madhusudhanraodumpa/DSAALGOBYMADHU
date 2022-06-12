package com.org.prep.array;

public class JumpsGameII {
    public static void main(String[] args){
        int a[]={2,3,1,1,4};
        jump(a);
    }

    public static int jump(int[] nums) {



        int n=nums.length;
        int maxReachable=0;
        int jumps=0;
        int current=0;
        for(int i=0;i<n-1;i++){

            maxReachable=Math.max(maxReachable,nums[i]+i);

            if(i==current){
                current=maxReachable;
                jumps++;

            }




        }
        return jumps;
    }
}
