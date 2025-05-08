package com.org.prep.dp;

public class LongestPalndromicSubString {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));
    }

    public static String longestPalindrome(String s) {
        int n=s.length();
        int maxLen=Integer.MIN_VALUE;
        String ans="";
        int[][] dp=new int[n][n];

        for(int diff=0;diff<n;diff++){
            for(int i=0,j=i+diff;j<n;j++,i++){
                if (i == j) {
                    dp[i][j]=1;
                } else if(diff==1 && s.charAt(i)==s.charAt(j)) {
                    dp[i][j]=2;
                }


                else{
                    if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]>0){
                        dp[i][j]=dp[i+1][j-1]+2;
                    }


                }
                if(dp[i][j]>0){
                    if((j-i+1)>maxLen){
                        maxLen=(j-i+1);
                        ans=s.substring(i,j+1);
                    }
                }

            }
        }


        return ans;


    }

    public static String longestPalindrome1(String s) {
        int n=s.length();
        int maxLen=Integer.MIN_VALUE;
        String ans="";
        Boolean[][] dp=new Boolean[n][n];

        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(isPalindrom(s,i,j,dp)){
                    if(maxLen<(j-i+1)){
                        maxLen=j-i+1;
                        ans=s.substring(i,j+1);
                    }
                }
            }
        }
        return ans;

    }

    public static boolean isPalindrom(String s,int i,int j,Boolean[][] dp) {

        if(i>=j) return true;
        if(dp[i][j]!=null) return dp[i][j];
        if(s.charAt(i)==s.charAt(j)) {
            return dp[i][j]=isPalindrom(s,i++,j--,dp);
        }
        return dp[i][j]=false;

    }
}
