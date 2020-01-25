package com.org.leetcode.stack;

import java.util.Stack;

public class ValidateStackSequences_946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed.length!=popped.length)
            return false;
        int i=0,j=0;
        int len=0;
        Stack<Integer> stack=new Stack<>();
        while(len<pushed.length){
            stack.push(pushed[i]);
            while(!stack.isEmpty() && stack.peek()==popped[j]){
                stack.pop();
                j++;
            }
            i++;
            len++;
        }
        while (!stack.isEmpty()){
            if(stack.pop()==popped[j]){
                j++;
            }else{
                return false;
            }
        }
        return true;

    }
    public static void main(String args[]){
        int[] pushed={2,1,0};
        int[] poped={1,2,0};
        ValidateStackSequences_946 v=new ValidateStackSequences_946();
        System.out.println(v.validateStackSequences(pushed,poped));
    }
}
