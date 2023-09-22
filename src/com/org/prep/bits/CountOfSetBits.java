package com.org.prep.bits;

import java.util.ArrayList;
import java.util.List;

public class CountOfSetBits {
    public static void main(String[] args){
        System.out.println(countSetBits(11));
        List<Integer> list=new ArrayList<>();

    }

    public static int countSetBits1(int n) {
        long a[]=new long[n+1];
        long count=0;
        for(int i=1;i<=n;i++){
            a[i]=Long.valueOf(a[(i>>1)]+(i%2));
            count=(count%1000000007+a[i]%1000000007)%1000000007;

        }
        return (int)count%1000000007;
    }

        public static int count=0;
    public static int countSetBits(int n){
        int mod=1000000007;
        if(n==0){
            return 0;
        }

        long x= powerof2nearbyN(n);
        long first=(1<<(x-1))*x;
        long second=(n-(1<<x)+1);
        int rest=(n-(1<<x));
        long ans=(first%mod+second%mod+Long.valueOf(countSetBits(rest))%mod)%mod;
        return (int)ans%mod;

    }
    public static long powerof2nearbyN(int n){

        int x=0;
        int val=1;
        while((1<<x)<=n){

            x++;

        }
        return Long.valueOf(x-1);
    }
}
