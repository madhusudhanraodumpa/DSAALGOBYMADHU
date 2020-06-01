package com.org.learnby.bitmasking;

public class FastExponantion {
    public static  void main(String args[]){
        System.out.println(power(2,21));
    }

    private static int power(int a, int n) {
        int ans=1;
        while(n>0){
            if((n & 1) == 1){
                ans=ans*a;
            }
            a*=a;
            n = n>>1;
        }
        return ans;
    }
}
