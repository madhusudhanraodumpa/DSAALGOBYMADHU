package com.org.learnby.recursion;

public class StringGenrationAcode {
    public static void main(String args[]){
        String number="1234";
        char[] out=new char[number.length()];
        generate_strings(number.toCharArray(),out,0,0);

    }

    private static void generate_strings(char[] in, char[] out, int i, int j) {

        if(in.length ==i){
            System.out.println(out);
            return;
        }
        int digit = in[i]-'0';
        char ch= (char) ((digit-1)+ 'A');
        out[j]=ch;
        generate_strings(in,out,i+1,j+1);
        if(in.length>i+1){
            int secondDigit=in[i+1]-'0';
            int no= digit*10+secondDigit;
            if(no<=26){
                ch= (char) ((no-1)+'A');
                out[j]=ch;
                generate_strings(in,out,i+2,j+1);
            }
        }
        return;

    }
}
