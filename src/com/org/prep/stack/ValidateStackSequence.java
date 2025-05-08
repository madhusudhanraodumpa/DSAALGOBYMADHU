package com.org.prep.stack;

import java.util.Stack;

public class ValidateStackSequence {
    public static void main(String[] args) {
        int a[]={2,1,0};
        int b[]={1,2,0};
        System.out.println(validateStackSequences(a,b));
    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        int n=pushed.length;
        Stack<Integer> stack=new Stack<>();
        int j=0;
        for(int i=0;i<n;i++){
            boolean flag=true;
            while(!stack.isEmpty() && pushed[i]==popped[j]){

                j++;
               flag=false;
            }
            if(flag)
            stack.push(pushed[i]);

        }
        while(j<n && !stack.isEmpty() && stack.peek()==popped[j]){
            stack.pop();
            j++;
        }
        return stack.isEmpty();

    }
}
