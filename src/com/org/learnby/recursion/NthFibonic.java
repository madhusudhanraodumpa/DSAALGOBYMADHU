package com.org.learnby.recursion;

public class NthFibonic {
    public static void main(String args[])
    {
        System.out.println("Nth finonic number is: = "+f(6));
    }

    private static int f(int n) {
        if(n==0 || n==1){
            return n;
        }
        int f1=f(n-1);
        int f2=f(n-2);
        return f1+f2;
    }
}
