package com.org.learnby.stack;

import com.org.learnby.queue.Queue;
import com.org.learnby.queue.QueueAdvanced;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class StackUsingTwoQueues {
    public static void main(String args[]){
        int a[]={1,2,3,4,5};
      StackUsing2QueuesEneQueCostly q1=new StackUsing2QueuesEneQueCostly();
       // StackUsing2QueuesDeQueueCostly q1=new StackUsing2QueuesDeQueueCostly();
        for(int i:a){
            q1.push(i);
        }
        System.out.println(""+q1.pop());
        System.out.println(""+q1.pop());
        System.out.println(""+q1.pop());
        System.out.println(""+q1.pop());
        System.out.println(""+q1.pop());

    }


}
class StackUsing2QueuesEneQueCostly{
    QueueAdvanced q1=new QueueAdvanced(5);
    QueueAdvanced q2=new QueueAdvanced(5);

    public void push(int data){
        if(q1.isEmpty()){
            q1.enQueue(data);
            while(!q2.isEmpty()){
                q1.enQueue(q2.deQueue());
            }
        }else{
            q2.enQueue(data);
            while(!q1.isEmpty()){
                q2.enQueue(q1.deQueue());
            }
        }
    }
    public int pop(){
        if(q1.isEmpty()){
            return q2.deQueue();
        }else{
            return q1.deQueue();
        }
    }


}

class StackUsing2QueuesDeQueueCostly{
    QueueAdvanced q1=new QueueAdvanced(5);
    QueueAdvanced q2=new QueueAdvanced(5);

    public void push(int data){
        q1.enQueue(data);
    }
    public int pop(){
     if(q1.isEmpty() && q2.isEmpty()){
         return 0;
     }
     if(!q1.isEmpty()) {
         while (q1.size() != 1) {
             q2.enQueue(q1.deQueue());
         }
        return  q1.deQueue();
     }else if(!q2.isEmpty()){
         while(q2.size()!=1){
             q1.enQueue(q2.deQueue());
         }
         return q2.deQueue();
     }
     return 0;
    }
}
