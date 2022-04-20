package com.org.prep.recursion;

public class Print1toN {
    public  static void main(String args[]){
        print1toN(10);
        System.out.println();
        System.out.println(facrtorial(5));
    }
    public static void print1toN(int n){

        if(n == 1){
            System.out.print(" "+n);
            System.out.println();
          //  System.out.print(" "+n);

            return;
        }
       // System.out.print(" "+n);

        print1toN(n-1);
        System.out.print(" "+n);



    }
    public static int facrtorial(int n){


        if(n==0) return 1;

        return n*facrtorial(n-1);
    }
}
