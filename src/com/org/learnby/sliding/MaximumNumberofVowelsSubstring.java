package com.org.learnby.sliding;

import java.util.ArrayList;
import java.util.List;

public class MaximumNumberofVowelsSubstring {
    public static void main(String args[]){
        System.out.println(maxVowels("aeiou",2));
    }

    public static int maxVowels(String s, int k) {
        int start=0;int end=0;
        int maxVowleCount=0;
        int count=0;
        while(end<s.length()){
            if(end-start+1<=k && isVowle(s.charAt(end))){
                count++;

            }
            while(end-start+1>k) {
                if (isVowle(s.charAt(start))) {
                    count--;
                    start++;
                } else {
                    start++;
                }
                if(isVowle(s.charAt(end))){
                    count++;
                }
            }
            maxVowleCount=Math.max(maxVowleCount,count);
            end++;
        }
        return maxVowleCount;
    }
    private static boolean isVowle(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
