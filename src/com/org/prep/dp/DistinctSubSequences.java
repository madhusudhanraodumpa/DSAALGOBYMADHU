package com.org.prep.dp;

import java.util.Arrays;

public class DistinctSubSequences {
    public static void main(String[] args) {
        System.out.println(numDistinc1t("abc","abc"));

    }


    public static int numDistinc1t(String A, String B) {
        int n=A.length();
        int m=B.length();
        int dp[][]=new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return numDistinct(A,B,n,m,dp);
    }

    public static int numDistinct(String A, String B,int i,int j,int[][] dp){


        if(j<=0) return 1;
        if(i<=0) return 0;

        int ans=0;
        if(dp[i-1][j-1]!=-1) return dp[i-1][j-1];
        if(A.charAt(i-1)!=B.charAt(j-1)){
            ans=numDistinct(A,B,i-1,j,dp);
        }else {
            ans=numDistinct(A,B,i-1,j-1,dp)+numDistinct(A,B,i-1,j,dp);
        }

        dp[i-1][j-1]=ans;

        return dp[i-1][j-1];
    }

    public  static int numDistinct(String A, String B) {
        int n=A.length();
        int m=B.length();
        return numDistinct(A,B,n,m);
    }

    public static int numDistinct(String A, String B,int i,int j){


                if(j<=0) return 1;
        if(i<=0) return 0;
        int ans=0;
        if(A.charAt(i-1)!=B.charAt(j-1)){
            ans=ans+numDistinct(A,B,i-1,j);
        }else {
            ans=ans+numDistinct(A,B,i-1,j-1)+numDistinct(A,B,i-1,j);
        }



        return ans;
    }
}
