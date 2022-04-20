package com.org.prep.sliding;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKUniqueCharacters {
    public static void main(String args[]) {
        String str = "aabacbebebe";
        System.out.println(longestSubString(3, str));
    }

    public static int longestSubString(int k, String str) {
        int start = 0;
        int end = 0;
        Map<Character, Integer> map= new HashMap<>();
        int longest = Integer.MIN_VALUE;

        while (end < str.length()) {
            map.put(str.charAt(end),map.get(str.charAt(end))!=null?map.get(str.charAt(end))+1:1);
            if(map.size()<k){
                end++;
            } else if(map.size() == k){
                longest = Math.max(end-start+1,longest);
                end++;
            }
            else if(map.size()>k){
                int size = map.size();
                while (size>k){
                    Character ch = str.charAt(start);
                    if(map.containsKey(ch)){
                        map.put(ch,map.get(ch)-1);
                    }
                    if(map.get(ch)==0){
                        size--;
                        map.remove(ch);
                    }
                    start++;

                }
                end++;
            }

        }


        return longest;
    }
}
