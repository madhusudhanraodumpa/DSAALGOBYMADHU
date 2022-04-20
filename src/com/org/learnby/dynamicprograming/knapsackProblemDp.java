package com.org.learnby.dynamicprograming;

public class knapsackProblemDp {
    public static void main(String args[]){
        int[] prices={1,4,7,10};
        int[] wt={1,2,3,5};
        System.out.println(maxProfit(prices,wt,8));
        System.out.println(maxProfit1(prices,wt,8));

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
    public static int maxProfit1(int[] items,int[] wt,int capacity){
        if(items.length==0 || wt.length==0) return 0;

        int[][] dp=new int[items.length+1][capacity+1];

        for(int n=0;n<items.length+1;n++){
            for(int w=0;w<capacity+1;w++){
                if(n==0 || w==0){
                    dp[n][w]=0;
                }

                else if(wt[n-1]<=w){
                   int includeItem=items[n-1]+dp[n-1][w-wt[n-1]];
                   int exculdeItem=dp[n-1][w];
                   dp[n][w]=Math.max(includeItem,exculdeItem);
                }else{
                    dp[n][w]=dp[n-1][w];
                }


            }
        }
       return dp[items.length][capacity];
    }
}
