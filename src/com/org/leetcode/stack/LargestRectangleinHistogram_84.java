package com.org.leetcode.stack;

import java.util.Stack;

public class LargestRectangleinHistogram_84 {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack=new Stack<>();
        int maxArea=0;
        int area=0;
        int i=0;
        while (i<heights.length){
            if(stack.isEmpty() || heights[stack.peek()]<=heights[i]){
                stack.push(i);
                i++;
            }else{
                maxArea = getMaxArea(heights, stack, maxArea, i);
            }
        }
        while (!stack.isEmpty()){
            maxArea = getMaxArea(heights, stack, maxArea, i);
        }
        return maxArea;
    }

    private int getMaxArea(int[] heights, Stack<Integer> stack, int maxArea, int i) {
        int area;
        int top = stack.pop();
        if (stack.isEmpty()) {
            //i-1 will be the higher bound.
            area = heights[top] * (i - 1 - (-1));// if stack is empty lower bound will be -1.
        } else {
            area = heights[top] * (i - 1 - stack.peek());// if stack is not empty peek element will be the lower bound.
        }
        maxArea = maxArea < area ? area : maxArea;
        return maxArea;
    }

    public static void main(String args[]){
        LargestRectangleinHistogram_84 l=new LargestRectangleinHistogram_84();
        int arr[]={7,6,5,4,3,2,1};
        System.out.println(l.largestRectangleArea(arr));
    }
}
