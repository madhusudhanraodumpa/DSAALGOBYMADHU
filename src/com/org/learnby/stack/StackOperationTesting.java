package com.org.learnby.stack;

public class StackOperationTesting {
    public static void main(String args[]){
        Stack stack=new Stack();
        for(int i=1;i<=10;i++){
            stack.push(i);
        }
        stack.pop();
        stack.pop();
        System.out.println(stack.peek());
        stack.push(20);
        System.out.println(stack.peek());

    }
}
