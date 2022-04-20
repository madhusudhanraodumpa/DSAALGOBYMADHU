package com.org.prep.sliding;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithWithoutRepeatingCharacters {
    public static void main(String args[]) {
        String str = "eeydgwdykpv";
        System.out.println(longestSubString(str));
    }
    public static int longestSubString(String str) {

        int start = 0;
        int end = 0;
        Map<Character,Integer> map = new HashMap<>();
        int longest = Integer.MIN_VALUE;
        while (end<str.length()){
            map.put(str.charAt(end),map.get(str.charAt(end))!=null?map.get(str.charAt(end))+1:1);

            if(map.size() == end-start+1){
                longest = Math.max(longest,end-start+1);
                end++;
            }
            else if(map.size()< end-start+1){
                while (map.size()<end-start+1){
                    Character ch= str.charAt(start);
                    map.put(ch,map.get(ch)-1);
                    if(map.get(ch)==0){
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
