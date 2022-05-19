package com.org.prep.array;

import java.util.HashMap;

public class SubArraySumEqualK {
    public static void main(String args[]){
        int a[]={1,2,4,1,3,5,2,1,4
        };
        subarraySum(a,3);
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
