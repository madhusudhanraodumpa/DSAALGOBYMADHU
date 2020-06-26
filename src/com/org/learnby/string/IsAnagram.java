package com.org.learnby.string;

import java.util.HashMap;
import java.util.Map;

public class IsAnagram {
    public static void main(String args[]){
        System.out.println(isAnagram("aa","bb"));


    }
    public static boolean isAnagram(String s, String t) {
        Map<Character,Integer> map=new HashMap<>();
        if(s.length()!=t.length()) return false;
        if(s.length()==1){
            return s.charAt(0) == t.charAt(0);
        }
        for(int i=0;i<s.length();i++){
            int count=map.getOrDefault(s.charAt(i),0);
            map.put(s.charAt(i),++count);
        }
        for(int i=0;i<t.length();i++){
            int count=map.getOrDefault(t.charAt(i),0);
            map.put(t.charAt(i),--count);
        }
        for (Map.Entry<Character,Integer> entry : map.entrySet()){
            if(entry.getValue()!=0){
                return false;
            }
        }
        return true;
    }

    public boolean isAnagramOpt(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] map = new int[128];
        for(char c: s.toCharArray())
            map[c]++;
        for(char c: t.toCharArray())
            map[c]--;
        for(int i: map)
            if(i != 0)
                return false;
        return true;
    }
}
