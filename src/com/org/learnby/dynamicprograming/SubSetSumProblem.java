package com.org.learnby.dynamicprograming;

public class SubSetSumProblem {
    public static void main(String args[]) {
        int[] a = {1, 2, 3, 5};
        int sum = 7;
        System.out.println(isSubSetSum(a, sum));

    }

    public static boolean isSubSetSum(int a[], int sum) {
        boolean[][] dp = new boolean[a.length][sum + 1];
        for (int i = 0; i < a.length; i++) {
            dp[i][0] = true;
        }
        for (int j = 0; j <= sum; j++) {
            if (j == a[0])
                dp[0][j] = true;
        }

        for (int i = 1; i < a.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (dp[i - 1][j]) {
                    dp[i][j] = true;
                } else {
                    if (j >= a[i]) {
                        dp[i][j] = dp[i - 1][j - a[i]];
                    }
                }

            }
        }
        return dp[a.length - 1][sum];

    }
}
