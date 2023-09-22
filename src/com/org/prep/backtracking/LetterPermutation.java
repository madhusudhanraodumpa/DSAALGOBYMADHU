package com.org.prep.backtracking;
import java.util.*;

public class LetterPermutation {

    public static void main(String args[]){
        LetterPermutation l=new LetterPermutation();
        l.letterCasePermutation("C");
    }

    public List<String> letterCasePermutation(String s) {

        List<String> list=new ArrayList<>();
        letterCasePermutation(list,0,s.toCharArray());
        return list;


    }
    public void letterCasePermutation(List<String> list,int index,char[] s){

        if(index==s.length){
            list.add(String.valueOf(s));
            return;
        }




        if (Character.isAlphabetic(s[index])) {
            letterCasePermutation(list,index+1,s);
            //s[index]=Character.toUpperCase(s[index]);
            s[index] ^= (1 << 5);
            letterCasePermutation(list,index+1,s);
            s[index] ^= (1 << 5);

            //s[index]=Character.toLowerCase(s[index]);


        }else{
            letterCasePermutation(list,index+1,s);
        }



    }
}
