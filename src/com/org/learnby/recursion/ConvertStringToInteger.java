package com.org.learnby.recursion;

public class ConvertStringToInteger {
    public static void main(String rags[]){
        System.out.println(convertStringToInt("1234","1234".length()));
    }

    private static int convertStringToInt(String s,int n) {
        if(n==0){
            return 0;
        }
        int digit=s.charAt(n-1)-'0';
        int small_value=convertStringToInt(s,n-1);
        return small_value*10+digit;

    }
}
