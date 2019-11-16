package com.org.learnby.hash;

import java.util.*;
import java.util.stream.Collectors;

public class LargestSubArrayWIthSumZero {
    public static void main(String args[]) {
        int a[] = {4, -3, 1, -2, 3, 2, -1, -5, 1, 6, -1,-1};
        Map<Integer, List<Integer>> map = new HashMap<>();
        findSubarrayWithZeroSum(a, map);
        map = map.entrySet().stream().filter(e -> e.getValue().size() > 1).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        for (Map.Entry m : map.entrySet()) {
            List<Integer> l = (List<Integer>) m.getValue();
            if (l.size() == 1) {
                System.out.println("Sub array with sun zero is=" + (l.get(0) + 1) + " index to " + l.get(1));
            } else {
                for (int i = 0; i < l.size(); i++) {
                    for (int j = i + 1; j < l.size(); j++) {
                        System.out.println("Sub array with sun zero is=" + (l.get(i) + 1) + " index to " + l.get(j));
                    }

                }
            }

        }
    }

    private static void findSubarrayWithZeroSum(int[] a, Map<Integer, List<Integer>> map) {
//        map.put(a[0], Arrays.asList(0));
        int sum = 0;
        List<Integer> list = null;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            if(sum==0){
                System.out.println("Sub array with sun zero is=" + 0 + " index to " + i);

            }
            List<Integer> l = new ArrayList<>();
            if (map.containsKey(sum)) {
                l = map.get(sum);
                l.add(i);
                map.put(sum, l);
            } else {
                l.add(i);
                map.put(sum, l);
            }
        }
    }
}
