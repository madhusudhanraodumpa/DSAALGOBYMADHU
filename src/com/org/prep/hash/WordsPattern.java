package com.org.prep.hash;

import java.util.HashMap;
import java.util.Map;

public class WordsPattern {
    public static void main(String args[]){
        System.out.println(wordPattern("abba","dog cat cat dog"));
    }



    public static boolean wordPattern(String pattern, String s) {
        String[] word=s.split(" ");

        Map<Character,String> m1=new HashMap<>();
        Map<String,Boolean> m2=new HashMap<>();
        for(int i=0;i<pattern.length();i++){
            Character ch1=pattern.charAt(i);
            String str=word[i];

            if(!m1.containsKey(ch1)){
                if(m2.containsKey(word[i])){
                    return false;
                }else{
                    m2.put(word[i],true);
                    m1.put(ch1,word[i]);
                }

            }else{
                String with=m1.get(ch1);
                if(!with.equals(word[i])){
                    return false;
                }
            }


        }
        return true;
    }
}
