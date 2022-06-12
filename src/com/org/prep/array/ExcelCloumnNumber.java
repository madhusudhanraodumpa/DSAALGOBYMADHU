package com.org.prep.array;

public class ExcelCloumnNumber {
    public static void main(String args[]){
            System.out.println(Number("A"));
    }

    public static  int Number(String A) {
        int exp=1;
        int ans=0;
        for(int i=A.length()-1;i>=0;i--){
            ans=ans+((A.charAt(i)-'A')+1*exp);
            exp=exp*26;
        }
        return ans;

    }
}
