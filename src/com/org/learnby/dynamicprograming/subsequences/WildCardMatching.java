package com.org.learnby.dynamicprograming.subsequences;

public class WildCardMatching {
        public static void main(String args[]){
            isMatch("ab",",?");
        }




    public static boolean isMatch(String s, String p) {
        int m=p.length();
        int n=s.length();

        boolean dp[][]=new boolean[m+1][n+1];

        for(int i=m;i>=0;i--){
            for(int j=n;j>=0;j--){
                if(i==m && j==n){
                    dp[i][j]=true;
                }else if(i==m||j==n){
                    if(j==n && p.charAt(i)=='*'){
                        dp[i][j]=dp[i+1][j];
                    }else{
                        dp[i][j]=false;
                    }
                }else{
                    if(p.charAt(i)=='?'){
                        dp[i][j]= dp[i+1][j+1];
                    }else if (p.charAt(i)=='*'){
                        dp[i][j]= dp[i+1][j] || dp[i][j+1];

                    }else if(p.charAt(i)==s.charAt(j)){
                        dp[i][j]= dp[i+1][j+1];
                    }else{
                        dp[i][j]= false;
                    }
                }

            }
        }
        return dp[0][0];
    }







}
