package com.org.prep.bits;

public class CheckBits {

    public static void main(String[] args){
        System.out.println(checkBits(150,2));

    }
    public static boolean checkBits(int n,int i){


        //return (((n>>i)&1)==1);
         return (n & (1 << i)) != 0;
    }
}
