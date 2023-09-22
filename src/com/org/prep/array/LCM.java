package com.org.prep.array;

public class LCM {
    public static void main(String[] args){
        System.out.println(LCM(2,3));
    }

    public static int LCM(int A,int B){
        int lcm = (A > B) ? A : B;
        while(true){
            if( lcm % A == 0 && lcm % B == 0 )
            {
                break;
            }
            ++lcm;
        }
        return lcm;
    }
}
