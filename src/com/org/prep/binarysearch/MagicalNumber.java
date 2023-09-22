package com.org.prep.binarysearch;

public class MagicalNumber {
    public static void main(String[] args){
       System.out.println( solve(807414236,3788,38141));
    }

    public static int solve(int A, int B, int C) {
        long l=1;
        long h=Math.min(B,C)*Long.valueOf(A);
        long lcm=(B*C)/gcd(B,C);
        long ans=-1;
        while(l<=h){
            long m=(l+h)/2;

            int magical=(int)(m/B)+(int)(m/C)-(int)(m/lcm);
            if(magical<A){
                l=m+1;
            }else{
                ans=m;
                h=m-1;
            }

        }
        return (int)(ans%1000000007);
    }
    public static int gcd(int A,int B){

        if(B==0) return A;
        return gcd(B,A%B);
    }
}
