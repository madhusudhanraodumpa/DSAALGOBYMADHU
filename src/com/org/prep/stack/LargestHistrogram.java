package com.org.prep.stack;

import java.util.Stack;

public class LargestHistrogram {
    public static void main(String args[]){
        int a[]={2,1,2};
        System.out.println(largestRectangleArea2(a));
        System.out.println(largestRectangleArea1(a));

    }

    public static int largestRectangleArea(int[] heights) {
        int max_rectangle=Integer.MIN_VALUE;
        for(int i=0;i<heights.length;i++){
            int left=i;
            int right=i;
            while(right<heights.length && heights[i]<=heights[right]){
                right++;
            }
            while(left>0 && heights[i]<heights[left-1]){
                left--;
            }
            max_rectangle=Math.max(max_rectangle,(right-left)*heights[i]);



        }

        return max_rectangle;
    }
    public static int largestRectangleArea1(int[] heights) {
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

    public static int largestRectangleArea2(int[] heights) {

        int n=heights.length;
        int start=0;
        int end=n-1;

        int max_area=Integer.MIN_VALUE;
        Stack<Integer> stack=new Stack<Integer>();
        int lowerbound=0;
        int higherbound=0;

        while(start<=end){

            if(stack.isEmpty() || heights[stack.peek()]<=heights[start]){
                stack.push(start);
                start++;
            }else{
                int value=stack.pop();
                higherbound=start-1;
                lowerbound=stack.isEmpty()?-1:stack.peek();

                max_area=Math.max(max_area,(higherbound-lowerbound)*heights[value]);

            }

          //  start++;



        }
        while(!stack.isEmpty()){
            int value=stack.pop();
            higherbound=start-1;
            lowerbound=stack.isEmpty()?-1:stack.peek();
            max_area=Math.max(max_area,(higherbound-lowerbound)*heights[value]);
        }


        return max_area;


    }
}
