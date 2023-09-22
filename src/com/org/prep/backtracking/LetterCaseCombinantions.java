package com.org.prep.backtracking;
import java.util.*;

public class LetterCaseCombinantions {
    public static void main(String[] args){
        LetterCaseCombinantions l=new LetterCaseCombinantions();
        l.letterCombinations("23");
    }


    public List<String> letterCombinations(String digits) {
        Map<Integer,String> map=new HashMap<>();
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
        List<String> list=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        letterCombinations(0,map,digits,sb,list);
        return list;
    }

    public void letterCombinations(int index,Map<Integer,String> map,String digit,StringBuilder sb,List<String> list){

        if(index==digit.length()){
            list.add(sb.toString());
            return;
        }

        String letter=map.get(digit.charAt(index)-'0');

        for(int i=0;i<letter.length();i++){
            sb.append(letter.charAt(i));
            letterCombinations(index+1,map,digit,sb,list);
            sb.deleteCharAt(sb.length()-1);




        }


















    }
}
