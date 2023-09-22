package com.org.prep.array;
import java.util.*;

public class LongestCommonPrefix {

    public static void main(String args[]){
        String[] str={"flower","flow","flight"};
        longestCommonPrefix(str);
    }

    public static String longestCommonPrefix(String[] a) {
        int n=a.length;

        if(n==0) return "";
        if(n==1) return a[0];

        Arrays.sort(a);
        int end=Math.min(a[0].length(),a[n-1].length());
        int i = 0;
        while (i < end && a[0].charAt(i) == a[n-1].charAt(i) )
            i++;

        String pre = a[0].substring(0, i);
        return pre;

    }
}
