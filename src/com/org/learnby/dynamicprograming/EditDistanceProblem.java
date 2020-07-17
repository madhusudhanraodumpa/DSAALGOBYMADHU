package com.org.learnby.dynamicprograming;

public class EditDistanceProblem {
    public static void main(String args[]){
System.out.println(minDistance("intention","execution"));
    }

    public static int minDistance(String word1, String word2) {
        if(word1==word2) return 0;
    return editOperartions(word1,word2,word1.length(),word2.length());
    }

    private static int editOperartionsOpt(String word1, String word2, int n, int m){
        if(n==0) return m;
        if(m==0) return n;
        if(word1==word2) return 0;

        int[][] dp=new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            dp[i][0]=i;
        }
        for(int j=0;j<=m;j++){
            dp[0][j]=j;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    dp[i][j]= 1+Math.min(Math.min(dp[i-1][j-1],dp[i][j-1]),dp[i-1][j]);
                }
            }
        }
        return dp[n][m];
    }

    private static int editOperartions(String word1, String word2, int n, int m) {

        if(n==0) return m;
        if(m==0) return n;
        if(word1.charAt(n-1)==word2.charAt(m-1)){
            return editOperartions(word1,word2,n-1,m-1);
        }
        return 1+Math.min(Math.min(editOperartions(word1,word2,n,m-1),editOperartions(word1,word2,n-1,m)),editOperartions(word1,word2,n-1,m-1));
    }
}
