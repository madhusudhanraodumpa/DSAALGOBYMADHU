package com.org.prep.array;

public class GCD {
    public static void main(String args[]){
        gcd(15,1000000007);
    }


   static  int  gcd(int n, int m) {
        if (n%m ==0) return m;
        if (n < m) {
            int temp=n;
            n=m;
            m=temp;
        }
        while (m > 0) {
            n = n%m;
            int t=n;
            n=m;
            m=t;
        }
        return n;
    }
}
