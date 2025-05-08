package com.org.prep.dp;

public class NDigitNumber {
    public static void main(String[] args) {

        System.out.println(solve(4,5));
    }

//    public static int dp[][] = new int[1001][10001];
//    public static int rec(int id, int sum) {
//        if (sum < 0)
//            return 0;
//        if (id == 0 && sum == 0)
//            return 1;
//        if (id == 0)
//            return 0;
//        if (dp[id][sum] != -1)
//            return dp[id][sum];
//        int ans = 0;
//        for (int i = 0; i < 10; i++) {
//            ans += rec(id - 1, sum - i);
//            ans %= 1000000007;
//        }
//        return dp[id][sum] = ans;
//    }
//    public static int solve(int A, int B) {
//        int ans = 0;
//        for (int i = 0; i < A + 1; i++) {
//            for (int j = 0; j < B + 1; j++)
//                dp[i][j] = -1;
//        }
//        for (int i = 1; i < 10; i++) {
//            ans += rec(A - 1, B - i);
//            ans %= 1000000007;
//        }
//        return ans;
//    }

    static int rec(int A, int B,int[][] dp) {
        if (B < 0)
            return 0;
        if (A == 0 && B == 0)
            return 1;
        if (A == 0)
            return 0;
        if (dp[A][B] != -1)
            return dp[A][B];
        int ans = 0;
        for (int i = 0; i < 10; i++) {
            ans += rec(A - 1, B - i,dp);
            ans %= 1000000007;
        }
        return dp[A][B] = ans;
    }
    public static int solve(int A, int B) {
        int ans = 0;
        int dp[][] = new int[A+1][B+1];
        for (int i = 0; i <= A; i++) {
            for (int j = 0; j <= B; j++)
                dp[i][j] = -1;
        }
        for (int i = 1; i < 10; i++) {
            ans += rec(A - 1, B - i,dp);
            ans %= 1000000007;
        }
        return ans;
    }
}
