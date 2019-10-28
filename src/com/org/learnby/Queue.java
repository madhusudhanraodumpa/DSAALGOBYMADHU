package com.org.learnby;

public class Queue {
    public static int front=0,rear=-1;
    public static int maxSize=10;
    static int a[]=new int[maxSize];
    public static void main(String args[]){

    }
    public static void enQueue(int x){
        if(!queueIsFull()) {

            a[++rear] = x;
        }
    }
    public static void deQueue(){
        int data=Integer.MIN_VALUE;
        if(!queueIsEmpty()) {
            int y = a[front++];
        }
    }
    public static boolean queueIsFull(){
        return (rear==(maxSize-1));
    }
    public static boolean queueIsEmpty(){
        return (rear==-1 || front==(maxSize)|| front>rear);
    }
}
