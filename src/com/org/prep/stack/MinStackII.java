package com.org.prep.stack;

import java.util.Stack;

public class MinStackII {
    Stack<Long> stack;
    long minV;

    public MinStackII() {
        stack=new Stack<>();
        minV=-1;
    }

    public void push(int val) {
        if(stack.isEmpty()){
            stack.push(Long.valueOf(val));
            minV=val;
        }
      else   if(val>=minV){
            stack.push(Long.valueOf(val));
        }else{
            stack.push(Long.valueOf(val)*2-minV);
            minV=val;
        }
    }

    public void pop() {
        long val=stack.peek();
        if(val>=minV){
            stack.pop();
        }else{
            minV=(2*minV)-val;
            stack.pop();
        }

    }

    public int top() {
        long val=stack.peek();

        if(val>=minV){
            return (int)val;
        }else{
            return (int)minV;
        }
    }

    public int getMin() {
        return (int)minV;
    }

    public static void main(String[] args) {
        MinStackII minStackII=new MinStackII();
        minStackII.push(2147483646);
        minStackII.push(2147483646);
        minStackII.push(2147483647);
        System.out.println(minStackII.top());
        minStackII.pop();
        System.out.println(minStackII.getMin());
        minStackII.pop();
        System.out.println(minStackII.getMin());
        minStackII.pop();
        minStackII.push(2147483647);
        System.out.println(minStackII.top());
        System.out.println(minStackII.getMin());
minStackII.push(-2147483648);
        System.out.println(minStackII.top());
        System.out.println(minStackII.getMin());



        minStackII.pop();
        System.out.println(minStackII.getMin());
    }
}
