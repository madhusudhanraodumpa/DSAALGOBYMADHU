package com.org.prepartion.dynamicprograming;

public class ZeroOrOneKnapsack {
    public static void main(String[] args){
        int W=8;
        int val[]={1,4,7,10};
        int wt[] ={1,2,3,5};
        int n = wt.length;
        int[][] k = new int[n+1][W+1];

        for(int i=0;i<=n;i++){
            for(int j=0;j<=W;j++){
                if(i==0 || j ==0){
                    k[i][j] = 0;
                }else{
                    if(wt[i-1]<=j){
                        k[i][j] = Math.max(val[i-1]+k[i-1][j-wt[i-1]],k[i-1][j]);
                    }else{
                        k[i][j] = k[i-1][j];
                    }
                }
            }
        }
        System.out.println(k[n][W]);
    }
}
