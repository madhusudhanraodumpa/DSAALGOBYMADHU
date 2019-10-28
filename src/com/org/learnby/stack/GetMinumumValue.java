package com.org.learnby.stack;

public class GetMinumumValue {
    public static void main(String args[]){
        StackGetMinC stackGetMinC=new StackGetMinC();
        int arr[]={8,3,7,6,4,9,1,13};
        for(int i:arr){
            stackGetMinC.push(i);
        }
        stackGetMinC.pop();
        stackGetMinC.pop();

        System.out.println("Min value from stack is = "+stackGetMinC.peek());
    }
}
class StackGetMinC{
    Stack st1=new Stack();
    Stack minStack=new Stack();
    public void push(int data){
        if(st1.isEmpty()){
            st1.push(data);
            minStack.push(data);
        }else{
            st1.push(data);
            if(data<minStack.peek()){
                minStack.push(data);
            }
        }

    }
    public void pop(){

        int data=st1.pop();
        if(data==minStack.peek()){
            minStack.pop();
        }
    }
    public int peek(){
    return minStack.peek();
    }
}
