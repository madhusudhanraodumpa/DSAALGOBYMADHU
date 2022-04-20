package com.org.learnby.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String args[]){
        String s="wpwkew";
        System.out.println(longestSubStringOpt(s));

    }

    private static int longestSubString(String s) {
        int ans=0;
        Set<Character> set=new HashSet<>();
        int i=0;
        int j=0;
        int n=s.length();
        while(i<n && j<n){
            if(!set.contains(s.charAt(i))){
                set.add(s.charAt(i));
                i++;
                ans=Math.max(ans,i-j);

            }else{
                set.remove(s.charAt(i));
                j++;
            }
        }

        return ans;
    }
    private static int longestSubStringOpt(String s) {
        int ans=0;
        int i=0;

        Map<Character,Integer> map=new HashMap<>();
        for(int j=0;j<s.length();j++){
            if(map.containsKey(s.charAt(j))){
                i=Math.max(map.get(s.charAt(j))+1,i);
            }
            ans=Math.max(ans,j-i+1);
            map.put(s.charAt(j),j);

        }
        return ans;


    }
    }
