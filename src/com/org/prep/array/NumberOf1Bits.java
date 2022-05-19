package com.org.prep.array;

public class NumberOf1Bits {
    public static void main(String args[]){
        System.out.println(hammingWeight(7));
    }

    public static int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res += (n & 1);
            n = n >>> 1;
        }
        return res;
    }
}
