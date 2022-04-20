package com.org.prep.stack;

public class DesignStackWithIncrementOperation {
    public static void main(String args[]){
        CustomStack stack=new CustomStack(3);
        stack.push(1);
        stack.push(2);
        stack.pop();
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.increment(5,100);
        stack.increment(2,100);
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();

    }
}
class CustomStack {
    public int arr[];
    public int maxSize;
    public int top;
    public CustomStack(int maxSize) {
        this.maxSize=maxSize;
        arr=new int[maxSize];
        top=-1;
    }

    public void push(int x) {
        if(!isFull()){
            arr[++top]=x;
        }
    }

    public void pop() {
        int popData=0;
        if(!isEmpty()){
            popData=arr[top--];
            // System.out.println("Poped data is = "+popData);
        }
      //  return popData;
    }

    public void increment(int k, int val) {
        int j=0;
        while(k>0 && j<arr.length){
            arr[j]+=val;
            k--;
            j++;

        }
    }
    private boolean isEmpty(){
        if(top==-1){
            return true;
        }
        else
            return false;

    }
    private boolean isFull(){
        if(top==maxSize-1){
            return true;
        }else{
            return false;
        }

    }
}