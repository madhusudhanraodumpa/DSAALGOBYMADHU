package com.org.learnby.dynamicprograming;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BestTimeToBuyOrSellStock {
    public static void main(String args[]){
       // int a[]={1,3,7,5,10,3};
        int a[]={1,3};

        System.out.println(maxProfitIVOptNew(a,0));
    }

    public static int maxProfitWithTrnsactionFee(int[] prices, int fee) {
        if(prices == null || prices.length == 0)
            return 0;

        int hold = Integer.MIN_VALUE, sold = 0;

        for(int price : prices){
            hold = Math.max(hold, sold - price);
            sold = Math.max(sold, hold + price - fee);
        }

        return sold;
    }


    public static int maxProfitWithTrnsactionFeeOpt(int[] prices, int fee) {
        int cash = 0, hold = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            cash = Math.max(cash, hold + prices[i] - fee);
            hold = Math.max(hold, cash - prices[i]);
        }
        return cash;
    }


    //Using dp
    public static int maxProfitWithTrnsactionFeeOptNew(int[] prices, int fee) {
        int n = prices.length;
        if(prices.length<=1) return 0;

        int sold=0;
        int buy=-prices[0]-fee;
        for(int i=1;i<n;i++){
            sold=Math.max(sold,buy+prices[i]);
            buy=Math.max(buy,sold-prices[i]-fee);
        }
        return sold;
    }
//Using dp
    public static int maxProfitWithTrnsactionFeeOptDP(int[] prices, int fee) {
        int n = prices.length;
        if(prices.length<=1) return 0;

        int[][] dp=new int[n][2];

        dp[0][0]=0;
        dp[0][1]=-prices[0]-fee;


        for(int i=1;i<n;i++){
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]-fee);
        }
        return dp[n-1][0];
    }



//Using state transaction
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
//Using dp
    public static int maxProfitClockDownUsingDP(int[] prices) {
        int n = prices.length;
        if(prices.length<=1) return 0;
        if(prices.length ==2 ){
            if(prices[1]>prices[0]) return prices[1]-prices[0];
            else return 0;
        }

        int[][] dp=new int[n][2];

        dp[0][0]=0;
        dp[0][1]=-prices[0];

        dp[1][0]=Math.max(dp[0][0],dp[0][1]+prices[1]);
        dp[1][1]=Math.max(dp[0][1],dp[0][0]-prices[1]);


        for(int i=2;i<n;i++){
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
             dp[i][1]=Math.max(dp[i-1][1],dp[i-2][0]-prices[i]);
        }
        return dp[n-1][0];
    }

    //state transaction algo.
    public static int maxProfitClockDownOpt(int[] prices) {

       int A=0;
       int B=-prices[0];
       int C=0;
        for(int i=0;i<prices.length;i++){
            int temp=A;
           A=Math.max(A,C);
           C=prices[i]+B;
            B=Math.max(B,temp-prices[i]);
        }

        return Math.max(A,C);

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

    public static  int maxProfitIII(int[] prices) {
        if(prices.length==0) return 0;
        int k=2;
        int[][] dp=new int[k+1][prices.length];
        for(int i=1;i<=k;i++){
            int maxDiff = dp[i-1][0]-prices[0];
            for(int j=1;j<prices.length;j++){
                dp[i][j]=Math.max(dp[i][j-1],prices[j]+maxDiff);;
                maxDiff=Math.max(maxDiff,dp[i-1][j]-prices[j]);
            }
        }
        return dp[k][prices.length-1];
    }

    public static int maxProfitUsingDivideAndConquer(int[] prices){
        int n=prices.length;
        int min_price= prices[0];
        int max_price= prices[n-1];
        int leftMax_profit= 0;
        int rigthMax_profit =0;
        List<Integer> leftList= new ArrayList<>();
        List<Integer> rigthList =new ArrayList<>();
        leftList.add(leftMax_profit);
        rigthList.add(rigthMax_profit);
        int[] left=new int[n];
        int[] rigth=new int[n];
            left[0]=0;
            rigth[n-1]=0;
        for(int i=1;i<n;i++){
            if(min_price>prices[i]){
                min_price=prices[i];
            }else {
                leftMax_profit = Math.max(leftMax_profit,prices[i]-min_price);
                }
            if(max_price<prices[n-1-i]){
                max_price = prices[n-1-i];
            }else {
                rigthMax_profit= Math.max(rigthMax_profit,max_price-prices[n-1-i]);
            }
            leftList.add(leftMax_profit);
            rigthList.add(rigthMax_profit);
            left[i] =leftMax_profit;
            rigth[n-1-i] = rigthMax_profit;

        }
        int max_profit= Integer.MIN_VALUE;
        int profit=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){

            max_profit= Math.max(max_profit,leftList.get(i)+rigthList.get(n-1-i));
            profit =Math.max(profit,left[i]+rigth[i]);
        }
        System.out.println(profit);
        return max_profit;



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

//Using state transaction and dp
    public static int maxProfitIVOptNew(int[] prices,int k) {
        int n=prices.length;
        if(n<=0) return 0;
        if(k>=n/2) return maxProfitII(prices);

        int[] state = new int[k*2];
        for(int i=0;i<state.length;i++)
        {
            if(i%2==0){
                state[i]=Integer.MIN_VALUE;
            }
        }

        for(int i=0;i<prices.length;i++){

            for(int j=0;j<state.length;j++){
                if(j ==0){
                    state[j]= Math.max(state[j],-prices[i]);
                }
                else if(j%2==0){
                    state[j]=Math.max(state[j],state[j-1]-prices[i]);
                }else{
                    state[j]=Math.max(state[j],state[j-1]+prices[i]);
                }


            }


        }

        return state[2*k-1];



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
