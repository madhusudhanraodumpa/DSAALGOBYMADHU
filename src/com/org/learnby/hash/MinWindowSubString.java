package com.org.learnby.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinWindowSubString {
    public static void main(String args[]) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(findMinWindow(s, t));
    }

    private static String findMinWindow(String s, String t) {
        Map<Character, Integer> windowMap = new HashMap<Character, Integer>();

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
        }
        int requiredSize = windowMap.size();
        int left = 0, right = 0, size = 0;
        Map<Character, Integer> mainMap = new HashMap<Character, Integer>();
        int minLen = Integer.MAX_VALUE;
        String minWinSuubString = "";
        //if right index is less than the string length
        while (right < s.length()) {
            char c = s.charAt(right);
            mainMap.put(c, mainMap.getOrDefault(c, 0) + 1);
            //If this character is present in the window hashtable then check whether the count is matching
            if (windowMap.containsKey(c) && mainMap.get(c).intValue() == windowMap.get(c).intValue()) {
                size++;
            }
            // If left index is less than the right index and all the characters and their count in the window
            //hash table matches with the minimumWindow hash table then take a note of this substring
            while (left <= right && size == requiredSize) {
                if (minLen > s.substring(left, right + 1).length()) {
                    minWinSuubString = s.substring(left, right + 1);
                    minLen = s.substring(left, right + 1).length();
                }
                //Now remove the left character from the substring and decrement the index value in the
                // minimumWindow hash table by 1
                c = s.charAt(left);
                mainMap.put(c, mainMap.get(c) - 1);
                //If the minimumWindow does not contain all the characters and their count after removal then
                //decrement the expected
                //here we need to use the .intValue function to avoid the caching issue during auto unboxing
                if (windowMap.containsKey(c) && mainMap.get(c).intValue() < windowMap.get(c).intValue()) {
                    size--;
                }
                left++;
            }
            right++;
        }


        return minWinSuubString;
    }
}
