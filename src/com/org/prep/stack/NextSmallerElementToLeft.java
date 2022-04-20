package com.org.prep.stack;

import java.util.Stack;

public class NextSmallerElementToLeft {
    public static void main(String args[]) {
        int[] a = {15, 12, 16, 2, 1, 0, 7, 8};
        int greater[] = new int[a.length];
        nextGreater(a);
        System.out.println();
    }

    public static void nextGreater(int[] a) {
        Stack<Integer> stack = new Stack<>();
        for (int i = a.length-1; i >= 0; i--) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && a[stack.peek()] > a[i]) {
                    int temp = stack.pop();
                    a[temp] = a[i];
                }
                stack.push(i);
            }
        }
        while (!stack.isEmpty()) {
            a[stack.pop()] = -1;
        }
    }
}
