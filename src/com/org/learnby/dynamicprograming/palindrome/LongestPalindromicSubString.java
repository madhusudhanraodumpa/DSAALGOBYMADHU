package com.org.learnby.dynamicprograming.palindrome;

public class LongestPalindromicSubString {
    public static void main(String args[]){
        System.out.println(longestPalindrome("abcda"));
    }
    public static int longestPalindromeLength(String s) {
        if(s==null || s.length()==0) return 0;
        int n=s.length();
        boolean dp[][]=new boolean[n][n];

        for(int i=0;i<n;i++){
            dp[i][i]=true;
        }
        int maxLen=Integer.MIN_VALUE;

        for(int i=n-2;i>=0;i--){
            for(int j=i+1;j<n;j++){
                if(s.charAt(i)==s.charAt(j)){
                    if(dp[i+1][j-1]){
                        dp[i][j]=true;
                        maxLen=Math.max(maxLen,j-i+1);
                    }
                }
            }
        }
        return maxLen;
    }

    public static String longestPalindrome(String s) {
        if(s==null || s.length()==0) return "";
        if(s.length()==1) return s;

        int n=s.length();
        boolean dp[][]=new boolean[n][n];
        String subString="";

        for(int i=0;i<n;i++){
            dp[i][i]=true;
        }
        int maxLen=Integer.MIN_VALUE;

        for(int i=n-2;i>=0;i--){
            for(int j=i+1;j<n;j++){
                if(s.charAt(i)==s.charAt(j)){
                    if(dp[i+1][j-1] || j-i==0){
                        dp[i][j]=true;
                        if(maxLen<j-i+1 ){
                            subString=s.substring(i,j+1);
                            maxLen=j-i+1;
                        }
                    }
                }
            }
        }
        return subString.length()==0?s.substring(0,1):subString;    }
}
