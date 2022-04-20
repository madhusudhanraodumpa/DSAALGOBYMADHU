package com.org.prep.stack;

import java.util.Stack;

public class NextGreaterElementCircular {
    public static void main(String args[]) {
        int[] a = {100,1,11,1,120,111,123,1,-1,-100};
        int greater[] = new int[a.length];
        nextGreater(a);
        System.out.println();
    }

    public static void nextGreater(int[] a) {
        int[] greater=new int[a.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 2*a.length; i++) {
            if (stack.isEmpty()) {
                if(i<a.length) {
                    stack.push(i);
                }
            } else {
                while (!stack.isEmpty() && a[stack.peek()] < a[i%a.length]) {
                    int temp = stack.pop();
                    //a[temp] = a[i%a.length];
                    greater[temp]=a[i%a.length];
                }
                if(i<a.length) {
                    stack.push(i);
                }
            }
        }
        while (!stack.isEmpty()) {
            greater[stack.pop()] = -1;
        }
    }
}
