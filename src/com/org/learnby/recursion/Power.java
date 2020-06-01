package com.org.learnby.recursion;

public class Power {
    public static void main(String args[]){
        System.out.println(power(3,4));

    }
    public static int power(int a,int b){
        if(b==0)
            return 1;
        int half_power=power(a,b/2);
        if((b & 1)==1){
            return half_power*half_power *a;
        }
        return half_power*half_power;
    }
}
