package com.org.prep.stack;

import java.util.Stack;

public class TrappingRainWaterII {
    public static void main(String[] args) {
        int a[]={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(a));
    }
    public static int trap(int[] height) {
        int n=height.length;
        int[] p1=nextGreaterLeft(height,n);
        int[] p2=nextGreaterRight(height,n);
        int ans=0;
        for(int i=0;i<n;i++){
            if(p1[i]==-1 || p2[i]==-1){
                continue;
            }else{
                ans= ans+Math.min(p2[i],p1[i])-height[i];
            }
        }
        return ans;
    }
    public static int[] nextGreaterLeft(int[] a,int n){
        Stack<Integer> stack=new Stack<>();
        int[] ans=new int[n];
        stack.push(a[0]);
        ans[0]=-1;
        for(int i=1;i<n;i++){
            while(!stack.isEmpty() && stack.peek()<=a[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                ans[i]=-1;
            }else{
                ans[i]=stack.peek();
            }
            stack.push(a[i]);

        }
        return ans;
    }
    public static int[] nextGreaterRight(int[] a,int n){
        Stack<Integer> stack=new Stack<>();
        int[] ans=new int[n];
        stack.push(a[n-1]);
        ans[n-1]=-1;
        for(int i=n-2;i>=0;i--){
            while(!stack.isEmpty() && stack.peek()<=a[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                ans[i]=-1;
            }else{
                ans[i]=stack.peek();
            }
            stack.push(a[i]);

        }
        return ans;
    }
}
