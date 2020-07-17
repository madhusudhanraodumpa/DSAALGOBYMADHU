package com.org.learnby.dynamicprograming.palindrome;

public class LongestPalnidromicSubSeq {
    public static void main(String args[]){
        System.out.println(longestPalindromeSubseq("bbbab"));
    }
    public static int longestPalindromeSubseq(String s) {

        int n=s.length();
        if(n==0) return 0;
        int dp[][]=new int[n][n];

        for(int i=n-1;i>=0;i--){
            dp[i][i]=1;
            for(int j=i+1;j<n;j++){
                if(s.charAt(i)==s.charAt(j)){
                    dp[i][j]= 2+dp[i+1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        return dp[0][n-1];
    }
}
