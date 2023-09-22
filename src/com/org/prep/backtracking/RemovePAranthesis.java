package com.org.prep.backtracking;
import java.util.*;

public class RemovePAranthesis {
    public static void main(String args[]){
        RemovePAranthesis r=new RemovePAranthesis();
        r.removeInvalidParentheses("))");

    }


    public List<String> removeInvalidParentheses(String A) {
        int m=balance(A);
        List<String> list=new ArrayList<>();
        solve(A,m,list);
        return list;
    }


    public void solve(String A,int m,List<String> list) {
        if(m==0){
            if(balance(A)==0){
                if(!list.contains(A)){
                    list.add(A);
                }
            }
            return;
        }


        for(int i=0;i<A.length();i++){
            String left=A.substring(0,i);
            String right=A.substring(i+1);
            solve(left+right,m-1,list);
        }

    }


    public int balance(String A) {
        Stack<Character> stack=new Stack<>();

        for(int i=0;i<A.length();i++){
            char ch=A.charAt(i);

            if(ch=='('){
                stack.push(ch);
            }else if (!stack.isEmpty()){
                if(ch==')' && stack.peek()=='('){
                    stack.pop();
                }
                else if(ch==')'){
                    stack.push(ch);
                }
            }else if(ch==')'){
                stack.push(ch);
            }


        }



        return stack.size();
    }
}
