package com.org.learnby.queue;

public class QueueAdvanced {
    int maxSize;
    int arr[];
    int front,rear,size;

    public QueueAdvanced(int maxSize){
        this.maxSize=maxSize;
        arr=new int[maxSize];
        this.front=this.size=0;
        this.rear=maxSize-1;
    }
    public boolean isFull(){
        return this.size==maxSize;
    }
    public boolean isEmpty(){
        return this.size==0;
    }
    public void enQueue(int data){
        if(!isFull()){
            rear=(rear+1)%maxSize;
            arr[rear]=data;
            size=size+1;
        }else{
            rear=(rear+1)%maxSize;
            arr[rear]=data;
            front=front+1%maxSize;
        }
    }
    public int  deQueue(){
        if(!isEmpty()){
            int item=arr[front];
            front=(front+1)%maxSize;
            size=size-1;
            return item;
        }else {
            return 0;
        }
    }

    public int size(){
        return size;
    }


}
