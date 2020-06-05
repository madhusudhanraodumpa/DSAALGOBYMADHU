package com.org.learnby.recursion;

public class PermutationOfString {
    public static void main(String rags[]){
        String in="AABC";
        char[] out=new char[in.length()];
        permutation(in.toCharArray(),0);


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
