package com.org.prep.sliding;

import java.util.*;

public class CountOccurrencesOfAnagrams {
    public static void main(String args[]){
        String str = "cbaebabacd";
        String ptr = "abc";
        countOccurrencesOfAnagramsList(str,ptr);
    }
    public static int countOccurrencesOfAnagrams(String str, String ptr){
        int start =0;
        int end = 0;

        int k = ptr.length();
        int occurance =0;

        Map<Character,Integer> m1 = new HashMap<>();

        for(int i =0;i<ptr.length();i++){
            m1.put(ptr.charAt(i),m1.get(ptr.charAt(i))!=null?m1.get(ptr.charAt(i))+1:1);
        }
        int count = m1.size();
        while(end<str.length()){
            if(m1.containsKey(str.charAt(end))){
                    m1.put(str.charAt(end),m1.get(str.charAt(end))-1);
                    if(m1.get(str.charAt(end))==0){
                        count --;
                    }
                }

            if(end-start+1<k){
                end++;
            } else if(end-start+1 == k){
                if(count == 0){
                   occurance++;
                }
                if(m1.containsKey(str.charAt(start))) {

                    m1.put(str.charAt(start), m1.get(str.charAt(start)) + 1);
                    if(m1.get(str.charAt(start)) == 1){
                        count++;
                    }
                }
                start++;
                end++;
            }




        }


        return occurance;
    }

    public static List<Integer> countOccurrencesOfAnagramsList(String str, String ptr){
        int start =0;
        int end = 0;

        int k = ptr.length();
        int occurance =0;

        Map<Character,Integer> m1 = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        if(str.length()<ptr.length()) return list;

        for(int i =0;i<ptr.length();i++){
            m1.put(ptr.charAt(i),m1.get(ptr.charAt(i))!=null?m1.get(ptr.charAt(i))+1:1);
        }
        int count = m1.size();
        while(end<str.length()){
            if(m1.containsKey(str.charAt(end))){
                m1.put(str.charAt(end),m1.get(str.charAt(end))-1);
                if(m1.get(str.charAt(end))==0){
                    count --;
                }
            }

            if(end-start+1<k){
                end++;
            } else if(end-start+1 == k){
                if(count == 0){
                    occurance++;
                    list.add(start);
                }
                if(m1.containsKey(str.charAt(start))) {

                    m1.put(str.charAt(start), m1.get(str.charAt(start)) + 1);
                    if(m1.get(str.charAt(start)) == 1){
                        count++;
                    }
                }
                start++;
                end++;
            }




        }


        return list;
    }
}
