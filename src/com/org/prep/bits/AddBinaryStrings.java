package com.org.prep.bits;

public class AddBinaryStrings {

    public static void main(String args[]){
        addBinary1("1010","10001011");
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

    public static String addBinary1(String A, String B) {
        int n=A.length()-1;
        int m=B.length()-1;

        StringBuilder sb=new StringBuilder();
        int carray=0;


        while(n>0||m>0){
            int x=0;
            int y=0;

            if(n>=0){
                x=A.charAt(n)-'0';
            }

            if(m>=0){
                y=B.charAt(m)-'0';
            }



            int sum=x+y+carray;

            sb.append(sum%2);
            carray=sum/2;
            n--;
            m--;

        }
        if(carray != 0) sb=sb.append(carray);


        return sb.reverse().toString();
    }

}
