package com.org.prep.dp;

import java.util.*;

public class WordBreak {
    public static void main(String[] args) {
        List<String> list= Arrays.asList(new String[]{"leet", "code"});
        Boolean[] dp=new Boolean["aaaaaaa".length()];
        System.out.println(workBreakFinal("leetcode",list));

    }
    public static boolean workBreakFinal(String s,List<String> words){
        Set<String> set = new HashSet<>(words);
        int maxLen=Integer.MIN_VALUE;
        for(String word:set){
            maxLen = Math.max(maxLen,word.length());
        }
        int n=s.length();
        boolean[] dp=new boolean[n+1];
        dp[0]=true;
        for(int i=1;i<=n;i++){
            for(int j=i-1;j>=Math.max(0,i-maxLen);j--){
                if(dp[j] && set.contains(s.substring(j,i))){
                    dp[i]=true;
                }
            }
        }
        return dp[n];


    }

    public static boolean wordBreak4New(String s, List<String> dict) {
        if (dict == null || s.isEmpty())  return true;
        int n=s.length();
        boolean dp[][]=new boolean[n+1][n+1];
        Set set=new HashSet<>(dict);
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++) {
                if(i==j) {
                    dp[i][j] = false;
                }
            }
        }

        for(int i=1;i<=n;i++){
            for(int j=i;j>=0;j--){

                    if(dp[i][j-1] && dp[i+1][j] && set.contains(s.substring(i-1 , j+1))){
                        dp[i][j]=true;
                    }else{
                        dp[i][j]=false;
                    }
                }


            }

        return dp[n][n];
    }


    public static boolean wordBreak4(String s, List<String> dict) {
        if (dict == null || s.isEmpty())  return true;
        return wb(s, dict, 0, new Boolean[s.length()]);
    }

    public static boolean wb(String s, List<String> dict, int pos, Boolean[] memo){
        if(pos == s.length()) return true;
        if(memo[pos] != null) return memo[pos];

        StringBuilder sb = new StringBuilder(s);

        for(int i=pos+1; i<=s.length(); i++){
            String str = sb.substring(pos, i);

            if(dict.contains(str) && wb(s, dict, i, memo)){
                memo[pos] = true;
                return true;
            }
        }

        memo[pos] = false;
        return false;
    }

    public static boolean wordBreak2(String s, List<String> wordDict) {
        Set set=new HashSet<>(wordDict);

        int n=s.length();
        String temp="";
        for(int i=0;i<n;i++){
            temp=temp+s.charAt(i);
            if(set.contains(temp)){
                temp="";
            }
        }
        if(temp.length()==0) return true;
        return false;

    }

    public static boolean wordBreak1(String s, List<String> wordDict) {
        Set<String> set=new HashSet<>(wordDict);
        boolean[] dp=new boolean[s.length()+1];
        int maxLen=Integer.MIN_VALUE;
        for(String w:wordDict) {
            maxLen=Math.max(maxLen,w.length());
        }
        dp[0]=true;

        for(int i=1;i<=s.length();i++) {

            for(int j=i-1;j>=Math.max(0,i-maxLen);j--) {
                if(dp[j] && set.contains(s.substring(j,i))) {
                    dp[i]=true;
                    break;
                }
            }




        }



        return dp[s.length()];
    }


    public static boolean wordBreak(String s, List<String> wordDict,Boolean[] dp) {
        Set<String> set=new HashSet<>(wordDict) ;
        return f(0,s,set,dp);
    }
    public static boolean f(int i,String s,Set<String> set,Boolean[] dp) {

        if(i==s.length()) return true;
        if(dp[i]!=null) return dp[i];

        for(int j=i;j<s.length();j++) {
            if(set.contains(s.substring(i,j+1)) && f(j+1,s,set,dp)) {
                dp[i]=true;
                return true;
            }

        }
        dp[i]=false;
        return false;

    }
}
