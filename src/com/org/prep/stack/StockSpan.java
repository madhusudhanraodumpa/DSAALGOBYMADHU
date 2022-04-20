package com.org.prep.stack;

import java.util.Stack;

public class StockSpan {
    public static void main(String args[]) {
        int a[] = {100, 80, 60, 70, 60, 75, 85};
        stockSpan(a);
    }

    private static int[] stockSpan(int a[]) {
        Stack<Integer> stack = new Stack<>();
        int[] span = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
                span[i] = 1;
            } else {
                while (a[stack.peek()] < a[i]) {
                    stack.pop();
                }

                span[i] = i - stack.peek();
                stack.push(i);
            }
        }

        return span;
    }
}
