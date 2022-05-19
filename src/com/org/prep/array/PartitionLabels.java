package com.org.prep.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {
    public static void main(String[] args){

        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
    }


    public static List<Integer> partitionLabels(String s) {
        Map<Character,Integer> map=new HashMap<>();
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            char ch= s.charAt(i);
            map.put(ch,i);
             }

        int max=Integer.MIN_VALUE;
        int prev=-1;

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                max=Math.max(max,map.get(ch));
                if(i==max){
                    int val= max-prev;
                    list.add(val);
                    prev=max;
                }


            }



        }
        return list;

    }
}