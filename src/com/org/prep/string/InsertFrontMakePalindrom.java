package com.org.prep.string;

public class InsertFrontMakePalindrom {
        public static void main(String[] args){
            makePalindrom("aacecaaaa");
        }


    public static int makePalindrom(String s){
        int left=0;
        int n=s.length();
        int right=n-1;
        int count=0;
        int added=0;

        while (left<right){
            if(s.charAt(left)==s.charAt(right)){
                left++;
                right--;
            }else {
                left=0;
                added=n-right;
                while (s.charAt(left)==s.charAt(right)){
                    added--;
                    left++;
                }
                right--;
            }



        }
return  added;


    }
}
