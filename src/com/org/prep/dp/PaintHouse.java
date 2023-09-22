package com.org.prep.dp;

import java.lang.reflect.Array;
import java.util.Arrays;

public class PaintHouse {
    public static void main(String args[]){
        PaintHouse p=new PaintHouse();
        int[][] a={{17,2,17},{16,16,5},{14,3,19}};
        p.minCost(a);
    }


    public int minCost(int[][] costs) {
        int n=costs.length;
        int[][] dp=new int[n][4];

        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));

        return minPaints(costs,n-1,3,dp);
    }
    public int minPaints(int[][] costs,int hno,int last,int[][] dp){

        int minCost=Integer.MAX_VALUE;
        if(hno==0){

            for(int i=0;i<3;i++){

                if(i!=last){
                    minCost=Math.min(minCost,costs[hno][i]);
                }


            }
            return minCost;
        }else{

            if(dp[hno][last]!=-1) return dp[hno][last];
            for(int i=0;i<3;i++){

                if(i!=last){
                    minCost= Math.min(minCost,minPaints(costs,hno-1,i,dp)+costs[hno][i]);
                }


            }
            dp[hno][last]=minCost;
            return dp[hno][last];




        }
    }
}
