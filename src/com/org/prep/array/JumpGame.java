package com.org.prep.array;

import java.util.Map;

public class JumpGame {

    public static void main(String args[]){
        int[] a={3,2,1,0,4};
        canJump(a);

    }

    public static boolean canJump(int[] nums) {

       /* int n=nums.length;
        int maxReachable=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){

            maxReachable=Math.max(maxReachable,nums[i]+i);
            if(maxReachable>=(n-1)) return true;
            if(i==maxReachable) return false;





        }
        return false;*/

        int n=nums.length;

        int current=nums[0];
        int maxReachable=nums[0];
        for(int i=1;i<n-1;i++){
            maxReachable=Math.max(maxReachable,i+nums[i]);

            if(current==i){
                if(maxReachable==0) return false;
                current=maxReachable;

            }


        }
        return true;

    }
}
