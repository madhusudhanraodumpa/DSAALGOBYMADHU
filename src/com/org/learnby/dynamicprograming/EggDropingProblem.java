package com.org.learnby.dynamicprograming;

public class EggDropingProblem {
    public static void main(String args[]){
        System.out.println(superEggDropOpt(2,7));
    }

    private static int noOfAttemptsToDropEggs(int eggs, int floors) {
        int dp[][]=new int[eggs+1][floors+1];
        for(int i=0;i<=floors;i++){
            dp[1][i]=i;
        }
        int c=0;
        for(int e=2;e<=eggs;e++){
            for(int f=1;f<=floors;f++){
                dp[e][f]=Integer.MAX_VALUE;
                for(int k=1;k<=f;k++){
                    int eggBreak=dp[e-1][k-1];// egg if breaks it will check reamining eggs with below floors
                    int eggNotBrak=dp[e][f-k]; //egg if not break then it ry for ramining floors ;
                    c=1+Math.max(eggBreak,eggNotBrak);
                    if(c<dp[e][f]){// Minum of all follors trying.
                        dp[e][f]=c;
                    }
                }
            }
        }

        return dp[eggs][floors];


    }


    public int superEggDrop(int K, int N) {
        // Right now, dp[i] represents dp(1, i)
        int[] dp = new int[N + 1];
        for (int i = 0; i <= N; ++i)
            dp[i] = i;

        for (int k = 2; k <= K; ++k) {
            // Now, we will develop dp2[i] = dp(k, i)
            int[] dp2 = new int[N + 1];
            int x = 1;
            for (int n = 1; n <= N; ++n) {
                // Let's find dp2[n] = dp(k, n)
                // Increase our optimal x while we can make our answer better.
                // Notice max(dp[x-1], dp2[n-x]) > max(dp[x], dp2[n-x-1])
                // is simply max(T1(x-1), T2(x-1)) > max(T1(x), T2(x)).
                while (x < n && Math.max(dp[x - 1], dp2[n - x]) > Math.max(dp[x], dp2[n - x - 1]))
                    x++;

                // The final answer happens at this x.
                dp2[n] = 1 + Math.max(dp[x - 1], dp2[n - x]);
            }

            dp = dp2;
        }

        return dp[N];
    }

    public static int superEggDropOpt(int K, int N) {
        int[][] dp = new int[N + 1][K + 1];
        int m = 0;
        while (dp[m][K] < N) {
            ++m;
            for (int k = 1; k <= K; ++k)
                dp[m][k] = dp[m - 1][k - 1] + dp[m - 1][k] + 1;
        }
        return m;
    }

    public int calculateRecursive(int eggs, int floors){
        if(eggs == 1){
            return floors;
        }
        if(floors == 0){
            return 0;
        }
        int min = 1000;
        for(int i=1; i <= floors; i++){
            int val = 1 + Math.max(calculateRecursive(eggs-1, i-1),calculateRecursive(eggs, floors-i));
            if(val < min){
                min = val;
            }
        }
        return min;
    }
}
