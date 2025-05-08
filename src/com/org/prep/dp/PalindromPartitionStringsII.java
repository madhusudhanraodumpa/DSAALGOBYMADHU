package com.org.prep.dp;

public class PalindromPartitionStringsII {
    public static void main(String[] args) {
        System.out.println(minCut("xxyy"));
    }

    public static int minCut(String s) {
        int[] dp=new int[s.length()+1];
        int n=s.length();

        for(int i=n-1;i>=0;i--) {
            int minCost=Integer.MAX_VALUE;

            for(int j=i;j<s.length();j++) {
                if(isPalindrome(s,i,j)) {

                    int cost =1+dp[j+1];
                    minCost=Math.min(minCost,cost);

                }
                dp[i]=minCost;


            }
        }

        return dp[0]-1;

    }

    public static int f(String s,int index,int[] dp) {

        if(index==s.length()) return 0;
        if(dp[index]!=-1) return dp[index];

        int minCost=Integer.MAX_VALUE;

        for(int j=index;j<s.length();j++) {
            if(isPalindrome(s,index,j)) {

                int cost =1+f(s,j+1,dp);
                minCost=Math.min(minCost,cost);
                dp[index]=minCost;

            }


        }
        dp[index]=minCost;
        return dp[index];


    }
    public static boolean isPalindrome(String s,int start,int end) {

        while(start<=end){
            if(s.charAt(start)!=s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;

    }
}
