package com.org.prep.sliding;

import java.util.HashMap;
import java.util.Map;

public class CountSubstringWithKUniqueCharacters {
    public static void main(String args[]) {
        String str = "abcabdabbcfa";
        System.out.println(countSubString(3, str));
    }

    public static int countSubString(int k, String str) {
        int bigstart = 0;
        int bigend = 0;
        int smallStart = 0;
        int smallEnd = 0;
        Map<Character, Integer> bigmap = new HashMap<>();
        Map<Character, Integer> smallmap = new HashMap<>();

        int longest = Integer.MIN_VALUE;
        int count = 0;
        while (bigend < str.length() && smallEnd < str.length()) {

            while (bigend < str.length()) {
                bigmap.put(str.charAt(bigend), bigmap.getOrDefault(str.charAt(bigend), 0) + 1);

                if (bigmap.size() == k + 1) {
                    bigmap.remove(str.charAt(bigend));
                    bigend--;
                    break;
                }
                bigend++;
            }
            while (smallEnd < str.length()) {
                smallmap.put(str.charAt(smallEnd), smallmap.getOrDefault(str.charAt(smallEnd), 0) + 1);
                if (smallmap.size() == k) {
                    smallmap.remove(str.charAt(smallEnd));
                    smallEnd--;
                    break;
                }
                smallEnd++;

            }
            if (bigmap.size() == k && smallmap.size() == k - 1) {
                count += (bigend - smallEnd);
            }

            while (smallStart < bigend) {

                Character ch = str.charAt(bigstart);
                if (bigmap.containsKey(ch)) {
                    bigmap.put(ch, bigmap.get(ch) - 1);
                }
                if (bigmap.get(ch)!=null && bigmap.get(ch) == 0) {
                    bigmap.remove(ch);
                }
                if (smallmap.containsKey(ch)) {
                    smallmap.put(ch, smallmap.get(ch) - 1);
                }
                if (smallmap.get(ch)!=null && smallmap.get(ch) == 0) {
                    smallmap.remove(ch);
                }
                smallStart++;
                if (bigmap.size() < k||smallmap.size()<k-1) {
                    break;
                }
            }



        }


        return count;
    }
}
