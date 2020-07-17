package com.org.learnby.dynamicprograming;

public class LongestCommonSubString {
    public static void main(String args[]) {
        String s1 = "abde";
        String s2 = "acbef";
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        System.out.println(LCS(s1, s2, s1.length(), s2.length(),0));
        //System.out.println(LCSTopDownApproch(s1, s2, s1.length(), s2.length(), dp));
        System.out.println(LCSBottomUpApproch(s1, s2, s1.length(), s2.length()));


    }

    public static int LCS(String s1, String s2, int l1, int l2,int count) {
        if (l1 == 0 || l2 == 0) return count;

        if (s1.charAt(l1 - 1) == s2.charAt(l2 - 1)) {
            count=  1 + LCS(s1, s2, l1 - 1, l2 - 1,count+1);
        }
        int count1=LCS(s1,s2,l1-1,l2,0);
        int count2= LCS(s1,s2,l1,l2-1,0);
       return Math.max(count,Math.max(count1,count2));
    }

    public static int LCSTopDownApproch(String s1, String s2, int l1, int l2, int[][] dp) {
        if (l1 == 0 || l2 == 0) return 0;
        if (dp[l1][l2] == 0) {
            if (s1.charAt(l1 - 1) == s2.charAt(l2 - 1)) {
                dp[l1][l2] = 1 + LCSTopDownApproch(s1, s2, l1 - 1, l2 - 1,dp);
            }
            dp[l1][l2] = LCSTopDownApproch(s1, s2, l1 - 1, l2,dp);
        }
        return dp[l1][l2];
    }

    public static int LCSBottomUpApproch(String s1, String s2, int l1, int l2) {
        int[][] dp = new int[l1 + 1][l2 + 1];
        int maxLength=Integer.MIN_VALUE;

        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    maxLength=Math.max(maxLength,dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return maxLength;
    }
}
