package com.org.prep.sliding;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public static void main(String args[]) {
        String str = "totmtaptat";
        String ptr = "tta";
        System.out.println(minWindow(str, ptr));
    }

    private static String minWindow(String str, String ptr) {
        int start = 0;
        int end = 0;

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < ptr.length(); i++) {
            map.put(ptr.charAt(i), map.get(ptr.charAt(i)) != null ? map.get(ptr.charAt(i)) + 1 : 1);
        }
        int count = map.size();
        int minWindow = Integer.MAX_VALUE;
        String minWindowString = "";
        while (end < str.length()) {

            if (map.containsKey(str.charAt(end))) {
                map.put(str.charAt(end), map.get(str.charAt(end)) - 1);
                if (map.get(str.charAt(end)) == 0) {
                    count--;
                }
            }

            if (0 < count) {
                end++;
            } else if (count == 0) {
                while (count <= 0) {
                    Character ch = str.charAt(start);
                    if (map.containsKey(ch) && map.get(ch) < 0) {
                        map.put(ch, map.get(ch) + 1);
                    } else if (map.containsKey(ch) && map.get(ch) == 0) {
                        if(minWindow>(end-start+1)){
                            minWindow = Math.min(minWindow, end - start + 1);
                            minWindowString = str.substring(start,end+1);
                        }


                        map.put(ch, map.get(ch) + 1);
                        count++;
                    }
                    start++;
                }
                end++;

            }


        }
        return minWindowString;

    }
}
