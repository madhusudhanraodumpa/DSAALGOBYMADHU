package com.org.prep.array;


import java.util.Stack;

public class LargestRectangleHistrogram {
    public static void main(String args[]){
        int a[]={2,1,5,6,2,3};
        largestRectangleArea(a);
    }


    public static int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int maxArea= Integer.MIN_VALUE;
        Stack<Integer> stack= new Stack<>();
        int i =0;
        int value=0;
        int lowerBound =0;
        int higherBound=0;
        while (i<len){
            if(stack.isEmpty() || heights[stack.peek()]<=heights[i]){
                stack.push(i++);
            }else {
                value= stack.pop();
                lowerBound = stack.empty()?-1:stack.peek();
                higherBound=i-1;
                maxArea=Math.max(maxArea,(higherBound-lowerBound)*heights[value]);


            }
        }
        while (!stack.isEmpty()){
            value= stack.pop();
            lowerBound = stack.empty()?-1:stack.peek();
            higherBound=i-1;
            maxArea=Math.max(maxArea,(higherBound-lowerBound)*heights[value]);
        }
        return maxArea;
    }
}
