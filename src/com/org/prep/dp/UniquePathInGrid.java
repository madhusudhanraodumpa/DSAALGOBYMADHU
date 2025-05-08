package com.org.prep.dp;

public class UniquePathInGrid {


    public static void main(String[] args) {
        int[][] A={{0,0}};
        System.out.println(uniquePathsWithObstacles(A));

    }
    public static int uniquePathsWithObstacles(int[][] A) {
        int n=A.length;
        int m =A[0].length;
        int[][] dp =new int[n][m];

        for(int i=0;i<n;i++) {
            if(A[i][0]!=1){
                dp[i][0]=1;
            }else {
                break;
            }
        }
        for(int j=0;j<m;j++) {
            if(A[0][j]!=1){
                dp[0][j]=1;
            }else {
                break;
            }
        }
        for(int i=1;i<n;i++) {
            for(int j=1;j<m;j++) {
                if(A[i][j]!=1){
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }


            }
        }
        return dp[n-1][m-1];
    }
}
