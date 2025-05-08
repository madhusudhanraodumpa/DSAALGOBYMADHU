package com.org.prep.dp;

import java.util.Arrays;

public class KnapSack {
    public static void main(String[] args) {

        int[] items={359,963,465,706,146,282,828,962,492};
        int[] wt= {96,43,28,37,92,5,3,54,93};
        int capacity=383;
        System.out.println(solveWithPrintingItem(items,wt,capacity));
    }

    public static int solveWithPrintingItem(int[] items,int[] wt,int capacity) {

        int k=capacity;
        int n=wt.length;
        int[][] dp=new int[n+1][k+1];
        for(int j=0;j<=k;j++) {
            dp[0][j]=0;
        }

        for(int i=1;i<=n;i++) {
            for(int j=0;j<=k;j++) {
                int dontPick = dp[i-1][j];
                int pick=0;
                if(j>=wt[i-1]) {
                    pick=dp[i-1][j-wt[i-1]]+items[i-1];
                }
                dp[i][j]=Math.max(pick,dontPick);


            }
        }

        int i=n;
        int j=k;
        while(i>0 && j>0) {
            if(dp[i-1][j]==dp[i][j]){
                i=i-1;
            }else{
                System.out.println(items[i-1]);
                i=i-1;
                j=j-wt[i];
            }
        }

        return dp[n][k];

        /**for(int i=0;i<=n;i++){
         Arrays.fill(dp[i],-1);
         }
         return kp(items,wt,n,k,dp);**/
    }

    public static int knapSack(int[] items,int[] wt,int capacity) {
        int k=capacity;
        int n=wt.length;
        int[][] dp=new int[n+1][k+1];
        for(int j=0;j<=k;j++) {
            dp[0][j]=0;
        }

        for(int i=1;i<=n;i++) {
            for(int j=0;j<=k;j++) {
                int dontPick = dp[i-1][j];
                int pick=0;
                if(j>=wt[i-1]) {
                    pick=dp[i-1][j-wt[i-1]]+items[i-1];
                }
                dp[i][j]=Math.max(pick,dontPick);


            }
        }

        return dp[n-1][k-1];

    }


    public static int solve(int[] items,int[] wt,int capacity) {

        int k=capacity;
        int n=wt.length;
        int[][] dp=new int[n+1][k+1];

        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }

        int a =  kp(items,wt,n,k,dp);
        System.out.println("");
        return  a;
    }
    public static  int kp(int[] items,int[] wt,int n,int k,int[][] dp) {

        if(n==0 || k==0) return 0;

        if(dp[n][k]==-1) {

            int dontPick = kp(items, wt, n - 1, k, dp);

            int pick=0;
            if (k >= wt[n - 1]) {
                pick = kp(items, wt, n - 1, k - wt[n - 1], dp) + items[n - 1];


            }
            dp[n][k] = Math.max(pick, dontPick);

        }
        return dp[n][k];



    }
}
