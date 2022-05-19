package com.org.prep.array;

import java.util.HashMap;
import java.util.Map;

public class KDifferentPairs {
        public static void main(String args[]){
            int[] a={1,-3,4,-5,4,-2,2,-4,3,2,2,3,1};
            findPairs(a,-2);
        }


    public static int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int count = 0;
        for(int x : map.keySet()){
            if(k !=0 && map.containsKey(x + k) || k == 0 && map.get(x) > 1) count++;
        }
        return count;
    }
}
