package com.org.prep.recursion;

public class KthSymbol {

    public static void main(String args[]){
        System.out.println(solve(5,10));
    }


    public static int solve(int A, int B) {

        if(B==0) return 0;
        int val=solve(A-1,B/2);
        if(B%2==0){
            return val;
        }else{
            return 1-val;
        }
    }
}
