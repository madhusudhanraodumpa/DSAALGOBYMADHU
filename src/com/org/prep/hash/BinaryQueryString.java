package com.org.prep.hash;

public class BinaryQueryString {
    public static void main(String args[]){
        queryString("0110",3);
    }
    public static boolean queryString(String s, int n) {
        for(int i = 1 ; i <= n ; i++) {
            String binary = Integer.toBinaryString(i);
            if(!s.contains(binary)) return false;
        }
        return true;
    }
}
