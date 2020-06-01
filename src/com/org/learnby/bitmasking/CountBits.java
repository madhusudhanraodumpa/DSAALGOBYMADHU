package com.org.learnby.bitmasking;

public class CountBits {
    public static void main(String args[]) {
            System.out.println(countBits(15));
        System.out.println(countBits1(15));

    }

    private static int countBits(int n) {
        int ans=0;
        while(n>0){
        ans+= (n & 1);
        n=n>>1;
        }
        return ans;
    }

    private static int countBits1(int n) {
        int ans=0;
        while(n>0){
            n=(n & (n-1));
            ans++;
        }
        return ans;
    }
}
