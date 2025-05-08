package com.org.prep.dp;

import java.util.Base64;

public class EncodingString {
    public static void main(String[] args) {
        System.out.println(encode("jjii3089Klopdwd8=982","gdyugsjdjshdfjsbdfgjhdsgtfg"));

    }
    public static String encode(String s1,String s2) {
        byte[] encodedBytes = Base64.getEncoder().encode((s1+":"+s2).getBytes());
        System.out.println("encodedBytes " + new String(encodedBytes));
        byte[] decodedBytes = Base64.getDecoder().decode(encodedBytes);
        System.out.println("decodedBytes " + new String(decodedBytes));
        return new String(decodedBytes);
    }
}
