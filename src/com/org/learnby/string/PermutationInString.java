package com.org.learnby.string;

import java.util.ArrayList;
import java.util.List;

public class PermutationInString {
    public static void main(String args[]){
        System.out.println(checkInclusion("ab","eidbaooo"));

    }
    public static boolean checkInclusion(String s1, String s2) {


        int pLen=s1.length();
        int sLen=s2.length();
        if(sLen<pLen) return false;
        int[] pArr=new int[26];
        int[] sArr=new int[26];


        for(int i=0;i<s1.length();i++){
            pArr[s1.charAt(i)-'a']++;
            sArr[s2.charAt(i)-'a']++;
        }
        for(int i=0;i<sLen-pLen;i++){
                if(isAnagram(pArr,sArr)){
                   return true;
                }
                sArr[s2.charAt(i)-'a']--;
                sArr[s2.charAt(i+pLen)-'a']++;
        }
        if(isAnagram(pArr,sArr)){
           return true;
        }
        return false;
    }
    private static boolean isAnagram(int[] pArr,int[] sArr){
        for(int i=0;i<pArr.length;i++){
            if(pArr[i]!=sArr[i]) return false;
        }
        return true;
    }
}
