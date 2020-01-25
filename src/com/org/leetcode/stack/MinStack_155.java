package com.org.leetcode.stack;

import java.util.Stack;

public class MinStack_155 {
    private Stack<Integer> orginalStack;
    private Stack<Integer> miniStack;

    public MinStack_155() {
        this.orginalStack = new Stack<>();
        this.miniStack = new Stack<>();
    }

    public void push(int x) {
        if (miniStack.isEmpty()) {
            miniStack.push(x);
        } else if (miniStack.peek() >= x) {
            miniStack.push(x);
        }
        orginalStack.push(x);

    }

    public void pop() {
        if (orginalStack.peek().equals(miniStack.peek())) {
            orginalStack.pop();
            miniStack.pop();
        } else {
            orginalStack.pop();
        }

    }

    public int top() {
        if (!orginalStack.isEmpty()) {
            return orginalStack.peek();
        } else {
            return -1;
        }
    }

    public int getMin() {
        if (!miniStack.isEmpty()) {
            return miniStack.peek();
        } else {
            return -1;
        }
    }

    public static void main(String args[]) {
        MinStack_155 m = new MinStack_155();
        int x = 10;
        m.push(512);
        m.push(-1024);
        m.push(-1024);
        m.push(512);

        m.pop();
        System.out.print(m.getMin());
        m.pop();
        System.out.print(m.getMin());
        m.pop();
        System.out.print(m.getMin());


    }
}
