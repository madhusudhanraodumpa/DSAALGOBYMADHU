package com.org.learnby.dynamicprograming;

public class LongestPalindromeSubString {
    public static void main(String args[]) {
        String s = "abdba";
        System.out.println(longestPalindromeSubString(s));
        Integer[][] dp = new Integer[s.length()][s.length()];
        System.out.println(longestPalindromeSubStringTopDown(s, 0, s.length() - 1, dp));
        System.out.println(longestPalindromeSubStringBottomUp(s, s.length()));

    }


    public static int longestPalindromeSubStringBottomUp(String s, int n) {
        boolean dp[][] = new boolean[n][n];
        int maxLps=1;
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if(dp[i+1][j-1] || j-i==1) {
                        dp[i][j] = true;
                        maxLps=Math.max(maxLps,j-i+1);
                    }
                }
            }
        }
        return maxLps;

    }


    public static int longestPalindromeSubStringTopDown(String s, int start, int end, Integer dp[][]) {

        if (start > end) return 0;
        if (start == end) return 1;
        if (dp[start][end] == null) {
            if (s.charAt(start) == s.charAt(end)) {
                int remainingLength = end - start - 1;
                if (remainingLength == longestPalindromeSubStringTopDown(s, start + 1, end - 1, dp)) {
                    dp[start][end] = 2 + remainingLength;
                }
            }else {
                dp[start][end] = Math.max(longestPalindromeSubStringTopDown(s, start + 1, end, dp), longestPalindromeSubStringTopDown(s, start, end - 1, dp));
            }
        }
        return dp[start][end];
    }


    public static int longestPalindromeSubString(String s) {
        return longestPalindromeSubStringRec(s, 0, s.length() - 1);
    }

    public static int longestPalindromeSubStringRec(String s, int start, int end) {

        if (start > end) return 0;
        if (start == end) return 1;
        if (s.charAt(start) == s.charAt(end)) {
            int remainingLength = end - start - 1;
            if (remainingLength == longestPalindromeSubStringRec(s, start + 1, end - 1)) {
                return 2+remainingLength;
            }
        }
        return Math.max(longestPalindromeSubStringRec(s, start + 1, end), longestPalindromeSubStringRec(s, start, end - 1));

    }
}
