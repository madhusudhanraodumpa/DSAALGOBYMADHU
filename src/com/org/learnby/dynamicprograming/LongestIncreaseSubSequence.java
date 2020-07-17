package com.org.learnby.dynamicprograming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class LongestIncreaseSubSequence {
    public static void main(String args[]) {
        int a[] = {7, 1, 4, 8, 11, 2, 14, 3};
        System.out.println(LIS(a));
        System.out.println(longestIncreasingSubSequence(a));
        System.out.println(longestIncreasingSubSequenceOpt(a));


    }

    private static int LIS(int[] a) {
        int b[] = new int[a.length];
        int maxLen = 1;
        Arrays.fill(b, 1);
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i] && b[j] + 1 > b[i]) {
                    b[i] = b[j] + 1;
                    maxLen = Math.max(maxLen, b[i]);
                }
            }
        }
        return maxLen;
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

    public static int longestIncreasingSubSequence(int input[]) {
        int T[] = new int[input.length];
        int R[] = new int[input.length];
        Arrays.fill(R, -1);
        T[0] = 0;
        int len = 0;
        for (int i = 1; i < input.length; i++) {
            if (input[T[0]] > input[i]) { //if input[i] is less than 0th value of T then replace it there.
                T[0] = i;
            } else if (input[T[len]] < input[i]) { //if input[i] is greater than last value of T then append it in T
                len++;
                T[len] = i;
                R[T[len]] = T[len - 1];
            } else { //do a binary search to find ceiling of input[i] and put it there.
                int index = ceilIndex(input, T, len, input[i]);
                T[index] = i;
                R[T[index]] = T[index - 1];
            }
        }

        //this prints increasing subsequence in reverse order.
        System.out.print("Longest increasing subsequence ");
        int index = T[len];
        while (index != -1) {
            System.out.print(input[index] + " ");
            index = R[index];
        }

        System.out.println();
        return len + 1;
    }

    private static int ceilIndex(int input[], int T[], int end, int s) {
        int start = 0;
        int middle;
        int len = end;
        while (start <= end) {
            middle = (start + end) / 2;
            if (middle < len && input[T[middle]] < s && s <= input[T[middle + 1]]) {
                return middle + 1;
            } else if (input[T[middle]] < s) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        return -1;
    }
}
