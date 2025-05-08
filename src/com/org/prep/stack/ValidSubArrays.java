package com.org.prep.stack;

import java.util.Stack;

public class ValidSubArrays {
    public static void main(String[] args) {
        int a[]= {1,4,2,5,3};
        System.out.println(validSubarrays(a));
    }
    public static int validSubarrays(int[] nums) {
        int n=nums.length;
        int res[] = nextSmallerRight(nums,n);
        int count=0;
        for(int i=0;i<n;i++){
            if(res[i]==-1){
                count=count+n-i;
            }else{
                count=count+res[i]-i;
            }
        }
        return count;

    }
    public static int[] nextSmallerRight(int[] nums,int n){
        Stack<Integer> stack=new Stack<>();
        int[] res=new int[n];
        res[n-1]=-1;
        stack.push(n-1);
        for(int i=n-2;i>=0;i--){
            while(!stack.isEmpty() && nums[stack.peek()]>nums[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                res[i]=-1;
            }else{
                res[i]=stack.pop();
            }
            stack.push(i);

        }
        return res;
    }

    public static int validSubarrays1(int[] nums) {
        int n=nums.length;
        int count=0;
        for(int i=0;i<n;i++){
            int min=nums[i];
            for(int j=i;j<n;j++){
                if(i==j){
                    count++;
                    min=nums[i];
                } else if(min<nums[j]) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;

    }
}
