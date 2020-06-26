package com.org.learnby.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationOfString {
    public static void main(String rags[]){
        String in="ABC";
        char[] out=new char[in.length()];
        permutationEasy(in);


    }

    private static void permutationEasy(String s) {
        generatePerm(s,"");
    }
public static List<List<Integer>> pList= new ArrayList<>();

    private static void generatePerm(String s, String u) {
        if(s.length()==0){
            System.out.println(u);
        }

        for(int i=0;i<s.length();i++){
            generatePerm(s.substring(0,i)+s.substring(i+1,s.length()),u+s.charAt(i));
        }
    }

    private static void swap(char[] ch, int i, int j)
    {
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }

    // Recursive function to generate all permutations of a String
    private static void permutation(char[] ch, int currentIndex)
    {
        if (currentIndex == ch.length - 1) {
            System.out.println(String.valueOf(ch));
        }

        for (int i = currentIndex; i < ch.length; i++)
        {
            swap(ch, currentIndex, i);
            permutation(ch, currentIndex + 1);
            swap(ch, currentIndex, i);
        }
    }


}
