package com.org.leetcode.heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharactersByFrequency_451 {
    public static void main(String args[]) {
        System.out.println(frequencySort("trzz"));
    }

    public static String frequencySort(String s) {
        /*Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
        pq.addAll(map.entrySet());

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> e = pq.poll();
            for (int i = 0; i < e.getValue(); i++) {
                sb.append(e.getKey());
            }

        }
        return sb.toString();*/

        if (s.length() <= 1)
            return s;

        int[] map = new int[128];
        char[] array = s.toCharArray();

        for (char c: array) {
            map[c]++;
        }

        char[] results = new char[s.length()];

        for(int i = 0; i < s.length(); ) {
            int max = 0;
            int index = 0;

            for (int j = 0; j < 128; j++) {
                if (map[j] > max) {
                    max = map[j];
                    index = j;
                }
            }

            while (map[index] > 0) {
                results[i++] = (char) index;
                map[index]--;
            }
        }
        return new String(results);
    }
}

