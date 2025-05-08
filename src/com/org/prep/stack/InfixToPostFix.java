package com.org.prep.stack;

import java.util.*;

public class InfixToPostFix {
    public static void main(String[] args) {
        System.out.println(solve("a*(r+o*h)"));
    }

    public static Map<Character,Integer> map=new HashMap<>();
    static{
        map.put('^',3);
        map.put('*',2);
        map.put('/',2);
        map.put('+',1);
        map.put('-',1);
        map.put('(',4);

    }
    public static String solve(String A) {
        int n=A.length();
        Stack<Character> stack=new Stack<>();
        String ans="";

        for(int i=0;i<n;i++){
            char ch=A.charAt(i);
            if(ch=='('){
                stack.push(ch);
            }else if(ch==')'){
                while(!stack.isEmpty() && stack.peek()!='('){
                    ans=ans+stack.peek();
                   stack.pop();
                }
                stack.pop();
            }else if(ch=='*' || ch=='/' || ch=='+' || ch=='-' || ch=='^'){

                while(!stack.isEmpty() && stack.peek()!='(' && checkPirority(ch,stack.peek())){
                    ans=ans+stack.peek();
                    stack.pop();
                }
                stack.push(ch);


            }else{
                ans=ans+ch;
            }

        }
        while(stack.isEmpty()){
            ans=ans+stack.peek();
            stack.pop();
        }
        return ans;
    }
    public static boolean checkPirority(char c1, char c2){

        if(map.get(c1)<=map.get(c2)){
            return true;
        }
        return false;



    }
}
