package com.org.prep.stack;

import java.util.Stack;

public class NextGreaterElementCircular {
    public static void main(String args[]) {
        int[] a = {3,8,4,1,2};
        int greater[] = new int[a.length];
        nextGreater(a);
        System.out.println();
    }


    public static void nextGreater1(int[] a) {
        int[] greater=new int[a.length];
        Stack<Integer> stack = new Stack<>();
        int n=a.length;
        for(int i=n-1;i>=0;i--){

            while (!stack.isEmpty() && stack.peek()<=a[i]){
                stack.pop();
            }
            stack.push(a[i]);

        }

        for(int i=n-1;i>=0;i--){

            while (!stack.isEmpty() && stack.peek()<=a[i]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                greater[i]=stack.peek();
            }else{
                greater[i]=-1;
            }
            stack.push(a[i]);

        }

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
