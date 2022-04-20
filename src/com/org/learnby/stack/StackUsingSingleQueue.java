package com.org.learnby.stack;

import com.org.learnby.queue.QueueAdvanced;

public class StackUsingSingleQueue {
    public static void main(String args[]) {


        StackUsing1QueueEnQueueCostly q1 = new StackUsing1QueueEnQueueCostly();
       // StackUsing1QueueDeQueueCostly q1=new StackUsing1QueueDeQueueCostly();
        int a[] = {1, 2, 3, 4, 5};
        for (int i : a) {
            q1.push(i);
        }
        System.out.println(q1.pop());
       // q1.push(6);
        System.out.println(q1.pop());
        System.out.println(q1.pop());
        System.out.println(q1.pop());
        System.out.println(q1.pop());
        System.out.println(q1.pop());


    }

}

class StackUsing1QueueEnQueueCostly {
    QueueAdvanced q1 = new QueueAdvanced(5);
    int size = 1;

    public void push(int data) {
        if (q1.isEmpty()) {
            q1.enQueue(data);
        } else {
            q1.enQueue(data);
            for (int i = 1; i < q1.size(); i++) {
                q1.enQueue(q1.deQueue());
            }
            size = size + 1;
        }
    }

    public int pop() {
        return q1.deQueue();
    }
}
   class StackUsing1QueueDeQueueCostly{
       QueueAdvanced q1 = new QueueAdvanced(5);
       int size = 0;

       public void push(int data) {
           q1.enQueue(data);
           size=size+1;
       }

       public int pop() {

           for(int i=0;i<size-1;i++) {
               q1.enQueue(q1.deQueue());
           }
           size=size-1;
           return q1.deQueue();
       }

   }

