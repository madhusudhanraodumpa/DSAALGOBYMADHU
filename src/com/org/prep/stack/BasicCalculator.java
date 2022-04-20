package com.org.prep.stack;

import java.util.Stack;

public class BasicCalculator {
    public static void main(String args[]){

    }
    public static int calculate(String s){

        Stack<Integer> stack= new Stack<>();

        int sign=1;
        int sum=0;
        for(int i=0;i<s.length();i++){

            if(Character.isDigit(s.charAt(i))){
                int val=0;
                while (i<s.length() && Character.isDigit(s.charAt(i))){
                    val=val*10+(s.charAt(i)-'0');
                    i++;
                }
                i--;
                val=val*sign;
                sign=1;
                sum+=val;
            }
            else if(s.charAt(i) == '('){
                stack.push(sum);
                stack.push(sign);
                sum=0;
                sign=+1;
            }
            else if(s.charAt(i) == ')'){
                sum*= stack.pop();
                sum+=stack.pop();
            }
            else if(s.charAt(i)=='-'){
                sign*=-1;
            }




        }

        return sum;

    }
}
