package com.org.prep.dp;

public class LetsParty {
    public static void main(String[] args) {
        System.out.println(solve(1));
    }
    public static int solve(int A) {

        int[] dp=new int[A+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=A;i++) {
            dp[i]=dp[i-1]+((i-1)*dp[i-2]);
        }
        return dp[A];


    }
}
