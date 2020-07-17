package com.org.learnby.dynamicprograming.palindrome;

import java.util.Arrays;

public class MinimumInsertionStepstoMakeaStringPalindrome {
    public static void main(String args[]) {

        System.out.println(minInsertions("ghiabcdefhelloadamhelloabcdefghi"));
    }


    public static int minInsertions(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                dp[i][j] = -1;
            }
        }
        return minInsertionsRec(s, 0, s.length() - 1, dp);
    }

    public static int minInsertionsRec(String s, int i, int j, int dp[][]) {
        if (i >= j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];

        if (s.charAt(i) == s.charAt(j)) {
            dp[i][j] = minInsertionsRec(s, i + 1, j - 1, dp);
            return dp[i][j];
        } else {
            dp[i][j] = 1 + Math.min(minInsertionsRec(s, i + 1, j, dp), minInsertionsRec(s, i, j - 1, dp));
            return dp[i][j];
        }

    }

    public static int minInsertionsDP(String s, int n) {
        int[][] dp = new int[s.length()][s.length()];
        int i;
        int j;
      for(int len=1;len<n;len++){
          for(i=0,j=0 ;j<n;i++,j++){
              dp[i][j]= (s.charAt(i)==s.charAt(j))?dp[i+1][j-1]:1+Math.min(dp[i+1][j],dp[i][j-1]);
          }
      }
        return dp[0][n-1];
    }
}
