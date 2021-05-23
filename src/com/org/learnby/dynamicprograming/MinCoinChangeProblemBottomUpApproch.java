package com.org.learnby.dynamicprograming;

public class MinCoinChangeProblemBottomUpApproch {
    public static void main(String args[]) {
        int n = 3;
        int dp[] = new int[n + 1];
        int[] coins = {2};
        System.out.println(minCoins(dp, n, coins));
        System.out.println(minCoinsSimplefy(n,coins));
        //System.out.println(minCoins2D(n, coins));

    }

    public static int minCoins(int[] dp, int n, int[] coins) {


        for (int k = 1; k <= n; k++) {
            dp[k] = Integer.MAX_VALUE;
            for (int i = 0; i < coins.length; i++) {
                if (k - coins[i] >= 0) {
                    int subAns = dp[k - coins[i]];
                    if(subAns!=Integer.MAX_VALUE) {
                        int ans = Math.min(dp[k], subAns + 1);
                        dp[k] = ans;
                    }
                }

            }
        }
        return dp[n]!=Integer.MAX_VALUE?dp[n]:-1;
    }
    public static int minCoinsSimplefy(int A, int[] coins) {
        int[] N = new int[A+1];
        N[0] =0;
        for( int i =1;i<=A;i++){
            N[i] = Integer.MAX_VALUE;
            for(int j=0;j<coins.length;j++){
                if(i-coins[j]>=0){
                    N[i] = Math.min(N[i],N[i-coins[j]]!=Integer.MAX_VALUE?N[i-coins[j]]+1:Integer.MAX_VALUE);
                }
            }
        }
        return N[A]!=Integer.MAX_VALUE ?N[A]:-1;

    }
    public static int minCoins2D(int n, int[] coins) {
        int[][] dp=new int[coins.length][n+1];
        for(int i=0;i<coins.length;i++){
            dp[i][0]=0;
        }

        for(int i=0;i<coins.length;i++){
            for(int j=1;j<=n;j++) {

            int includingCoin=Integer.MAX_VALUE;
            int excludingCoin=Integer.MAX_VALUE;

            if(coins[i]<=j){
                includingCoin=dp[i][j-coins[i]]+1;
            }
            if(i>0){
                excludingCoin=dp[i-1][j];
            }
            dp[i][j]=Math.min(includingCoin,excludingCoin);

        }


        }


        return dp[coins.length-1][n];


    }
}
