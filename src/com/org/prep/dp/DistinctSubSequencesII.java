package com.org.prep.dp;

import java.util.HashSet;
import java.util.*;


public class DistinctSubSequencesII {
    public static Set<String> al=new HashSet<>();
    public static void main(String[] args) {
        System.out.println(distinctSubseqII("aba"));
        System.out.println(al.size()-1);
    }

    public static int distinctSubseqII(String str) {
        int n=str.length();
        long[] dp=new long[n+1];
        long mod=(long)1e9+7;
        HashMap<Character,Long> hm=new HashMap<>();
        dp[0]=1;
        for(int i=1;i<=n;i++){
            if(hm.containsKey(str.charAt(i-1))==false){
                dp[i]=2*dp[i-1];
                hm.put(str.charAt(i-1),dp[i-1]);
            }else{
                dp[i]=2*dp[i-1]-(hm.get(str.charAt(i-1)));
                hm.put(str.charAt(i-1),dp[i-1]);
            }
        }
        return (int)(dp[n]-1);

    }

    public static  int distiinctSubsequences(String s){
        int n =s.length();
        Set<String> set = new HashSet<>();

        for(int i=0;i<n;i++) {
            String temp="";

            for(int j=i;j<n;j++){
                temp=temp+s.charAt(j);
                if(isSubsequence(s,temp,n-1,temp.length()-1)){
                    set.add(temp);
                }
            }
        }


        return set.size();

    }


    private static void findsubsequences(String s,
                                         String ans)
    {
        if (s.length() == 0) {
           // if(isSubsequence(s,ans,s.length()-1,ans.length()-1)) {
                al.add(ans);
           // }
            return;
        }

        // We add adding 1st character in string
        findsubsequences(s.substring(1), ans + s.charAt(0));

        // Not adding first character of the string
        // because the concept of subsequence either
        // character will present or not
        findsubsequences(s.substring(1), ans);
    }
    public static boolean isSubsequence(String s,String t,int i,int j){

        if(j<0) return true;
        if(i<0) return false;


        if(s.charAt(i)==t.charAt(j)){
            return isSubsequence(s,t,i-1,j-1);
        }else {
            return isSubsequence(s,t,i-1,j) || isSubsequence(s,t,i,j-1);
        }


    }
}
