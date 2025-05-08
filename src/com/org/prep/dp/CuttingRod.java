package com.org.prep.dp;

public class CuttingRod {
    public static void main(String[] args) {
        int[] a={3,4,1,6,2};
        System.out.println(solve2(a,a.length));
    }

    public static int solve2(int[] A,int n) {

        int[] dp=new int[n+1];

        for (int i=1;i<=n;i++) {
            int result=Integer.MIN_VALUE;
            for(int j=0;j<i;j++){
                result = Math.max(result, A[j] + dp[i - j - 1]);

            }
            dp[i]=result;

        }

        return dp[n];


    }

    public static int solve1(int[] A,int n) {

        if(n<=0) return 0;
        int result=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int current=0;
            for(int j=1;j<=n;j++){
                current=A[j-1]+solve1(A,n-j);
                result=Math.max(result,current);
            }

        }

        return result;
    }
    public static int solve(int[] A) {
        int n=A.length;
        int[][] dp=new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){

                int dontCut=dp[i-1][j];
                int cut=0;
                if(j>=i){
                    cut=dp[i][j-i]+A[i-1];

                }
                dp[i][j]=Math.max(cut,dontCut);
            }
        }
        return dp[n][n];
    }
}
