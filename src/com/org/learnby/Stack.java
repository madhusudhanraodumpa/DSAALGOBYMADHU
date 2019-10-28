package com.org.learnby;

public class Stack {

    public static int top=-1;
    static int a[]=new int[10];

    public static void main(String args[]){
    }
    public static void push(int x){
        if(!isFull()){
            a[++top]=x;
        }
    }
    public static int pop(){
        if(!isEmpty()){
            return a[top--];
        }
        return 0;
    }
    public static int peek(){
        return a[top];
    }
    public static boolean isEmpty(){
        if(top==-1){
            return true;
        }else{
            return false;
        }
    }
    public static boolean isFull(){
        if(a.length==top){
            return true;
        }else{
            return false;
        }
    }
}
