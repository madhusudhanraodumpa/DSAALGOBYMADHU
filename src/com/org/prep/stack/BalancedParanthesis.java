package com.org.prep.stack;

import java.util.Stack;

public class BalancedParanthesis {
    public static void main(String[] args) {
        System.out.println(solve("))))))))"));

    }
    public  static int solve(String A) {
        int n=A.length();
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<n;i++){
            char ch=A.charAt(i);
            if(A.charAt(i)=='(' ||  A.charAt(i)=='{' || A.charAt(i)=='['){
                stack.push(A.charAt(i));
            }else if(!stack.isEmpty()){
                if(A.charAt(i)=='}' && stack.peek()=='{'){
                    stack.pop();
                }
                else if(A.charAt(i)==')' && stack.peek()=='('){
                    stack.pop();
                }
                else if(A.charAt(i)==']' && stack.peek()=='['){
                    stack.pop();
                }

            }else {
                stack.push(ch);
            }









        }
        if(stack.isEmpty()) return 0;
        return 1;


    }
}
