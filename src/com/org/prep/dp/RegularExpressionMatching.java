package com.org.prep.dp;

import java.util.Arrays;

public class RegularExpressionMatching {
    public static void main(String args[]){
        RegularExpressionMatching r=new RegularExpressionMatching();
        r.isMatch("aa","a*");
    }
    public boolean isMatch(String s, String p) {
        int n=s.length();
        int m=p.length();
        int[][] dp=new int[n][m];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));


        return isMatch(s,p,dp,n-1,m-1)==1?true:false;

    }

    public int isMatch(String s,String p,int[][] dp,int i,int j){

        if(i==-1 && j==-1) return 1;
        if(j==-1) return 0;
        if(i==-1){

            for(int k=0;k<=j;k++){
                if(p.charAt(k)!='*'){
                    return 0;
                }
            }
            return 1;
        }






        if(dp[i][j]==-1) {

            if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='.'){
                dp[i][j] = isMatch(s,p,dp,i-1,j-1);
            }
            else if(p.charAt(j)=='*'){
                int x=isMatch(s,p,dp,i-1,j);
                int y=isMatch(s,p,dp,i,j-1);
                if(x==1 || y==1){
                    dp[i][j]=1;
                }else{
                    dp[i][j]=0;
                }


            }else{
                dp[i][j]=0;
            }

        }

        return dp[i][j];









    }
}
