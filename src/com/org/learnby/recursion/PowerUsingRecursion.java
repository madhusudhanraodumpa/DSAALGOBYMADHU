package com.org.learnby.recursion;

public class PowerUsingRecursion {
    public static void main(String args[]){
        System.out.println(power(2,4));
    }
    private static int power(int a,int b){

        if(b==0) return 1;

        int smallAns=power(a,b/2);
        smallAns*=smallAns;
        if((b & 1)==1){
            return a*smallAns;
        }
        return smallAns;
    }
}
