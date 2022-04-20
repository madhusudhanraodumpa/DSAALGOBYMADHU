package com.org.learnby.dynamicprograming.subsequences;

public class CountPalindromicSubsequences {

    public static void main(String args[]){
        System.out.println(countPalindromicSubsequences("bccb"));
    }



    public static int countPalindromicSubsequences(String s) {

        int n=s.length();
        int dp[][]=new int[n][n];
        for(int gap=0;gap<n;gap++){
            for(int i=0,j=gap;j<n;i++,j++)

                if(gap==0){
                    dp[i][j]=1;
                }else if(gap==1){
                    if(s.charAt(i)==s.charAt(j)){
                        dp[i][j]=3;
                    }else{
                        dp[i][j]=2;
                    }
                }else{
                    if(s.charAt(i)==s.charAt(j)){
                        dp[i][j]=dp[i][j-1]+dp[i+1][j]+1;
                    }else{
                        dp[i][j]=dp[i][j-1]+dp[i+1][j]-dp[i+1][j-1];
                    }



                }


        }

        return dp[0][n-1];
    }
}
