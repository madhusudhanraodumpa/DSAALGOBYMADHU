package com.org.learnby.stack;

public class HistogramProblem {

    public static void main(String args[]) {

        java.util.Stack<Character> s = new java.util.Stack<Character>();

        int hist[] = {6,2,4,5,4,1,6 };
        ;
        int n = hist.length;
        System.out.println(largestRectangleArea(hist));

    }

    public static int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        java.util.Stack<Integer> stack = new java.util.Stack<Integer>();

        int max = 0;
        int area = 0;
        int i = 0;

        while (i < height.length) {
            // push index to stack when the current height is larger than the
            // previous one
            if (stack.isEmpty() || height[i] >= height[stack.peek()]) {
                stack.push(i);
                i++;
            } else {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    area = height[top] * i;
                } else {
                    area = height[top] * (i - stack.peek() - 1);
                }
                if (area > max) {
                    max = area;
                }
            }

        }

        while (!stack.isEmpty()) {
            int top = stack.pop();
            if (stack.isEmpty()) {
                area = height[top] * i;
            } else {
                area = height[top] * (i - stack.peek() - 1);
            }
            if (area > max) {
                max = area;
            }
        }

        return max;
    }
}
