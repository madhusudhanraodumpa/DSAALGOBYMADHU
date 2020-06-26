package com.org.learnby.sliding;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
    public static void main(String args[]){
        System.out.println(characterReplacement("AABABBA",1));
    }
    public static int characterReplacement(String s, int k) {
        int left=0;int right=0;int windowSize=0;
        int maxReplaceCharWindow=0;
        Map<Character,Integer> map=new HashMap<>();
        int mostReptaiveCharCount=0;
        while(right<s.length()){
            Character ch=s.charAt(right);
            map.put(ch,map.getOrDefault(ch,0)+1);
            mostReptaiveCharCount=Math.max(mostReptaiveCharCount,map.get(ch));
            windowSize=right-left+1;
            if(windowSize-mostReptaiveCharCount<=k){
                maxReplaceCharWindow=Math.max(maxReplaceCharWindow,windowSize);
            }
            while(windowSize-mostReptaiveCharCount>k){
                Character cha=s.charAt(left);
                map.put(s.charAt(left),map.get(cha)-1);
                left++;
                windowSize=right-left+1;
            }
            right++;
        }
        return maxReplaceCharWindow;
    }
}
