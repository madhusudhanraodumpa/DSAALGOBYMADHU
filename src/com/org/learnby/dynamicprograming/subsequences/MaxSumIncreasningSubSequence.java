package com.org.learnby.dynamicprograming.subsequences;

public class MaxSumIncreasningSubSequence {
        public static void main(String args[]) {
            int a[] = {7, 1, 4, 8, 11, 2, 14, 3};
            System.out.println(maxSum(a));
            //  System.out.println(longestIncreasingSubSequenceOpt(a));


        }

        private static int maxSum(int[] a) {
            int mis[] = new int[a.length];

            for (int i = 0; i < a.length; i++) {
                mis[i]=a[i];
            }
            int maxSum = a[0];
            for (int i = 1; i < a.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (a[j] < a[i] && a[i]+mis[j]>mis[i]) {
                        mis[i] = a[i] + mis[j];
                        maxSum = Math.max(maxSum, mis[i]);
                    }
                }
            }
            return maxSum;
        }


}
