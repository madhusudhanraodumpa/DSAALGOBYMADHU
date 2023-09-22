package com.org.prep.dp;

public class PaintHouse2 {
    public static void main(String args[]){
        int[][] a={{1,5,3},{2,9,4}};
        PaintHouse2 p=new PaintHouse2();
        System.out.println(p.minCost(a));

    }

    public int minCost(int[][] costs){
        int n=costs.length;
        int k=costs[0].length;

        // int n=costs.length;
        int[][] dp=new int[n][k];

        for(int j=0;j<k;j++){
            dp[0][j]=costs[0][j];
        }

        for(int i=1;i<n;i++){

            for(int j=0;j<k;j++){
                int minC=Integer.MAX_VALUE;
                for(int x=0;x<k;x++){

                    if(j!=x){
                        minC=Math.min(minC,dp[i][x]);
                    }
                }
                dp[i][j]=minC+costs[i][j];
            }

        }

        int micCPaint=Integer.MAX_VALUE;

        for(int j=0;j<k;j++){
            micCPaint=Math.min(micCPaint,dp[n-1][j]);
        }

        return micCPaint;

    }
}
