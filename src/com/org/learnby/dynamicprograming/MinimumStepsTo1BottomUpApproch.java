package com.org.learnby.dynamicprograming;

public class MinimumStepsTo1BottomUpApproch {
    public static void main(String args[]){
        System.out.println(minStepsTo1(5));
    }
    public static int minStepsTo1(int n){
        int dp[]=new int[n+1];
        dp[1]=0;

        for(int i=2;i<=n;i++){
            int opt1=Integer.MAX_VALUE;
            int opt2=Integer.MAX_VALUE;
            int opt3=Integer.MAX_VALUE;
            if(i%3==0){
                opt1=dp[i/3];
            }
            if(i%2==0){
                opt2=dp[i/2];
            }
            opt3=dp[i-1];
            int ans=Math.min(Math.min(opt1,opt2),opt3)+1;
            dp[i]=ans;
        }
        return dp[n];
    }
}
