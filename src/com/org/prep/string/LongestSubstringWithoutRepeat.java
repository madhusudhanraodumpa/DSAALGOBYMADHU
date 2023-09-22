package com.org.prep.string;
import java.util.*;

public class LongestSubstringWithoutRepeat {

    public static void main(String args[]){
        String A="bbbbbbbbbbb";
        lengthOfLongestSubstring("abcabcbb");
    }


    public static int lengthOfLongestSubstring(String A) {
        int start=0;
        int end=0;
        int n=A.length();
        HashMap<Character,Integer> map=new HashMap<>();
        int maxLen=Integer.MIN_VALUE;

        while(end<n){

            while(map.containsKey(A.charAt(end))){

                // while(map.get(A.charAt(end))){
                map.remove(A.charAt(start));
                start++;

                //}


            }
            map.put(A.charAt(end),end);
            end++;


            maxLen=Math.max(end-start+1,maxLen);




        }
        return maxLen==Integer.MIN_VALUE?0:maxLen;
    }
}
