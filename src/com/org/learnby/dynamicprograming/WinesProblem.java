package com.org.learnby.dynamicprograming;

public class WinesProblem {
    public static void main(String args[]){
        int[] p={2,3,5,1,4};
        int start=0;
        int end=p.length-1;
        int[][] dp=new int[p.length][p.length];
        System.out.println(maxProfit(p,start,end,dp,1));

    }
    public static int maxProfit(int[] p,int start,int end,int[][] dp,int year){

        if(start>end) return 0;
        if(dp[start][end]!=0) return dp[start][end];

        int opt1=p[start]*year+maxProfit(p,start+1,end,dp,year+1);
        int opt2=p[end]*year+maxProfit(p,start,end-1,dp,year+1);
        return dp[start][end]=Math.max(opt1,opt2);

    }
}
