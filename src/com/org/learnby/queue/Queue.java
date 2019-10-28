package com.org.learnby.queue;

public class Queue {

    int arr[];
    int maxSize;
    int rear;
    int front;

    public Queue(int n){
        this.maxSize=n;
       arr=new int[maxSize];
       front=0;
       rear=-1;
    }
    public void enQueue(int data){
        if(!isFull())
        arr[++rear]=data;
    }
    public int deQueue(){
        if(!isEmpty())
        return arr[front++];
        return 0;
    }
    public boolean isEmpty(){
        return (rear==-1 || front==maxSize);
    }
    public boolean isFull(){
        return (rear==(maxSize-1));
    }
    public int size(){
        return rear;
    }

}
