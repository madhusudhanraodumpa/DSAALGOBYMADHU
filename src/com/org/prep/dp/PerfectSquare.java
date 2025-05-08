package com.org.prep.dp;

public class PerfectSquare {
    public static void main(String[] args) {
        System.out.println(numSquares1(12));
    }
    public static int numSquares1(int n) {
        if(n<0) return 0;

        int min=n;
        for(int i=1;i*i<=n;i++){
            min=Math.min(min,1+numSquares1(n-(i*i)));
        }
        return min;
    }
}
