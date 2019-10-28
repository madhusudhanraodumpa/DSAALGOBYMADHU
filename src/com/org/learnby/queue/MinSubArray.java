package com.org.learnby.queue;

public class MinSubArray {

    public static void main(String args[]){
        int[] a={1,4,45,6,0,19};
        int element=51;
                int minValue=10;
int sum=0;
        int front=0;
                int rear=0;
        int i=0;
        while(i<a.length){
            sum=sum+a[i];
            while(sum>element && rear<i){
                rear++;
            }

            while(sum<element && front<rear){
                sum=sum-a[front];
                front++;
                minValue=(minValue>rear-front+1)?minValue:rear-front+1;

            }
            i++;
        }

        System.out.println(minValue);
    }
}
