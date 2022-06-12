package com.org.prep.bits;

public class AddBinaryStrings {
    public static void main(String args[]){
        addBinary("111","11");
    }
    public static String addBinary(String A, String B) {
        StringBuilder result=new StringBuilder();
        int i=A.length()-1;
        int j=B.length()-1;
        int carry=0;
        int sum=0;


        while(i>=0 || j>=0)
        {
            sum=carry;
            if(i>= 0)
                sum=sum+A.charAt(i) - '0';
            if(j>= 0)
                sum=sum+B.charAt(j) - '0';

            result=result.append(sum%2);
            carry=sum/2;

            i--;
            j--;

        }
        if(carry != 0) result=result.append(carry);
        return result.reverse().toString();
    }
}
