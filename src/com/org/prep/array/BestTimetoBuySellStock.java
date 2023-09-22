package com.org.prep.array;

public class BestTimetoBuySellStock {
    public static void main(String[] args) {
        int[] a={7,1,5,3,6,4};
        System.out.println(maxProfit(a));
    }

    public static int maxProfit(int[] prices) {
        int n=prices.length;
        int buyPrice=Integer.MAX_VALUE;
        int maxProfit=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){

            if(buyPrice>prices[i]){
                buyPrice=prices[i];
            }else{
                int sellPrice=prices[i];
                int profit=sellPrice-buyPrice;
                if(maxProfit<profit){
                    maxProfit=profit;
                }

            }

        }
        return maxProfit!=Integer.MIN_VALUE?maxProfit:0;
    }
}
