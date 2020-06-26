package com.org.learnby.string;

import java.util.*;

public class GroupAnagrams {
    public static void main(String args[]){
        String[] strs={"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> list=groupAnagramsOpt(strs);
        for(List<String> l:list){
            for(String s:l){
                System.out.print(s+" ");
            }
            System.out.println();
        }

    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();

        for(int i=0;i<strs.length;i++){
            String s=strs[i];
            char[] chars=s.toCharArray();
            Arrays.sort(chars);
            String key=String.valueOf(chars);
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(s);

        }
        return new ArrayList<>(map.values());

    }

    public static List<List<String>> groupAnagramsOpt(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) count[c - 'a']++;

            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }
}
