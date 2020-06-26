package com.org.learnby.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PrintAllSubArraysWithZero {

    static class Postion {
        int start;
        int end;

        public Postion(int start, int end) {
            this.end = end;
            this.start = start;
        }
    }

    public static void main(String args[]) {
        int[] a = {4, -3, 1, -2, 3, 2, -1, -5, 1, 6, -1, -1};
        List<Postion> list = new ArrayList<>();
        prinSubarrays(a, a.length, list);
        for (Postion p : list) {
            System.out.println("Subarray indes strat from " + p.start + " to end " + p.end);
        }

    }

    private static void prinSubarrays(int[] a, int n, List<Postion> list) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += a[i];
            if (a[i] == 0) {
                Postion p = new Postion(i, i);
                list.add(p);
            }
            if (sum == 0) {
                Postion p = new Postion(0, i);
                list.add(p);

            }
            List<Integer> l = new ArrayList<>();
            if (map.containsKey(sum)) {

                l = map.get(sum);

                for (int j = 0; j < l.size(); j++) {
                    Postion p = new Postion(l.get(j) + 1, i);
                    list.add(p);
                }
            }
            l.add(i);
            map.put(sum, l);


        }


    }

}
