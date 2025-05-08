package com.org.prep.dp;

public class CoinChange {
    public static void main(String[] args) {
        int[] a={1,2,5};
        System.out.println(coinChange(a,11));
    }
//    public static int coinChange(int[] coins, int amount) {
//        int n=coins.length;
//        return coinChange(coins,amount);
//    }

    public static int coinChange(int[] coins, int amount) {
        if(amount==0) return 0;
        int n=coins.length;
        int[] dp=new int[amount+1];
        dp[0]=0;
        for(int i=1;i<=n;i++){
            int ans=(int)Math.pow(10,9);
            for(int coin:coins){
                if(i>=coin){
                    ans=Math.min(ans,dp[i-coin]+1);
                }
            }
            dp[i]=ans;
        }
        return dp[amount]==(int)Math.pow(10,9)?-1:dp[amount];
    }

    public static int coinChange1(int[] coins, int amount) {
        int n=coins.length;
        int[][] dp=new int[n+1][amount+1];
        for(int j=1;j<=amount;j++){
            if(j%coins[0]==0){
                dp[1][j]=j/coins[0];
            }else{
                dp[1][j]=(int)Math.pow(10,9);
            }
        }
        for(int i=2;i<=n;i++){
            for(int j=1;j<=amount;j++){
                int notPick=dp[i-1][j];
                int pick=(int)Math.pow(10,9);
                if(j>=coins[i-1]){
                    pick=dp[i][j-coins[i-1]]+1;
                }
                dp[i][j]=Math.min(pick,notPick);
            }
        }

        return dp[n][amount]==(int)Math.pow(10,9)?-1:dp[n][amount];



    }
//    public static int coinChange1(int[] coins, int amount,int n){
//        if(amount<0) return 0;
//        if(n==0){
//            if(coins[0]==amount) return 1;
//            else return 0;
//        }
//
//        int dontPick=coinChange(coins,amount,n-1);
//        int pick=Integer.MAX_VALUE;
//        if(amount-coins[n]>=0){
//            pick = coinChange(coins,amount-coins[n],n-1)+1;
//        }
//        return pick+dontPick;
//    }
}
