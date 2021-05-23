package com.org.learnby.dynamicprograming;

public class HouseRobberProblem {
    public static void main(String args[]){
        int a[]={1,2,3,1};
        System.out.println(houseRobberII(a));

    }
    public static int houseRobber(int a[],int start,int end){
        if(start == end) return a[start];
        if(start+1==end) return Math.max(a[start],a[end]);

        return Math.max(a[start]+houseRobber(a,start+2,end),houseRobber(a,start+1,end));
    }
    public static int houseRobberDP(int a[],int start,int end){
        int dp[] = new int[a.length];
        dp[0]= a[0];
        dp[1] = Math.max(a[0],a[1]);
        for(int i=2;i<a.length;i++){
            dp[i]= Math.max(a[i]+dp[i-2],dp[i-1]);
        }
        return dp[a.length-1];

    }
    public static int houseRobberConstantSpace(int a[],int start,int end){
        int value1 = a[0];
        int value2 = Math.max(a[0],a[1]);
        for (int i = 2; i < a.length; i++) {
            int temp = Math.max(a[i] + value1, value2);
            value1 = value2;
            value2 = temp;
        }
        return value2;
    }
    public static int houseRobberII(int nums[]){
        if(nums.length ==0) return 0;
        if(nums.length ==1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0],nums[1]);
        return Math.max(houseRobberIIExt(nums,0,nums.length-2),houseRobberIIExt(nums,1,nums.length-1));
    }

    public static int houseRobberIIExt(int a[],int start,int end){

        if(start+1==end) return Math.max(a[start],a[end]);
        int value1 = a[start];
        int value2 = Math.max(a[start],a[start+1]);
        for (int i = start+2; i <=end; i++) {
            int temp = Math.max(a[i] + value1, value2);
            value1 = value2;
            value2 = temp;
        }
        return value2;
    }
}
