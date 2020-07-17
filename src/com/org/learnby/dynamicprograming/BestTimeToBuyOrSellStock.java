package com.org.learnby.dynamicprograming;

import java.util.Deque;
import java.util.LinkedList;

public class BestTimeToBuyOrSellStock {
    public static void main(String args[]){
        int a[]={1,3,7,5,10,3};
        System.out.println(maxProfitWithTrnsactionFeeOpt(a,3));
    }

    public static int maxProfitWithTrnsactionFee(int[] prices, int fee) {
        int minPrice=Integer.MAX_VALUE;
        int maxProfit=0;
        int totalProfit=0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<minPrice){
                minPrice=prices[i];
            }else if(prices[i]-minPrice>fee && maxProfit<prices[i]-minPrice){
                maxProfit=prices[i]-minPrice-2;
                totalProfit+=maxProfit;
                minPrice=prices[i];
                maxProfit=0;
            }

        }
        return totalProfit;
    }


    public static int maxProfitWithTrnsactionFeeOpt(int[] prices, int fee) {
        int cash = 0, hold = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            cash = Math.max(cash, hold + prices[i] - fee);
            hold = Math.max(hold, cash - prices[i]);
        }
        return cash;
    }
    public static int maxProfitClockDown(int[] prices) {
        int endWithSell = 0;
        int endWithBuy = Integer.MIN_VALUE;
        int prevBuy =0, prevSell = 0;
        for(int i =0;i<prices.length;i++){
            prevBuy = endWithBuy;
            endWithBuy = Math.max(endWithBuy,prevSell - prices[i]);
            prevSell = endWithSell;
            endWithSell = Math.max(endWithSell, prevBuy + prices[i]);
        }
        return endWithSell;
    }

    public static int maxProfit(int[] prices) {

        int minPrice=Integer.MAX_VALUE;
        int maxProfit=0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<minPrice){
                minPrice=prices[i];
            }else{
                maxProfit=Math.max(maxProfit,prices[i]-minPrice);
            }

        }
        return maxProfit;
    }
    public static int maxProfitII(int[] prices) {

        int minPrice=Integer.MAX_VALUE;
        int maxProfit=0;
        int totalProfit=0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<minPrice){
                minPrice=prices[i];
            }else if(maxProfit<prices[i]-minPrice){
                maxProfit=prices[i]-minPrice;
                totalProfit+=maxProfit;
                minPrice=prices[i];
                maxProfit=0;
            }

        }
        return totalProfit;
    }
//K transaction

    //https://www.youtube.com/watch?v=2FROyvnnrrM
    public static int maxProfitIV(int[] prices,int k) {
        int[][] dp=new int[k+1][prices.length];

        for(int i=0;i<prices.length;i++){
            dp[0][i]=0;
        }
        for(int j=0;j<=k;j++){
            dp[j][0]=0;
        }

        for(int i=1;i<=k;i++){
            for(int j=1;j<prices.length;j++){
                int maxProfit=dp[i][j-1];
                for(int m=0;m<=j-1;m++){
                    maxProfit=Math.max(maxProfit,prices[j]-prices[m]+dp[i-1][m]);
                }
                dp[i][j]=maxProfit;
            }
        }


      return dp[k][prices.length-1];
    }


    public static int maxProfitIVOpt(int[] prices,int k) {
        int[][] dp=new int[k+1][prices.length];

        for(int i=1;i<=k;i++){
            int maxDiff = dp[i-1][0]-prices[0];
            for(int j=1;j<prices.length;j++){
                int maxProfit=dp[i][j-1];
                maxProfit=Math.max(maxProfit,prices[j]+maxDiff);
                dp[i][j]=maxProfit;
                maxDiff=Math.max(maxDiff,dp[i-1][j]-prices[j]);
            }
        }


        return dp[k][prices.length-1];
    }
//https://www.youtube.com/watch?v=oDhu5uGq_ic&t=484s
    public void printActualSolution(int T[][], int prices[]) {
        int i = T.length - 1;
        int j = T[0].length - 1;

        Deque<Integer> stack = new LinkedList<>();
        while(true) {
            if(i == 0 || j == 0) {
                break;
            }
            if (T[i][j] == T[i][j-1]) {
                j = j - 1;
            } else {
                stack.addFirst(j);
                int maxDiff = T[i][j] - prices[j];
                for (int k = j-1; k >= 0; k--) {
                    if (T[i-1][k] - prices[k] == maxDiff) {
                        i = i - 1;
                        j = k;
                        stack.addFirst(j);
                        break;
                    }
                }
            }
        }

        while(!stack.isEmpty()) {
            System.out.println("Buy at price " + prices[stack.pollFirst()]);
            System.out.println("Sell at price " + prices[stack.pollFirst()]);
        }

    }
}
