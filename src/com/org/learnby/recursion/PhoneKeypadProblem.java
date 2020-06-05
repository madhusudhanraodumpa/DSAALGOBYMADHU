package com.org.learnby.recursion;

public class PhoneKeypadProblem {
    public static String[] keypad={"","","ABC","DEF","GHI","JKL","MNO"};
    public static void main(String args[]){

        char[] in={'6','6','0'};
        char[] out=new char[in.length];
        generate_strings(in,out,0,0);
    }

    private static void generate_strings(char[] in, char[] out, int i, int j) {

        if(in.length == i){
            System.out.println(out);
            return;
        }


        int digit=in[i]-'0';
        if(digit== 0 || digit==1){
            generate_strings(in,out,i+1,j);
        }
        String key=keypad[digit];
        for(int k=0;key.toCharArray().length>k;k++){
            out[j]=key.charAt(k);
            generate_strings(in,out,i+1,j+1);
        }
        return;


    }

}
