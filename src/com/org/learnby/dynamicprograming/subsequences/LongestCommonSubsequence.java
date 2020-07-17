package com.org.learnby.dynamicprograming.subsequences;

public class LongestCommonSubsequence {
    public static void main(String args[]){

    }
    //https://www.youtube.com/watch?v=PyGSxBbzG0Q&list=PLt4nG7RVVk1jcoLFb1gn0EylZ381IgrNq&index=6
    public static  int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        if(n==0 || m==0) return 0;
        int[][] dp=new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(text1.charAt(i)==text2.charAt(j)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return dp[n][m];
    }
}
