package com.org.learnby.queue;

public class QueueOperationsTesting {
    public static void main(String args[]){
        int a[]={1,2,3,4,5};
         QueueAdvanced q1=new QueueAdvanced(5);
        for(int i:a){
            q1.enQueue(i);
        }
        q1.enQueue(6);
        q1.enQueue(7);

        System.out.println(""+q1.deQueue());
        System.out.println(""+q1.deQueue());
        System.out.println(""+q1.deQueue());
        System.out.println(""+q1.deQueue());
        System.out.println(""+q1.deQueue());
        //System.out.println(""+q1.deQueue());

       /* q1.enQueue(1);
        q1.enQueue(2);

        System.out.println(""+q1.deQueue());
        System.out.println(""+q1.deQueue());*/

    }
}
