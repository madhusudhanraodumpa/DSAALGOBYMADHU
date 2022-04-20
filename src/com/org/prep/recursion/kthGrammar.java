package com.org.prep.recursion;

public class kthGrammar {

    public static void main(String args[]){
        System.out.println(kthGrammar(4,3));
    }

    public static int kthGrammar(int n, int k) {
        if(n==1) return 0;
        double mid = Math.pow( 2,(n-1))/2;
        if(k<=mid){
            return kthGrammar(n-1,k);
        }else{
            return kthGrammar(n-1, (k-(int) mid));
        }

    }
}
