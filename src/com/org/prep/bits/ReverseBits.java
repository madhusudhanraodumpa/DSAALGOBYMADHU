package com.org.prep.bits;

public class ReverseBits {
    public static void main(String args[]){
        long  x=3;
        System.out.println(reverse1(x));
    }

    public static long reverse(long A) {
        long res=0;
        for(int i=0;i<32;i++){
            res=res<<1;

            if(((A>>i)&1)==1){
                res=res|1;
            }
        }
        return res;
    }

    public static long reverse1(long A) {
        long res=0;
        for(int i=0;i<32;i++){
            //res=res<<1;

            if(((A>>i)&1)==1){
                res= (1<<(30-i))|res ;
            }
        }
        return res;
    }
    }
