package com.org.learnby.queue;

import java.util.LinkedList;
import java.util.Stack;

public class InterchangeElements {

    public static void main (String args[]){

        int a[]={1,2,3,4,5,6,7,8};

        Stack<Integer> st=new Stack<>();
        java.util.Queue<Integer> q=new LinkedList<>();

        int size=8;
        int n=size/2;

        for(int i=0;i<size;i++){
            q.add(a[i]);
        }
        for(int j=0;j<n;j++){
            st.push(q.poll());
        }
        while(!st.isEmpty()){
            q.offer(st.pop());
        }

        for(int j=0;j<n;j++){
            q.add(q.poll());
        }

        for(int k=0;k<n;k++){
            st.push(q.poll());
        }

        while(!st.isEmpty()){
            q.offer(st.pop());
            q.offer(q.poll());
        }
        while(!q.isEmpty()){
            System.out.print(" "+q.poll());
        }
        System.out.println();


    }
}
