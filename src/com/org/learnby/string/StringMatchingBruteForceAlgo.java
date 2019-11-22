package com.org.learnby.string;

import java.util.Scanner;

public class StringMatchingBruteForceAlgo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String pat = sc.nextLine();
        stringMatching(str, pat);
    }

    private static void stringMatching(String str, String pat) {

        for (int i = 0; i < str.length() - pat.length(); i++) {

            int j = 0;
            for (j = 0; j < pat.length(); j++) {
                if(str.charAt(i+j)!=pat.charAt(j)){
                    break;
                }
            }

            if(j==pat.length()){
                System.out.println("Pattern matching index at : "+i);
            }
        }

    }


}



