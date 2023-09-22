package com.org.coding;

public class Wrapper {
    public static void main(String args[]){
        Integer i=10;
        increment(i);
        System.out.println(i);
    }

    public static void increment(int x){
        x++;
        System.out.println(x);
    }
}
