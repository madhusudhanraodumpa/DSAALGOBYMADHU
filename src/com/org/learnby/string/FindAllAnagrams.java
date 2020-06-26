package com.org.learnby.string;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagrams {
    public static void main(String args[]){

    }
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();


        int pLen=p.length();
        int sLen=s.length();
        if(sLen<pLen) return result;
        int[] pArr=new int[26];
        int[] sArr=new int[26];


        for(int i=0;i<p.length();i++){
            pArr[p.charAt(i)-'a']++;
            sArr[s.charAt(i)-'a']++;
        }
        for(int i=0;i<sLen-pLen;i++){
                if(isAnagram(pArr,sArr)){
                    result.add(i);
                }
                sArr[s.charAt(i)-'a']--;
                sArr[s.charAt(i+pLen)]++;
        }
        if(isAnagram(pArr,sArr)){
            result.add(sLen-pLen);
        }
        return result;
    }
    private static boolean isAnagram(int[] pArr,int[] sArr){
        for(int i=0;i<pArr.length;i++){
            if(pArr[i]!=sArr[i]) return false;
        }
        return true;
    }
}
