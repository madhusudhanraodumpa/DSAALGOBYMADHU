package com.org.learnby.heap;

import java.util.Scanner;

public class MinHeap {

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int noOfElements=sc.nextInt();
        int arr[]=new int[noOfElements];
        int sort[]=new int[noOfElements];


        MinHeap m=new MinHeap();
        int n=0;
        while(noOfElements>0){
            int element=sc.nextInt();
            m.insert(arr,n++,element);
            noOfElements--;
        }
        System.out.println();
        for(int value:arr){
            System.out.println(value);
        }
        System.out.println("Now deleting one by one elemnt from heap");
        int x=0;
        while (n>0){
            sort[x++]=arr[0];
            m.delete(arr,--n);
        }

        for(int value:sort){
            System.out.println(value);
        }



    }

    public  void delete(int[] arr, int n) {
        //  System.out.println(arr[0]);
        // sort[x]=arr[0];
        arr[0]=arr[n];
        arr[n]=0;
        n=n-1;
        int parent=0;
        while (parent<n){
            int leftChild=(2*parent)+1;
            int rightChild=(2*parent)+2;
            if(leftChild<=n && rightChild<=n) {
                int minChild = arr[leftChild] > arr[rightChild] ? rightChild : leftChild;
                if (arr[minChild] < arr[parent]) {
                    int temp = arr[parent];
                    arr[parent] = arr[minChild];
                    arr[minChild] = temp;
                    parent = minChild;
                }else{
                    break;
                }
            }else {
                if(n==1 && arr[0]>arr[1]){
                    int temp=arr[0];
                    arr[0]=arr[1];
                    arr[1]=temp;
                }
                break;
            }
        }
    }

    public void insert(int[] arr, int n, int element) {
        if (n == 0) {
            arr[n] = element;
        } else {
            arr[n] = element;
            while (n >= 0) {
                int parent = (int) Math.floor((n - 1) / 2);
                if (arr[parent] > arr[n]) {
                    int temp = arr[n];
                    arr[n] = arr[parent];
                    arr[parent] = temp;
                    n = parent;

                } else {
                    break;
                }
            }

        }
    }

    public int peek(int arr[]){
        return arr[0];
    }

}
