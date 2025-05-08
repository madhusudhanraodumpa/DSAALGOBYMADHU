package com.org.prep.dp;

public class InterLeavingStrings {
    public static void main(String[] args) {
        System.out.println(isInterleave("B","e","Be"));
    }

    public static int isInterleave(String A, String B, String C) {
        int n=A.length();
        int m=B.length();
        if(n+m!=C.length()) return 0;
        return isInterleave(A,B,C,0,0,n,m)?1:0;
    }
    public static boolean isInterleave(String A,String B,String C,int i,int j,int n,int m){

        if(i==n && j==m) return true;

        if(i<n && A.charAt(i)==C.charAt(i+j)){
            boolean f1=isInterleave(A,B,C,i+1,j,n,m);
            if(f1) return true;
        }
        if(j<m && B.charAt(j)==C.charAt(i+j)){
            boolean f2=isInterleave(A,B,C,i,j+1,n,m);
            if(f2) return true;
        }
        return false;
    }
}
