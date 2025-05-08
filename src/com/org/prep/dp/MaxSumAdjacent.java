package com.org.prep.dp;

public class MaxSumAdjacent {
    public static void main(String[] args) {
        int[][] a= {{16,5,54,55,36,82,61,77,66,61},{31,30,36,70,9,37,1,11,68,14}};
        System.out.println(adjacent(a));
    }
    public static int adjacent(int[][] A) {
        int n;
        int dp[];
        int[] first, second;
        first = A[0];
        second = A[1];

        n = A[0].length;

        if (n == 0)
            return 0;

        dp = new int[n];
        dp[0] = Math.max(first[0], second[0]);

        if (n < 2)
            return dp[0];

        dp[1] = Math.max(first[1], second[1]);
        dp[1] = Math.max(dp[0], dp[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(first[i], second[i]);
            dp[i] += dp[i - 2];
            dp[i] = Math.max(dp[i], dp[i - 1]);
        }

        return dp[n - 1];

    }
}
