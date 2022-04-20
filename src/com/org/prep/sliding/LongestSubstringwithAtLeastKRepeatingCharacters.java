package com.org.prep.sliding;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringwithAtLeastKRepeatingCharacters {

    public static void main(String args[]) {
        String str = "ababacb";
        System.out.println(longestSubstring(str, 3));
    }

    public static int longestSubstring(String s, int k) {

        int start = 0;
        int end = 0;
        int longest = Integer.MIN_VALUE;
        Map<Character,Integer> map = new HashMap<>();
        boolean vaild = true;
        for( int i =0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }

        while (end<s.length()){
            Character ch = s.charAt(end);
            if(map.containsKey(ch) && map.get(ch)<k){
                String subString = s.substring(start,end);
                longest =Math.max(longest,longestSubstring(subString,k));
                start = end+1;
                vaild = false;
            }
            end++;
        }
        if(vaild) {return s.length();}
        else {
            return Math.max(longest,longestSubstring(s.substring(start),k));
        }
    }

}
