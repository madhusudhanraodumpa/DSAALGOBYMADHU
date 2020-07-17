package com.org.learnby.dynamicprograming;

public class LongestCommonSubSequence {
    public static void main(String args[]) {
        String s1 = "abde";
        String s2 = "acbef";
        Integer[][] dp = new Integer[s1.length() + 1][s2.length() + 1];
        System.out.println(LCS(s1, s2, s1.length(), s2.length()));
        System.out.println(LCSTopDownApproch(s1, s2, s1.length(), s2.length(), dp));
        System.out.println(LCSBottomUpApproch(s1, s2, s1.length(), s2.length()));


    }

    public static int LCS(String s1, String s2, int l1, int l2) {
        if (l1 == 0 || l2 == 0) return 0;

        if (s1.charAt(l1 - 1) == s2.charAt(l2 - 1)) {
            return 1 + LCS(s1, s2, l1 - 1, l2 - 1);
        }
        return Math.max(LCS(s1, s2, l1 - 1, l2), LCS(s1, s2, l1, l2 - 1));
    }

    public static int LCSTopDownApproch(String s1, String s2, int l1, int l2, Integer[][] dp) {
        if (l1 == 0 || l2 == 0) return 0;
        if (dp[l1][l2] == null) {
            if (s1.charAt(l1 - 1) == s2.charAt(l2 - 1)) {
                dp[l1][l2] = 1 + LCSTopDownApproch(s1, s2, l1 - 1, l2 - 1,dp);
            }else {
                dp[l1][l2] = Math.max(LCSTopDownApproch(s1, s2, l1 - 1, l2, dp), LCSTopDownApproch(s1, s2, l1, l2 - 1, dp));
            } }
        return dp[l1][l2];
    }

    public static int LCSBottomUpApproch(String s1, String s2, int l1, int l2) {
        int[][] dp = new int[l1 + 1][l2 + 1];

        /*for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }*/
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[l1][l2];
    }
}
