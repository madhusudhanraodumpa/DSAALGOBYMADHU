package com.org.prep.dp;

public class MaxSumValue {
    public static void main(String[] args){
        MaxSumValue m=new MaxSumValue();
        int[] a={1, 5, -3, 4, -2};
        m.maxValue(a,2,1,-1);
    }

    public int maxValue(int A[],int B,int C,int D){
        int n = A.length;
        int[][] dp = new int[n + 1][3]; // dp array to store answer of previous states

        for (int i = 0; i <= n; i += 1) {
            dp[i][0] = dp[i][1] = dp[i][2] = -1000000000; // Initialize the dp array with minus infinity
        }

        for (int i = 1; i <= n; i += 1) {
            dp[i][0] = Math.max(dp[i - 1][0], A[i - 1] * B); // Maximum value of A[i]*B
            dp[i][1] = Math.max(dp[i - 1][1], dp[i][0] + A[i - 1] * C); // Maximum value of A[i]*B + A[j]*C
            dp[i][2] = Math.max(dp[i - 1][2], dp[i][1] + A[i - 1] * D); // Maximum value of A[i]*B + A[j]*C + A[k]*D
        }

        return dp[n][2]; // return the answer.


    }
}
