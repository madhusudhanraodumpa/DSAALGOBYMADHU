package com.org.leetcode.stack;

import java.util.Stack;

public class ValidParentheses_20 {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        boolean valid = false;
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c == '{' || c == '(' || c == '[') {
                st.push(c);
            }
            if (c == '}' || c == ')' || c == ']') {
                if (st.isEmpty()) {
                    valid = false;
                    break;
                } else {
                    valid = function(c, st);
                    if(valid) continue;;
                    return valid;

                }

            }
        }
        return st.isEmpty() && valid;
    }

    private boolean function(Character c, Stack<Character> s) {
            char ch=s.pop();
        if (c == ')' && ch == '(') {
            return true;
        } else if (c == ']' && ch == '[') {
            return true;
        } else if (c == '}' && ch == '{') {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String rags[]) {
        ValidParentheses_20 v=new ValidParentheses_20();
        System.out.println(v.isValid("{{)}"));
    }
}
