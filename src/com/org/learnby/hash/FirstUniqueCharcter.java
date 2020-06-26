package com.org.learnby.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FirstUniqueCharcter {
    public static void main(String args[]){
        String s="leetcode";
        System.out.println(findUniqueCharacterOpt(s));

    }
    public static int findUniqueCharacter(String s){

        Map<Character,Boolean> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),true);
            }
        }
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i)) && map.get(s.charAt(i))){
                return i;
            }
        }
        return -1;
    }
    public static int findUniqueCharacterOpt(String s){
        int i = s.length();

        for(char c = 'a'; c <= 'z'; c++){
            if(s.indexOf(c) != -1 && s.indexOf(c) == s.lastIndexOf(c)){
                int temp = s.indexOf(c);
                i = Math.min(temp, i);
            }
        }

        return i == s.length() ? -1: i;
    }
}
