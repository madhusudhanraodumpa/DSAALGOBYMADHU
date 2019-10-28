package com.org.learnby.stack;

import java.util.Stack;

public class HistrogramRectangleUsingStack {
    public static void main(String args[]){
        int a[]={1,2,3,4,5};
        Stack<Integer> st=new Stack<>();
        int maxArea=0;
        int ans=0;
        int i=0;
        for(i=0;i<a.length;i++){
            if(st.isEmpty()){
                st.push(i);
            }else{
                if(a[st.peek()]<=a[i]){
                    st.push(i);
                }else{
                    while (!st.isEmpty() && a[st.peek()]>a[i]){
                        int popedvalue=st.pop();
                       if(!st.isEmpty()) {
                            maxArea = a[popedvalue] * (i - st.peek()-1);
                            ans = Math.max(maxArea, ans);
                        }else{
                            maxArea=a[popedvalue]*i;
                           ans = Math.max(maxArea, ans);

                       }
                    }
                    st.push(i);
                }
            }

        }
        while(!st.isEmpty()){
            int popedvalue=st.pop();
            if(!st.isEmpty()) {
                maxArea = a[popedvalue] * (i - st.peek()-1);
                ans = Math.max(maxArea, ans);
            }else{
                maxArea=a[popedvalue]*i;
                ans = Math.max(maxArea, ans);

            }
        }
        System.out.println(ans);
    }



}
