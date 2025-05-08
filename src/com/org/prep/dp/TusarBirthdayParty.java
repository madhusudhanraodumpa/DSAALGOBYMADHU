package com.org.prep.dp;

public class TusarBirthdayParty {
    public static void main(String[] args) {
        int A[]={2,3,1,5,4};
        int B[]={3,2,3,4,1,1};
        int C[]={1,2,3,5,5,10};
        System.out.println(solve(A,B,C));
    }

    public static int solve(final int[] A, final int[] B, final int[] C) {
        int n=C.length;
        int sum=0;
        int val=Integer.MIN_VALUE;
        for(int i=0;i<A.length;i++) {
            val=Math.max(A[i],val);
        }
        int ans[][] = unBoundedKanpsack(B,C,val);
        for(int i=0;i<A.length;i++) {
            sum=sum+ans[n][A[i]];
        }


        return sum;
    }

    public static int[][] unBoundedKanpsack(int[] items,int[] cost,int capacity){
        int n=items.length;
        int k=capacity;
        int[][] dp =new int[n+1][k+1];
        for(int j=0;j<=k;j++){
            dp[0][j]=1000000;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=k;j++){
                int dontPick=dp[i-1][j];
                int pick=Integer.MAX_VALUE;
                if(j>=items[i-1]) {
                    pick=dp[i][j-items[i-1]]+cost[i-1];


                }
                dp[i][j]=Math.min(pick,dontPick);
            }
        }
        return dp;
    }
}
