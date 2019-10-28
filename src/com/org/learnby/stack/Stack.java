package com.org.learnby.stack;

public class Stack {
    public int arr[];
    public int maxSize;
    public int top;

    public Stack(){
        maxSize=10;
        arr=new int[maxSize];
        top=-1;
    }
    public void push(int data){
            if(!isFull()){
                arr[++top]=data;
            }
    }
    public int  pop(){
        int popData=0;
        if(!isEmpty()){
            popData=arr[top--];
           // System.out.println("Poped data is = "+popData);
        }
        return popData;
    }
    public int peek(){
        if(top>=0) {
            return arr[top];
        }else{
            return -1;
        }


    }
    public boolean isEmpty(){
        if(top==-1){
            return true;
        }
        else
            return false;

    }
    public boolean isFull(){
        if(top==maxSize){
            return true;
        }else{
            return false;
        }

    }
    public int size(){
        return top;
    }
}
