package com.org.learnby.stack;

import java.util.Stack;

public class StockSpanProblem {
    public static void main(String[] args){
        Stack<Integer> st=new Stack<>();
        Stack<Integer> st1=new Stack<>();
        int a[]={100,80,60,70,60,75,85};
       /* for(int i:a){
            if(st.isEmpty()){
                st.push(i);
                System.out.print(1);
            }else{
                if(st.peek()>i){
                    st.push(i);
                    System.out.print(1);
                }else{
                    int count=1;
                    while(st.peek()<i){
                        st1.push(st.pop());
                        count++;
                    }
                    System.out.print(count);
                    st.push(i);
                    while(!st1.isEmpty()){
                        st.push(st1.pop());
                    }
                }
            }
        }*/
        System.out.print("");
        stockSpan();

    }
    static void stockSpan(){
        Stack<Integer> st=new Stack<>();
        int a[]={100,80,60,70,60,75,85};

        for(int i=0;i<a.length;i++){
            if(st.isEmpty()){
                st.push(i);
                System.out.print(1);
            }else{
                while(!(a[st.peek()]>a[i])){
                    st.pop();
                }
                System.out.print(i-st.peek());
                st.push(i);
            }
        }

    }
}
