package com.org.learnby.sliding;

public class LongestSubStringWithKDistinctCharacter {
    public static void main(String rags[]){
        System.out.println(lengthOfLongestSubstringKDistinct("eceba",2));
    }
    public static int lengthOfLongestSubstringKDistinct(String s,int k){

        int start=0;int end=0;int distinct=0;int max=Integer.MIN_VALUE;
        int[] a=new int[26];

        while(end<s.length()){
            if(a[s.charAt(end)-'a']==0) distinct++;
            a[s.charAt(end)-'a']++;

            while(distinct>k){
                a[s.charAt(start)-'a']--;
                if(a[s.charAt(start)-'a']==0) distinct--; //doubt this condition
                start++;
            }

            max=Math.max(max,end-start+1);
            end++;
        }
        return max;
    }
}
