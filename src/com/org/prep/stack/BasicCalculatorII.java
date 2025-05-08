package com.org.prep.stack;

import java.util.Stack;

public class BasicCalculatorII {
    public static void main(String[] args) {
        String s="3+2*2";
        System.out.println(calculate(s));

    }
    public static int calculate(String s) {
        Stack<Integer> stack= new Stack<>();

        Character sign='+';
        int sum=0;
        for(int i=0;i<s.length();i++){

            if(Character.isDigit(s.charAt(i))){
                int val=0;
                while (i<s.length() && Character.isDigit(s.charAt(i))){
                    val=val*10+(s.charAt(i)-'0');
                    i++;
                }
                i--;
                if(sign=='+'){
                    stack.push(val);
                }
                else if(sign=='-'){
                    stack.push(-val);
                }
                else if(sign=='*'){

                    int a=stack.pop();
                    int ans=a*val;
                    stack.push(ans);
                }
                else if(sign=='/'){

                    int a=stack.pop();
                    int ans=a/val;
                    stack.push(ans);
                }
            }
            else if(s.charAt(i)!=' '){
                sign=s.charAt(i);
            }


        }

        while(!stack.isEmpty()){
            sum+=stack.pop();
        }

        return sum;
    }
}
