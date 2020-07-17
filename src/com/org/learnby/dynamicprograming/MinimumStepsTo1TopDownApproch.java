package com.org.learnby.dynamicprograming;

public class MinimumStepsTo1TopDownApproch {
    public static void main(String args[]) {
        int n = 11;
        int dp[] = new int[n + 1];
        System.out.println(minStepsTo1(dp, n));
    }

    public static int minStepsTo1(int[] dp, int n) {
        if (n == 1) {
            return 0;
        }
        int opt1 = Integer.MAX_VALUE;
        int opt2 = Integer.MAX_VALUE;
        int opt3 = Integer.MAX_VALUE;
        if (dp[n] != 0) {
            return dp[n];
        }
        if (n % 3 == 0) {
            opt1 = minStepsTo1(dp, n / 3);
        }
        if (n % 2 == 0) {
            opt2 = minStepsTo1(dp, n / 2);
        }
        opt3 = minStepsTo1(dp, n - 1);
        int ans = Math.min(Math.min(opt1, opt2), opt3) + 1;
        dp[n] = ans;
        return dp[n];
    }
}
