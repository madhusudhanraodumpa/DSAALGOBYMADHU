package com.org.prep.bits;

public class MinimumXXORA {

    public static void main(String args[]) {
        System.out.println(minimumXXor(3, 5));
    }

    public static int minimumXXor(int a, int b) {
        int countBits_a = countBits(a);
        int countBits_b = countBits(b);

        int remainingBits = countBits_b;

        if (remainingBits == 0) return a;

        int x = 0;
        for (int i = 31; i >= 0; i--) {

            if (((a >> i) & 1) == 1 && remainingBits > 0) {
                x = x | (1 << i);
                remainingBits--;
            }

        }
        if(remainingBits>0){
            for (int i = 0; i <31; i++) {
                if (((x >> i) & 1) == 0 && remainingBits > 0) {
                    x = x | (1 << i);
                    remainingBits--;
                }
            }
        }


        return x;


    }

    public static int countBits(int n) {
        int count = 0;

        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;

        }
        return count;
    }
}
