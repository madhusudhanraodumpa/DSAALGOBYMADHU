package com.org.prep.dp;

public class HouseRobber1 {
    public static void main(String[] args) {
        int a[]={2,3,2};
        System.out.println(rob(a));

    }
    public static int rob(int[] nums) {

        int n=nums.length;
        if(n==1) return nums[0];
        int[] temp1=new int[n-1];
        int[] temp2=new int[n-1];
        int j=0;
        int k=0;
        for(int i=0;i<n;i++){

            if(i!=0) temp1[j++]=nums[i];
            if(i!=n-1) temp2[k++]=nums[i];

        }

        return Math.max(rob1(temp1),rob1(temp2));



    }


    public static int rob1(int[] nums) {

        int n=nums.length;

        if(n==1) return nums[0];
        int[] dp=new int[n];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);

        for(int i=2;i<n;i++){
            int pick=nums[i]+dp[i-2];
            int notPick=dp[i-1];
            dp[i]=Math.max(pick,notPick);


        }

        return dp[n-1];
    }
}
