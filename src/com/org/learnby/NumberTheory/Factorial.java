package com.org.learnby.NumberTheory;

import java.math.BigInteger;

public class Factorial {

    public static void main(String args[]){
        int n=1000;
        BigInteger fact= new BigInteger("1");
        for(int i=1;i<=n;i++){
            fact=fact.multiply(BigInteger.valueOf(i));
        }
        System.out.println(fact);
    }
}
