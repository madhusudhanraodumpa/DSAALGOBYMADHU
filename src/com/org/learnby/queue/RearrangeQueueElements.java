package com.org.learnby.queue;

import com.org.learnby.stack.Stack;

public class RearrangeQueueElements {
    public static void main(String args[]){
        int a[]={11,12,13,14,15,16,17,18,19,20};
        QueueAdvanced q1=new QueueAdvanced(a.length);
        for(int i:a){
            q1.enQueue(i);
        }

        int halfsize=q1.size/2;
        Stack st=new Stack();
        for(int i=0;i<halfsize;i++){
            st.push(q1.deQueue());
        }
        while(!st.isEmpty()){
            q1.enQueue(st.pop());
        }
        for(int j=0;j<halfsize;j++){
            q1.enQueue(q1.deQueue());
        }
        for(int k=0;k<halfsize;k++){
            st.push(q1.deQueue());
        }

        while(!st.isEmpty()){
            q1.enQueue(st.pop());
            q1.enQueue(q1.deQueue());
        }

        while(!q1.isEmpty()){
            System.out.println(q1.deQueue());
        }






    }
}
