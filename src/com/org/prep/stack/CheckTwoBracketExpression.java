package com.org.prep.stack;

import java.util.Stack;

public class CheckTwoBracketExpression {
    public static void main(String[] args) {
        System.out.println(solve("-(a+b+c)", "-a-b-c"));
    }



    public static int solve(String A, String B) {
        int[] v1=new int[26];
        int[] v2=new int[26];
        evaluateExpression(A,v1);
        evaluateExpression(B,v2);
        for(int i=0;i<26;i++){
            if(v1[i]!=v2[i]) return 0;
        }
        return 1;
    }
    public static boolean findSign(String str, int i)
    {
        if (i == 0)
        {
            return true;
        }
        if (str.charAt(i - 1) == '-')
        {
            return false;
        }
        return true;
    }
    public static int[] evaluateExpression(String str, int[] v)
    {
        Stack<Boolean> st = new Stack<>();
        st.push(true);

        for (int i = 0; i < str.length(); ++i)
        {
            // We keep track of the current sign, whether it is + or -
            if (str.charAt(i) == '+' || str.charAt(i) == '-')
            {
                continue;
            }

            // We maintain a boolean stack for doing so.
            // If it is true, that means character is added and if it is false, that means the character is removed.
            if (str.charAt(i) == '(')
            {
                if (findSign(str, i))
                {
                    st.push(st.peek());
                }
                else
                {
                    st.push(!st.peek());
                }
            }

            else if (str.charAt(i) == ')')
            {
                st.pop();
            }

            else
            {
                if (st.peek())
                {
                    if (findSign(str, i))
                    {
                        v[str.charAt(i) - 'a'] = 1;
                    }
                    else
                    {
                        v[str.charAt(i) - 'a'] = -1;
                    }
                }
                else
                {
                    if (!findSign(str, i))
                    {
                        v[str.charAt(i) - 'a'] =1;
                    }
                    else
                    {
                        v[str.charAt(i) - 'a'] =-1;
                    }
                }
            }
        }
        return v;
    }

}
