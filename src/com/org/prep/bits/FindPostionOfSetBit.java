package com.org.prep.bits;

public class FindPostionOfSetBit {


    public static void main(String args[]){
    System.out.println(postionSetBit(16));
    System.out.println(findPosition(16));
    }

    public static int postionSetBit(int N){

        if(N==0) return -1;
        if((N&(N-1))==0) return (int)(Math.log(N) / Math.log(2))+1;// this is nothing but log base 2 value;
        return -1;
    }

    static boolean isPowerOfTwo(int n)
    {
        return (n > 0 && ((n & (n - 1)) == 0)) ? true : false;
    }

    // Returns position of the only set bit in 'n'
    static int findPosition(int n)
    {
        if (!isPowerOfTwo(n))
            return -1;

        int i = 1, pos = 1;

        // Iterate through bits of n till we find a set bit
        // i&n will be non-zero only when 'i' and 'n' have a set bit
        // at same position
        while ((i & n) == 0) {
            // Unset current bit and set the next bit in 'i'
            i = i << 1;

            // increment position
            ++pos;
        }

        return pos;
    }
}
