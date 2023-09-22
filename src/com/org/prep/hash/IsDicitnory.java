package com.org.prep.hash;

import java.util.*;

public class IsDicitnory {
    public static void main(String args[]){

        String[] str={"fine", "none", "no"};
        System.out.println(solve(str,"qwertyuiopasdfghjklzxcvbnm"));
    }

    public static int solve(String[] A, String B) {

        Map<Character,Integer> map=new HashMap<>();

        for(int i=0;i<B.length();i++){

            map.put(B.charAt(i),i);
        }

        String s1=A[0];
        for(int i=1;i<A.length;i++){
            String s2=A[i];

            if(!isDictionary(s1,s2,map)){
                return 0;
            }
            s1=s2;

        }

        return 1;

    }

    public static boolean isDictionary(String s1,String s2,Map<Character,Integer> map){

        int n=s1.length()>s2.length()?s2.length():s1.length();

        for(int i=0;i<n;i++){

            int val1=map.get(s1.charAt(i));
            int val2=map.get(s2.charAt(i));

            if(val1==val2){
                continue;
            }else if(val1>val2){
                return false;
            }else{
                break;
            }

        }

        return true;
    }
}
