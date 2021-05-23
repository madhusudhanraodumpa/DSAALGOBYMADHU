package com.org.learnby.dynamicprograming;

public class TotalWaysCoinChangeProblem {
    public static void main(String args[]) {
        int n = 5;
        int dp[] = new int[n + 1];
        int[] coins = {1, 2, 3,4};
       // System.out.println(minCoins(dp, n, coins));
        System.out.println(totalWaysCoin(n, coins));
        System.out.println(numOfWays(n, coins));

    }

    public static int minCoins(int[] dp, int n, int[] coins) {


        for (int k = 1; k <= n; k++) {
            dp[k] = Integer.MAX_VALUE;
            for (int i = 0; i < coins.length; i++) {
                if (k - coins[i] >= 0) {
                    int subAns = dp[k - coins[i]];
                    int ans = Math.min(dp[k], subAns + 1);
                    dp[k] = ans;
                }

            }
        }
        return dp[n];


    }
    public static int numOfWays(int n, int[] coins){

        int[][] dp = new int[coins.length][n+1];
        for(int i =0 ;i<coins.length;i++){
            dp[i][0] = 1;
        }
        for(int i= 0;i<coins.length;i++){
            for(int j =1;j<n+1;j++){
                if(j<coins[i]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    if(i == 0){
                        dp[i][j] = dp[i][j-coins[i]];
                    }else {
                        int excludeCoin = dp[i - 1][j];
                        int includeCoin = dp[i][j - coins[i]];
                        dp[i][j] = includeCoin + excludeCoin;
                    }
                }
            }
        }
        return dp[coins.length-1][n];

    }

    public static int totalWaysCoin(int n, int[] coins) {
      int[][] dp=new int[coins.length][n+1];

      for(int i=0;i<coins.length;i++){
          dp[i][0]=1;
      }

      for(int i=1;i<=n;i++){
          for(int j=0;j<coins.length;j++){
              int includingCoin=0;
              int excludingCoin=0;

              if(i>=coins[j]){
                  includingCoin=dp[j][i-coins[j]];
              }
              if(j>0){
                  excludingCoin=dp[j-1][i];
              }
              dp[j][i]=includingCoin+excludingCoin;

          }
      }


        return dp[coins.length-1][n];


    }

}
