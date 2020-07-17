package com.org.learnby.dynamicprograming;

import java.util.Arrays;

public class LongestPalindromeSubSequence {
    public static void main(String args[]){
        String s="abefbac";
        System.out.println(longestPalindromeSubseq(s));
        Integer[][] dp=new Integer[s.length()][s.length()];
        System.out.println(longestPalindromeSubseqTopDown(s,0,s.length()-1,dp));
        System.out.println(longestPalindromeSubseqBottomUp(s,s.length()));

    }


    public static int longestPalindromeSubseqBottomUp(String s,int n) {
        int dp[][]=new int[n][n];
        for(int i=0; i < n; i++){
            dp[i][i] = 1;
        }
        for(int i=n-2;i>=0;i--){
            for(int j=i+1;j<n;j++){
                if(s.charAt(i)==s.charAt(j)){
                    dp[i][j]=2+dp[i+1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        return dp[0][n-1];

    }


    public static int longestPalindromeSubseqTopDown(String s,int start,int end,Integer dp[][]) {

        if(start>end) return 0;
        if(start==end) return 1;
        if(dp[start][end]==null) {
            if (s.charAt(start) == s.charAt(end)) {
                dp[start][end] = 2 + longestPalindromeSubseqRec(s, start + 1, end - 1);
            } else {
                dp[start][end] = Math.max(longestPalindromeSubseqRec(s, start + 1, end), longestPalindromeSubseqRec(s, start, end - 1));
            }
        }
        return dp[start][end];
    }



    public static int longestPalindromeSubseq(String s) {
        return longestPalindromeSubseqRec(s,0,s.length()-1);
    }

    public static int longestPalindromeSubseqRec(String s,int start,int end) {

        if(start>end) return 0;
        if(start==end) return 1;
        if(s.charAt(start)==s.charAt(end)){
            return 2+longestPalindromeSubseqRec(s,start+1,end-1);
        }else{
            return Math.max(longestPalindromeSubseqRec(s,start+1,end),longestPalindromeSubseqRec(s,start,end-1));
        }
    }

}
