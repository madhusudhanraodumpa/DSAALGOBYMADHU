package com.org.learnby.dynamicprograming;

public class MinCoinChangeProblemTopDownApproch {
   public static void main(String args[]){
      int n=5;
      int dp[]=new int[n+1];
      int[] coins={1,7,10};
      System.out.println(minCoins(dp,n,coins));

   }
   public static int minCoins(int[] dp,int n,int[] coins){

         if(n==0) return 0;
         if(dp[n]!=0) return dp[n];
      int ans=Integer.MAX_VALUE;

      for (int i=0;i<coins.length;i++){

         if(n-coins[i]>=0){
            int subAns=minCoins(dp,n-coins[i],coins);
            ans=Math.min(ans,subAns+1);
            dp[n]=ans;
         }

      }
      return dp[n];


   }

}
