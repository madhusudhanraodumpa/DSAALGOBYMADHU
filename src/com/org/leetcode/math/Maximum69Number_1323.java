package com.org.leetcode.math;


public class Maximum69Number_1323 {
    public int Maximum69Number_1323 (int num) {
        return Integer.parseInt(String.valueOf(num).replaceFirst("6","9"));
    }
    public static void main(String args[]){
        Maximum69Number_1323 m=new Maximum69Number_1323();
        System.out.println(m.Maximum69Number_1323(9996));
    }
}
