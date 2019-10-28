package com.org.learnby.stack;

import java.util.Stack;

public class SmallestNumberNearToLeft {
    public static void main(String args[]){
        int a[]={1, 5, 0 ,3, 4, 5};
        Stack<Integer> st1=new Stack();
        Stack<Integer> st2=new Stack();
        int smallest;
        for(int i:a){
            if((st1.isEmpty() && st2.isEmpty()) || (st1.peek()>i)){
                st2.push(-1);
            }else{
                if(st1.peek()<i){
                    st2.push(st1.peek());
                }
            }
            st1.push(i);
        }
        while(!st2.isEmpty()){
            System.out.println(st2.pop());
        }
    }
}
