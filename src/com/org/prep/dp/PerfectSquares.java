package com.org.prep.dp;

import java.util.Arrays;

public class PerfectSquares {
    public static void main(String[] args) {
       // System.out.println(countMinSquares(13));
        int A=13;
        int[] dp = new int[A+1];
        Arrays.fill(dp,-1);
        System.out.println(countMinSquares(A,dp));

    }
    public static int countMinSquares(int A) {
        int dp[]=new int[A];
        if(A==1) return A;
        dp[0]=0;

        for(int i=1;i<=A;i++) {
            int a=i;
            for(int k=1;k*k<=i;k++) {
                a=Math.min(a,dp[i-(k*k)]);
            }
            dp[i]=a+1;
        }
        return dp[A];
    }

    public static int countMinSquares(int A,int[] dp) {
        if(A==0) {
            dp[A]=0;
            return dp[A];
        }


        if(dp[A]==-1) {
            int ans = A;
            for(int k=1;k*k<=A;k++) {
                ans=Math.min(ans,countMinSquares(A-(k*k),dp));
            }
            dp[A]=ans+1;
        }



        return dp[A];
    }
}
