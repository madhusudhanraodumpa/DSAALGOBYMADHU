package com.org.learnby.stack;

import java.util.Stack;

public class DeleteMiddleElementInStack {
    public static void main(String args[]) {
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();

        int a[] = {1, 2, 3, 4};
        for (int i : a) {
            st1.push(i);
        }
        int n = st1.size() / 2;
        for (int i = 0; i < n; i++) {
            st2.push(st1.pop());
        }
        st1.pop();
        while (!st2.isEmpty()) {
            st1.push(st2.pop());
        }
        while (!st1.isEmpty()) {
            System.out.println(st1.pop());
        }
    }
}
