package com.org.leetcode.stack;

import java.util.Stack;

public class OnlineStockSpan_901 {
    Stack<Integer> prices, weights;
    public OnlineStockSpan_901() {
        prices = new Stack();
        weights = new Stack();
    }

    public int next(int price) {
        int w=1;
        while (!prices.isEmpty() && prices.peek()<=price){
            prices.pop();
            w+=weights.pop();
        }
        prices.push(price);
        weights.push(w);
        return w;
    }
    public static void main(String rags[]){
        OnlineStockSpan_901 o=new OnlineStockSpan_901();
      /*  System.out.print(o.next(100));
        System.out.print(o.next(80));
        System.out.print(o.next(60));
        System.out.print(o.next(70));
        System.out.print(o.next(60));
        System.out.print(o.next(75));
        System.out.print(o.next(85));*/
        int[] arr={100,80,60,70,60,75,85,85};
        o.span(arr);
        System.out.println();
        o.span1(arr);

    }
    public void  span(int prices[]) {
        int i=0;
        Stack<Integer> st=new Stack<>();
        while(i<prices.length){
             if(st.isEmpty() || prices[i]<prices[st.peek()]){
                System.out.print(1+" ");
            }else{
                 while (prices[i]>=prices[st.peek()]){
                     st.pop();
                 }
                 System.out.print((i-st.peek())+" ");
             }
             st.push(i);
             i++;
        }

    }
    public void  span1(int prices[]) {
        int i=0;
        int span[]=new int[prices.length];
        Stack<Integer> st=new Stack<>();
        while(i<prices.length){
            while (!st.isEmpty() && prices[i]>=prices[st.peek()]){
                st.pop();
            }
            System.out.print((st.isEmpty()?(i-(-1)):(i-st.peek()))+" ");
            span[i]=st.isEmpty()?(i-(-1)):(i-st.peek());
            st.push(i);
            i++;
        }

        for(int k=0;k<span.length;k++){
            System.out.println(span[k]);
        }
    }
}
