package com.org.leetcode.stack;


import java.util.Stack;

public class TrappingRainWater_42 {
    public static void main(String args[]){
        TrappingRainWater_42 t=new TrappingRainWater_42();
        int []arr={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(t.trap(arr));
        System.out.println(t.trapWithOutStack(arr));
    }

    public int trap(int[] height) {
        int totalTrappedWater=0;
        Stack<Integer> stack=new Stack();
        for(int i=0;i<height.length;i++) {

            while (!stack.isEmpty() && height[stack.peek()] <height[i]){
                    int top = stack.pop();
                    int dist=0;
                    int area=0;
                    if(!stack.isEmpty()) {
                        dist = i - 1 - stack.peek();
                        area = Math.min(height[i], height[stack.peek()]) - height[top];
                    }
                    totalTrappedWater += dist * area;

            }
            if(!stack.isEmpty() && height[stack.peek()]==height[i]){
                stack.pop();
                stack.push(i);
            }else{
                stack.push(i);
            }
        }

        return totalTrappedWater;
    }

    public int trapWithOutStack(int[] height) {
        int totalTrappedWater=0;
        int[] leftMax=new int[height.length];
        int[] rightMax=new int[height.length];
        int lmax=Integer.MIN_VALUE,rmax=Integer.MIN_VALUE;
        /*for(int i=0;i<height.length;i++){
            lmax=Math.max(lmax,height[i]);
            leftMax[i]=lmax;
        }*/
        for(int j=height.length-1;j>0;j--){
            rmax=Math.max(rmax,height[j]);
            rightMax[j]=rmax;
        }
        for(int k=0;k<height.length;k++){
            lmax=Math.max(lmax,height[k]);
            totalTrappedWater+=Math.min(lmax,rightMax[k])-height[k];
        }


        return totalTrappedWater;
    }

    public int trapWithTwoPonter(int[] height) {
        int totalTrappedWater=0;



        return totalTrappedWater;
    }
}
