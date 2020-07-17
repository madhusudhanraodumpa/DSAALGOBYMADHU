package com.org.learnby.dynamicprograming;

public class FibonicConstantSpace {
    public static void main(String args[]){
        int a[]=new int[10];
        System.out.println(fibonic(7));
    }

    //constant space approch.
    public static int fibonic(int n){
       int a=0;
       int b=1;
       if (n<2){
           return n;
       }
       int c=0;
       for(int i=2;i<=n;i++){
           c=a+b;
           a=b;
           b=c;
       }
       return c;
    }
}
