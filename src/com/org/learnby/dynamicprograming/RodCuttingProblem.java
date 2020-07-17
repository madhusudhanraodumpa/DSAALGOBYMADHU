package com.org.learnby.dynamicprograming;

public class RodCuttingProblem {
    public static void main(String args[]){
        int price[]={1,5,8,10};
        int sizes[]={1,2,3,5};
        int rodLen=10;
        System.out.println(maxProfit(price,sizes,rodLen));

    }
    public static int maxProfit(int[] prices,int[] sizes,int rodLen) {
        int[][] dp = new int[sizes.length][rodLen+1];
        for (int i = 0; i < sizes.length; i++) {
            for (int j = 1; j < rodLen+1; j++) {
                int includingProfit = 0;
                int excludinfProfit = 0;
                if (sizes[i] <= j) {
                    includingProfit = prices[i] + dp[i][j - sizes[i]];
                }
                if (i > 0) {
                    excludinfProfit = dp[i - 1][j];
                }
                dp[i][j] = Math.max(includingProfit, excludinfProfit);
            }
        }
        return dp[sizes.length - 1][rodLen];
    }

}
