package com.org.learnby.dynamicprograming;

public class TargetSum {
    public static void main(String args[]){
        int[] a={1,0};
        System.out.println(findTargetSumWays(a,1));
    }
    public static int findTargetSumWays(int[] a, int target) {

        int n=a.length;
        int cnt = 0;
        int totalSum=0;
        for(int i=0;i<n;i++){
            totalSum+=a[i];
            if(a[i]==0)
                cnt = cnt+1;
        }
        if(target>totalSum) return 0;
        int s1=(target+totalSum)/2;
        return countSubSetSum(a,s1,cnt);

    }
    public static int countSubSetSum(int a[], int sum,int cnt) {
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

        return  (int)Math.pow(2,cnt)*dp[n][sum];


    }
}
