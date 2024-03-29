package com.org.learnby.dynamicprograming;

public class UniqueBSTs {
public static void main(String args[]){
    System.out.println(numTrees(3));
}

    public static int numTrees(int n) {
        if(n==0 || n==1) return 1;
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<n;i++){

            for(int j=0;j<i;j++){

                dp[i] = dp[i]+dp[j]*dp[i-j-1];

            }
        }

        return dp[n];

    }
}
