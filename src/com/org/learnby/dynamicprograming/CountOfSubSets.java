package com.org.learnby.dynamicprograming;

public class CountOfSubSets {
    public static void main(String args[]) {
        int[] a = {2,3,5,6,8,10};
        int sum = 10;
        System.out.println(countSubSetSum(a, sum));

    }

    public static int countSubSetSum(int a[], int sum) {
        int n=a.length;
        int[][] dp=new int[n+1][sum+1];

        for(int i=0;i<n+1;i++){
            for(int j=0;j<sum+1;j++){
                //intlization
                if(i==0) {  if(j==0){
                    dp[i][j] = 1;
                }else {
                    dp[i][j] = 0;
                }
                }
                else if(j==0) {dp[i][j]=1;}

                //actual code
                else if(a[i-1]<=j){

                    int include=dp[i-1][j-a[i-1]];
                    int exclude=dp[i-1][j];
                    dp[i][j]= include+exclude;

                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

        return dp[n][sum];


    }
}
