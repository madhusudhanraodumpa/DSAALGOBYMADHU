package com.org.prep.dp;
import java.util.*;

public class kanpsack0or1 {

    public static void main(String args[]){
        int[] A={60, 100, 120};
        int[] B={10, 20, 30};
        kanpsack0or1 k=new kanpsack0or1();
        k.solve(A,B,50);
    }
    public int solve(int[] A, int[] B, int C) {
        int n=A.length;

        int dp[][]=new int[n+1][C+1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        return kp(dp,n,n,A,B);


    }
    public int kp(int[][] dp,int i,int j,int[] A,int[] B){
        if(i==0 || j==0){
            return 0;
        }
        if(dp[i][j]==-1){
            int a=kp(dp,i-1,j,A,B);

            if(j>=B[i]){
                a=Math.max(a,kp(dp,i-1,j-B[i],A,B)+A[i]);
            }
            dp[i][j]=a;
        }
        return dp[i][j];

    }
}
