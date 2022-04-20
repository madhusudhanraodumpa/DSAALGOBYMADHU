package com.org.learnby;

public class Test {
    public static void main(String args[]){
        String s="http://facebook.com:rt=0";
        System.out.println(s.substring(0,s.indexOf(":")).toUpperCase());

    }
}
