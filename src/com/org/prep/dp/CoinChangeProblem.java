package com.org.prep.dp;

public class CoinChangeProblem {
    public static void main(String[] args) {
        int A[]={1,2,5};
        int b=5;
        System.out.println(change(b,A));
    }
    public static int chang1e(int amount, int[] coins) {
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
        for(int j=1;j<=amount;j++){
            if(j%coins[0]==0){
                dp[0][j]=1;
            }else{
                dp[0][j]=0;
            }
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<=amount;j++){
                int notPick=dp[i-1][j];
                int pick=0;
                if(j>=coins[i]){
                    pick=dp[i][j-coins[i]];
                }
                dp[i][j]=pick+notPick;
            }
        }

        return dp[n-1][amount];

    }

    public static int change(int amount, int[] coins) {
        int n=coins.length;
        int k=amount;
        int mod=1000007;
        int[][] dp=new int[n][k+1];
        for(int j=0;j<=k;j++){
            if(j%coins[0]==0){
                dp[0][j]=1;
            }else {
                dp[0][j]=0;
            }
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<=k;j++){
                int dontPick=dp[i-1][j];
                int pick=0;
                if(j>=coins[i]){
                    pick=dp[i][j-coins[i]];
                }
                dp[i][j]=pick+dontPick;
            }
        }
        return dp[n-1][k];

    }
    public static int coinchange2(int[] A, int B) {
        int n=A.length;
        int k=B;
        int mod=1000007;
        int[][] dp=new int[n+1][k+1];
        for(int j=0;j<=k;j++){
          dp[0][j]=0;
        }
        for(int i=1;i<=n;i++){
            for(int j=0;j<=k;j++){
                int dontPick=dp[i-1][j];
                int pick=0;
                if(j>=A[i-1]){
                    if(j==A[i-1]){
                        pick=1;
                    }else {
                        pick = dp[i][j - A[i - 1]];
                    }
                }
                dp[i][j]=(pick%mod+dontPick%mod)%mod;
            }
        }
        return dp[n][k];


    }
}
