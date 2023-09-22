package com.org.prep.dp;

import java.util.Arrays;

public class FrogJump {
    public static void main(String args[]){
        FrogJump f=new FrogJump();
        f.frogJump();
    }
    //top_down and memorization
    public void frogJump(){
        int[] a={30,10,60,10,60,50};
        int index=5;
        int dp[]=new int[a.length];
        Arrays.fill(dp,-1);
        System.out.println(minCost(a,5,dp));
        System.out.println(frogJumpCost(a));
    }
    public int minCost(int[] a,int index,int[] dp){
        if(index==0) return 0;

        if(dp[index]==-1) {
            int left = 0;
            int right = 0;

            left = minCost(a, index - 1,dp) + Math.abs(a[index] - a[index - 1]);
            if (index > 1)
            right = minCost(a, index - 2,dp) + Math.abs(a[index] - a[index - 2]);

            dp[index]= Math.min(left, right);
        }

        return dp[index];

    }

    //bottom_up+taulization approch
    public int frogJumpCost(int[] a){
        int n=a.length;
        int[] dp=new int[n];
        dp[0]=0;
        dp[1]=Math.abs(a[0]-a[1]);
        for(int i=2;i<n;i++){

            int left=dp[i-1]+Math.abs(a[i]-a[i-1]);
            int right=dp[i-2]+Math.abs(a[i]-a[i-2]);
            dp[i]=Math.min(left,right);

        }
        return dp[n-1];
    }
}
