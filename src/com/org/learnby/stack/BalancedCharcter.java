package com.org.learnby.stack;

import java.util.Stack;

public class BalancedCharcter {
    public static void main(String args[]){
        String balancedString="{([])()}";
        boolean answer=false;
        Stack st=new Stack<>();
        for(int i=0;i<balancedString.length();i++){
            char cha=balancedString.charAt(i);
            if(cha == '{' || cha == '[' || cha == '(') {
                st.push(cha);
            }
            if(cha == '}' || cha == ']' || cha == ')'){
                if(st.isEmpty()){
                    answer=false;
                    break;
                }
                int size=st.size();
                char inchar=(char)st.pop();
                answer=checkBalance(cha,inchar);
            }
        }
        System.out.println(answer && st.isEmpty());


    }

    private static boolean checkBalance(char cha, char inchar) {
        if(cha==')' && inchar=='('){
            return true;
        }else if(cha==']' && inchar=='['){
            return true;
        }else if(cha=='}' && inchar=='{'){
            return true;
        }else{
            return false;
        }
    }
}
