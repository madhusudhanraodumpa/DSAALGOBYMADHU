package com.org.learnby.dynamicprograming.subsequences;

import java.util.Arrays;

public class CountIncreasingSubsequences {
    public static void main(String[] args)
    {
        int arr[] = {1,3,5,4,7};
        int n = arr.length;

        System.out.println(findNumberOfLIS(arr));
    }
    public static int findNumberOfLIS(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        int[] c=new int[n];

        Arrays.fill(dp,1);
        Arrays.fill(c,1);

        int max=1;

        for(int i=1;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(nums[i]>nums[j])
                {
                    if(dp[j]+1 > dp[i])//same subsequence
                    {
                        dp[i]=dp[j]+1;
                        c[i]=c[j];
                    }
                    else if(dp[j]+1==dp[i])//different subsequence
                    {
                        c[i]+=c[j];
                    }

                }
            }
            max=Math.max(dp[i],max);
        }

        int count=0;
        for(int i=0;i<n;i++)
            if(dp[i]==max)
                count+=c[i];

        return count;
    }
}
