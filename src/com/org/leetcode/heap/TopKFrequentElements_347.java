package com.org.leetcode.heap;

import java.util.*;

public class TopKFrequentElements_347 {
    public static void main(String args[]) {
        int nums[] = {1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println(topKFrequent(nums, k));

    }

    public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        pq.addAll(map.entrySet());
        while (k > 0) {
            Map.Entry<Integer, Integer> e = pq.poll();
            list.add(e.getKey());
            --k;
        }
        return list;
    }
}
