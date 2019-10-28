package com.org.learnby.queue;

import com.org.learnby.stack.Stack;

public class CreateQueueUsingTwoStacks {
    public static void main(String args[]){
        int a[]={1,2,3,4,5};
     //   USingTwoStacksEnQueueCostly q1=new USingTwoStacksEnQueueCostly();
     //  USingTwoStacksDeQueueCostly q1=new USingTwoStacksDeQueueCostly();
       UsingSingleStackAndRecursion q1=new UsingSingleStackAndRecursion();
        for(int i:a){
            q1.enQueue(i);
        }
        System.out.println(q1.deQueue());
        q1.enQueue(6);
        System.out.println(q1.deQueue());
        System.out.println(q1.deQueue());
        System.out.println(q1.deQueue());
        System.out.println(q1.deQueue());
        System.out.println(q1.deQueue());

    }
}
class UsingSingleStackAndRecursion{
    Stack st1=new Stack();
    int res=0;
    public void enQueue(int data){
        st1.push(data);
    }
    public int deQueue(){
        if(st1.isEmpty()){
            System.exit(0);
        }
       if(st1.size()==0){
         return st1.pop();
       }else{
           int x=st1.pop();
           res=deQueue();
           st1.push(x);
           return  res;
       }
    }
}

class USingTwoStacksDeQueueCostly{
    Stack st1=new Stack();
    Stack st2=new Stack();
    public void enQueue(int data){
        st1.push(data);
    }
    public int deQueue(){
        if(st2.isEmpty()) {
            while (!st1.isEmpty()) {
                st2.push(st1.pop());
            }
            return st2.pop();
        }else{
            return st2.pop();
        }
    }
}


class USingTwoStacksEnQueueCostly{
    Stack st1=new Stack();
    Stack st2=new Stack();


    public void enQueue(int data){
        if(st1.isEmpty()){
            st1.push(data);
        }else{
            while(!st1.isEmpty()){
                st2.push(st1.pop());
            }
            st1.push(data);
            while(!st2.isEmpty()){
                st1.push(st2.pop());
            }
        }

    }
    public int  deQueue(){
        return st1.pop();

    }

}
