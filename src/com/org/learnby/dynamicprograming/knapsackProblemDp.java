package com.org.learnby.dynamicprograming;

public class knapsackProblemDp {
    public static void main(String args[]){
        int[] prices={1,4,7,10};
        int[] wt={1,2,3,5};
        System.out.println(maxProfit(prices,wt,8));
    }
    public static int maxProfit(int[] prices,int[] wt,int capacity){
        if(prices.length==0 || wt.length==0 || capacity<=0) return 0;
        int dp[][]=new int[wt.length][capacity+1];
        for(int j=0;j<=capacity;j++){
            if(wt[0]<=j)
            dp[0][j]=prices[0];
        }

        for(int i=1;i<wt.length;i++){
            for(int j=1;j<=capacity;j++){

                int includingProfit=0;
                int excludingProfit=0;

                if(wt[i]<=j){
                    includingProfit=prices[i]+dp[i-1][j-wt[i]];
                }
                excludingProfit=dp[i-1][j];
                dp[i][j]=Math.max(includingProfit,excludingProfit);
            }
        }


        return dp[wt.length-1][capacity];
    }
}
