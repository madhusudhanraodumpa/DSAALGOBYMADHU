package com.org.prep.sliding;

public class MaxConsecutiveOnesIII {

    public static void main(String args[]) {
        int a[] = {1,1,1,0,0,0,1,1,1,1,0};
        System.out.println(longestOnes(a, 2));
    }

    public static int longestOnes(int[] a, int k) {
        int start = 0;
        int end = 0;
        int maxConsecutive = Integer.MIN_VALUE;
        int zeroCount = 0;

        while (end < a.length) {
            if (a[end] == 0) {
                zeroCount++;
            }

            while (zeroCount > k) {

                if (a[start] == 0) {
                    zeroCount--;
                }
                start++;
            }
            maxConsecutive = Math.max(maxConsecutive, end - start + 1);
            end++;


        }
        return maxConsecutive;
    }
}
