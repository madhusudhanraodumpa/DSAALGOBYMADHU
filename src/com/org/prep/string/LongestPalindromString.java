package com.org.prep.string;

public class LongestPalindromString {
    public static void main(String[] args){
        System.out.println(longestPalindrome("aaaabaaa"));
    }



    public static String longestPalindrome(String A) {

        String palindrom="";


        for(int i=0;i<A.length();i++){

            String s1=getPalnidrom(A,i,i);
            String s2=getPalnidrom(A,i,i+1);

            if(s1.length()<s2.length()){

                if(palindrom.length()<s2.length()){
                    palindrom=s2;
                }

            }else{
                if(palindrom.length()<s1.length()){
                    palindrom=s1;
                }

            }






        }


        return palindrom;












    }

    public static String getPalnidrom(String s,int start,int end){



        while(start>=0 && end<s.length() && s.charAt(start)==s.charAt(end)){

            start--;
            end++;
        }


        return s.substring(start+1,end);



    }
}
