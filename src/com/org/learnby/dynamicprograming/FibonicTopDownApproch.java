package com.org.learnby.dynamicprograming;

public class FibonicTopDownApproch {
    public static void main(String args[]){
        int a[]=new int[10];
        System.out.println(fibonic(a,7));
    }

    //Recursion and Memorization using top down approch
    public static int fibonic(int a[],int n){
        if(n<2){
            return n;
        }
        if(a[n]==0){
            a[n]=fibonic(a,n-1)+fibonic(a,n-2);
        }
        return a[n];

    }
}
