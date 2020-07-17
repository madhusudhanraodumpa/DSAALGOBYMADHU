package com.org.learnby.dynamicprograming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxSumIncreasingSubSequence {
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

    public static int longestIncreasingSubSequenceOpt(int input[]) {
        List<Integer> list = new ArrayList<>();
        list.add(input[0]);
        for (int i = 1; i < input.length; i++) {
            if (list.get(list.size() - 1) < input[i]) {
                list.add(input[i]);
            } else {
                int index = findLoweBound(0, list.size() - 1, input[i], list);
                list.remove(index);
                list.add(index, input[i]);

            }
        }
        return list.size();

    }

    private static int findLoweBound(int start, int end, int value, List<Integer> list) {

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (list.get(mid) >= value) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

}
