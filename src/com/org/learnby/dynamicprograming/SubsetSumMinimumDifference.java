package com.org.learnby.dynamicprograming;

public class SubsetSumMinimumDifference {
    public static void main(String args[]) {
        int[] a = {1, 2, 3, 5, 13};
        System.out.println(partitionMinDifference(a));
    }

    private static int partitionMinDifference(int[] a) {


        int sumArray = 0;
        for (int i = 0; i < a.length; i++) {
            sumArray += a[i];
        }
        int sum = sumArray / 2;
        int first_pt_sum= isSubSetSum(a, sum);
        int other_pt=sumArray-first_pt_sum;
        return Math.abs(other_pt-first_pt_sum);
    }

    private static int isSubSetSum(int a[], int sum) {
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
        if(dp[a.length - 1][sum]) return sum;
        for(int i=sum;i>=0;i--){
            if(dp[a.length - 1][i]) return i;
        }

        return -1;
    }
}
