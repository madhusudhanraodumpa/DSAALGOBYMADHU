package com.org.prep.recursion;

public class MagicNumber {
    public static void main(String args[]){
        System.out.println(solve(83557));
    }

    public static int solve(int A) {

        if(A==0) return 0;

        int x= A%10+solve(A/10);
        if(x>=10){
            return solve(x);
        }else{
            if(x==1) return 1;
            else return 0;
        }



    }
}
