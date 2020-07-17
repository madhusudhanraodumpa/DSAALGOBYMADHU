package com.org.learnby.dynamicprograming.palindrome;

public class LongestChunkedPalindromeDecomposition {
    public static void main(String args[]){

        System.out.println(longestDecomposition("ghiabcdefhelloadamhelloabcdefghi"));
    }


    public  static int longestDecomposition(String text) {
        if(text.equals("")) return 0;
        int length = text.length();
        for(int i = 1;i <= length/2;i++) {
            if(text.substring(0, i).equals(text.substring(length-i, length)))
                return 2+longestDecomposition(text.substring(i, length-i));
        }//for
        return 1;
    }
}
