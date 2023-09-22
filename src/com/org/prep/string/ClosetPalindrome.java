package com.org.prep.string;

public class ClosetPalindrome {

    public static String solve(String A) {
        int n=A.length();
        int start=0;
        int end=n-1;

        while(start<=end){

            if(A.charAt(start)==A.charAt(end)){
                start++;
                end--;
            }else{
                break;
            }
        }

        if(end<start) return "YES";

        if(check(A.substring(start,end)) || check(A.substring(start+1,end+1))) return "YES";
        return "NO";

    }
    public static boolean check(String s){
        int start=0;
        int end=s.length()-1;
        while(start<=end){


            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }

        }
        return true;
    }
}
