package com.org.learnby.dynamicprograming.palindrome;

public class PalindromicStrings {
    public static void main(String args[]){
        System.out.println(countSubstrings("aaa"));
    }

    public static int countSubstrings(String s) {
        if(s==null || s.length()==0) return 0;
        if(s.length()==1) return 1;
        int n=s.length();
        boolean dp[][]=new boolean[n][n];
        int count=0;
        for(int i=0;i<n;i++){
            dp[i][i]=true;
            count++;
        }
        for(int i=n-2;i>=0;i--){
            for(int j=i+1;j<n;j++){
                if(s.charAt(i)==s.charAt(j)){
                    if(dp[i+1][j-1] || j-i==1){
                        dp[i][j]=true;
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
