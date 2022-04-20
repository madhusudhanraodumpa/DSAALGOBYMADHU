package com.org.prep.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord {
    public static void main(String args[]){

           String[] str= {"bob", "hit"};


        System.out.println(mostCommonWord("Bob. hIt, baLl",str));

    }
    public static String mostCommonWord(String paragraph, String[] banned) {

        Set<String> set=new HashSet<>();
        Map<String,Integer> map=new HashMap<>();
        for(String str:banned){
            set.add(str);
        }
        StringBuilder sb=new StringBuilder();
        int maxCount=Integer.MIN_VALUE;
        String maxWordCount="";
        for(int i=0;i<paragraph.length();i++){

            char ch=paragraph.charAt(i);

            if(Character.isLetter(ch)){
                sb.append(ch);
            }else{
                String s=sb.toString().toLowerCase();
                map.put(s,map.getOrDefault(s,0)+1);
                if(!set.contains(s) && !s.equals("") && maxCount<map.get(s)){
                    maxCount=map.get(s);
                    maxWordCount=s;
                }
                sb=new StringBuilder();
            }
        }
        String s=sb.toString().toLowerCase();
        map.put(s,map.getOrDefault(s,0)+1);
        if(!set.contains(s) && maxCount<map.get(s)){
            maxCount=map.get(s);
            maxWordCount=s;
        }
        return maxWordCount;
    }
}
