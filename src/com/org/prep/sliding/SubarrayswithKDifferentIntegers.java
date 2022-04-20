package com.org.prep.sliding;

import java.util.HashMap;
import java.util.Map;

public class SubarrayswithKDifferentIntegers {
    public static void main(String args[]) {
        int a[] = {1, 2, 1, 2, 3};
        //System.out.println(largestSubarrayOfSumK(7, a));
        System.out.println(subarraysWithKDistinct(a, 1));
    }

    public static int subarraysWithKDistinct(int a[], int k) {
        int start = 0;
        int end = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (end < a.length) {
            map.put(a[end], map.getOrDefault(a[end], 0) + 1);

                while (map.size() > k) {
                    if (map.containsKey(a[start])) {
                        map.put(a[start], map.get(a[start]) - 1);
                        if (map.get(a[start]) == 0) {
                            map.remove(a[start]);
                        }
                    }
                    start++;
                }
           count += end-start+1;
            end++;


        }
        return count;

    }

}
