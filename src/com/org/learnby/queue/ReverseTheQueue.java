package com.org.learnby.queue;

import com.org.learnby.stack.Stack;

public class ReverseTheQueue {
    public static void main(String args[]) {
        QueueAdvanced q1 = new QueueAdvanced(6);
        int k = 3;
        int a[] = {10, 20, 30, 40, 50, 60};//30,20,10,40,50,60
        for (int i : a) {
            q1.enQueue(i);
        }
        Stack st = new Stack();
        for (int i = 0; i < k; i++) {
            st.push(q1.deQueue());
        }
        while (!st.isEmpty()) {
            q1.enQueue(st.pop());
        }
        for(int j=0;j<q1.size()-k;j++){
            q1.enQueue(q1.deQueue());
        }
        while(!q1.isEmpty()){
            System.out.println(q1.deQueue());
        }

    }
}
