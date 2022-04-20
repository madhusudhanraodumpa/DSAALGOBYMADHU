package com.org.prep.stack;

import java.util.Stack;

public class MinStack {
    /** initialize your data structure here. */
    private Stack<Integer> orginalStack;
    private Stack<Integer> miniStack;
    int minValue=Integer.MAX_VALUE;

    public MinStack() {
        this.orginalStack = new Stack<>();
    }

    public void push(int x) {
        if(orginalStack.isEmpty()){
            orginalStack.push(x);
            minValue=x;
            return;
        }

        if(minValue>x){
            int val=2*x-minValue;
            minValue=x;
            orginalStack.push(val);
        }else{
            orginalStack.push(x);
        }

    }

    public void pop() {
        if (!orginalStack.isEmpty() && orginalStack.peek()<minValue) {
            int x=2*minValue-orginalStack.peek();
            minValue=x;
            orginalStack.pop();
        } else {
            orginalStack.pop();
        }

    }

    public int top() {
        if (!orginalStack.isEmpty()&&orginalStack.peek()<minValue) {
            return minValue;
        } else if(!orginalStack.isEmpty()){
            return orginalStack.peek();
        }else{
            return 0;
        }
    }

    public int getMin() {
        return minValue;
    }
}
