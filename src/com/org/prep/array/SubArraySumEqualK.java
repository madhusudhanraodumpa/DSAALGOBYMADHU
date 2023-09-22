package com.org.prep.array;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualK {
    public static void main(String args[]){
        int a[]={3,9,-2,4,1,-7,2,6,-5,8,-3,-7,6,2,1
        };
        subarraySum1(a,5);
    }
    public static int subarraySum1(int[] a, int k) {
        int n = a.length;
        Map<Integer, Integer> m = new HashMap<>();
        int count = 0;
        //m.put(0,1);
        int preSum = 0;
        for (int i = 0; i < n; i++) {
            preSum = preSum + a[i];
            if (preSum == k) {
                count++;
            }
            if (m.containsKey(preSum - k)) {
                count = m.get(preSum - k) + count;
            }
            m.put(preSum, m.getOrDefault(preSum, 0) + 1);

        }
        return count;
    }

    public static int subarraySum(int[] a, int k) {
        int count = 0, prefix_sum = 0;
        HashMap< Integer, Integer > map = new HashMap < > ();
        map.put(0, 1);
        for (int i = 0; i < a.length; i++) {
            prefix_sum =prefix_sum + a[i];
            if (map.containsKey(prefix_sum - k))
                count = count + map.get(prefix_sum-k);
            map.put(prefix_sum, map.getOrDefault(prefix_sum, 0) + 1);
        }
        return count;
    }
}
