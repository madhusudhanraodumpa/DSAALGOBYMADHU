package com.org.prep.stack;

import java.util.*;

public class Removeduplicates {
    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("bcabc"));
    }
    public static String removeDuplicateLetters(String s) {
        int n=s.length();
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            int ch=s.charAt(i)-'0';

            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        StringBuilder s1=new StringBuilder();
        for(int i=49;i<=74;i++){
            if(map.containsKey(i)){
                s1.append((char)(i+'0'));
            }
        }
        return s1.toString();
    }
}
