package com.org.learnby.dynamicprograming.subsequences;

import java.util.HashMap;
import java.util.Map;

public class LongestArithmeticSubsequenceofGivenDifference {

    public static void main(String args[]){
        int[] a={1,5,7,8,5,3,4,2,1};
        System.out.println(longestSubsequenceOpt(a,-2));
    }

    public static int longestSubsequence(int[] arr, int difference) {

        int n=arr.length;
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int len=1;
            int value=arr[i];
            for(int j=i+1;j<n;j++){
                if(arr[j]-value == difference){

                    ans=Math.max(ans,++len);
                    value=arr[j];
                }

            }
        }
        return ans==Integer.MIN_VALUE?1:ans;
    }

    //https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference/discuss/637416/java-easy-dp-hashmap-solution-beats-100
    public static int longestSubsequenceOpt(int[] arr, int difference) {
        int result=1;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i: arr){
            int tmp=map.getOrDefault(i-difference, 0)+1;
            map.put(i,tmp);
            result=Math.max(result,tmp);
        }
        return result;
    }
}
