package com.org.learnby.dynamicprograming;

public class MatrixChainMultiplication {
    public static void main(String args[]){
        int a[]={1, 2, 3, 4, 3};
        System.out.println(minCost(a,1,a.length-1));
        System.out.println(minCostDP(a,a.length));

    }
    public static int minCost(int a[],int i,int j){
        if(i>=j) return 0;
        int minCost=Integer.MAX_VALUE;

        for(int k=i;k<=j-1;k++){
            int temp= minCost(a,i,k)+minCost(a,k+1,j)+a[i-1]*a[k]*a[j];
            minCost=Math.min(minCost,temp);
        }
        return minCost;
    }

    public static int minCostDP(int a[],int n){
        int dp[][]=new int[n][n];

        for(int i=0;i<n;i++){
            dp[i][i]=0;
        }

        for (int len=2; len<n; len++)
        {
            for (int i=1; i<n-len+1; i++)
            {
                int j = i+len-1;
                if(j == n) continue;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k=i; k<=j-1; k++)
                {
                    // q = cost/scalar multiplications
                    int q = dp[i][k] + dp[k+1][j] + a[i-1]*a[k]*a[j];
                    if (q < dp[i][j])
                        dp[i][j] = q;
                }
            }
        }

        return dp[1][n-1];
    }
}
