package com.org.learnby.bitmasking;

public class BinaryToDecimal {
    public static void main(String args[]) {
        System.out.println(binaryToDecimal(13));
    }

    private static int binaryToDecimal(int n) {
        int p=1;
        int ans=0;
        while (n>0){
            int last_bit= (n & 1);
            n=n>>1;
            ans+=last_bit*p;
            p=p*10;
        }
        return ans;
    }
}
