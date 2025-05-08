package com.org.prep.dp;

public class MatrixChainMultiplication {
    public static void main(String[] args) {
        int A[]={45,17,34,27,12,22};
        System.out.println(solve(A));

    }

    public static int solve(int[] A) {
        int n=A.length;
        return mcm(A,1,n-1);

    }
    public static int mcm(int[] v,int i,int j) {
        if(i==j) return 0;

        int ans=Integer.MAX_VALUE;

        for(int k=i;k<j;k++){
            int a=mcm(v,i,k);
            int b=mcm(v,k+1,j);
            int c= v[i-1]*v[k]*v[j];
            ans=Math.min(a+b+c,ans);

        }

        return ans;

    }
}
