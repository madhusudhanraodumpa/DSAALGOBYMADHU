package com.org.learnby.dynamicprograming;

public class SubSetSumPartitionProblem {
    public static void main(String args[]) {
        int[] a = {1, 5, 11, 5};
        System.out.println(canPartition1(a));
    }



    public static boolean canPartition1(int[] a) {
        int sum=0;
        int n=a.length;
        for(int i=0;i<n;i++){
            sum+=a[i];
        }
        if(sum%2!=0){
            return false;
        }else{
            return isSubsetSum(sum/2,a,n);
        }

    }
    private static boolean isSubsetSum(int sum,int[] a,int n){


        boolean[][] dp=new boolean[n+1][sum+1];

        for(int i=0;i<n+1;i++){
            for(int j=0;j<sum+1;j++){
                if(i==0) {
                    if(j==0){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = false;
                    }
                }
                else if(j==0) {dp[i][j]=true;}

                else if(a[i-1]<=j){

                    boolean include=dp[i-1][j-a[i-1]];
                    boolean exclude=dp[i-1][j];
                    dp[i][j]= include||exclude;

                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

        return dp[n][sum];



    }

    private static boolean equalPartionExists(int[] a) {


        int sumArray = 0;
        for (int i = 0; i < a.length; i++) {
            sumArray += a[i];
        }
        if (sumArray % 2 != 0) return false;
        int sum = sumArray / 2;
        return isSubSetSum(a, sum);
    }

    private static boolean isSubSetSum(int a[], int sum) {
        boolean[][] dp = new boolean[a.length][sum + 1];
        for (int i = 0; i < a.length; i++) {
            dp[i][0] = true;
        }
        for (int j = 0; j <= sum; j++) {
            if (j == a[0])
                dp[0][j] = true;
        }

        for (int i = 1; i < a.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (dp[i - 1][j]) {
                    dp[i][j] = true;
                } else {
                    if (j >= a[i]) {
                        dp[i][j] = dp[i - 1][j - a[i]];
                    }
                }

            }
        }
        return dp[a.length - 1][sum];

    }













    public static boolean canPartition(int[] nums) {
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) return false;
        int target = sum / 2;
        boolean[] arr = new boolean[target + 1];
        arr[0] = true;
        for (int num : nums) {
            for (int i = target; i >= num; --i) {
                arr[i] = arr[i] || arr[i - num];
            }
        }
        return arr[target];
    }
}
