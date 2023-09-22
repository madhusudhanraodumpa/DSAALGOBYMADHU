package com.org.coding;

public class StringsConcepts {
    public static void main(String args[]){

        String s="java";
        String s1="javascript";

        String s3=s+"script";

        if(s1==s3){
            System.out.println(true);
        }else{
            System.out.println(false);
        }

        String s4="javascript";
        if(s4==s3){
            System.out.println(true);
        }else{
            System.out.println(false);
        }
    }
}
