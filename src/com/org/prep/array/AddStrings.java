package com.org.prep.array;

public class AddStrings {

    public static void main(String[] args) {
        System.out.println(addStrings("9","99"));
    }

    public static String addStrings(String num1, String num2) {
        int n1=num1.length();
        int n2=num2.length();
        int sum= 0;
        String ans="";
        int carry=0;
        int x=0;
        int y=0;
        int i=n1-1;
        int j=n2-1;
        while(i>=0 || j>=0 || carry!=0) {
            if(i<0){
                x=0;
            }else {
                x=num1.charAt(i)-'0';
            }

            if(j<0){
                y=0;
            }else {
                y=num2.charAt(j)-'0';
            }
             sum=x+y+carry;
            ans=ans+(sum%10);
            carry=sum/10;
            i--;
            j--;
        }
        return new StringBuilder(ans).reverse().toString();
    }
}
