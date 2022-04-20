package com.org.learnby.sliding;

import java.util.ArrayList;
import java.util.List;

public class MaximumNumberofVowelsSubstring {
    public static void main(String args[]){
        System.out.println(maxVowels("leetcode",3));
    }

    public static int maxVowels(String s, int k) {
        int start=0;int end=0;
        int maxVowleCount=0;
        int count=0;
        while (end<s.length()){

            if(isVowle(s.charAt(end))){
                count++;
            }
            if(end-start+1<k){
                end++;
            }else if(end-start+1 == k){
                maxVowleCount = Math.max(maxVowleCount,count);
                if(isVowle(s.charAt(start))){
                    count--;
                }
                start++;
                end++;
            }


        }

        return maxVowleCount;
    }
    private static boolean isVowle(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
