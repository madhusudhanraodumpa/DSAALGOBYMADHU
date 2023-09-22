package com.org.prep.bits;

public class DivideInteger {

    public static void main(String args[]){

       // divide(-2147483648,-1);
        System.out.println(Math.log(10));
    }


    public static int divide(int A, int B) {

        int sign=1;
        if(A<0){
            sign=-sign;

        }
        if(B<0){
            sign=-sign;
        }
        long count=0;
        long a=A;
        long b=B;
        a=Math.abs(a);
        b=Math.abs(b);
       /** while(a>=b){
            a=a-b;

            count++;
        }**/

        for(int i=31;i>=0;i--){

            if((b<<i)<=a){
                a=a-(b<<i);
                count=count+(1L<<i);
            }


        }
        if(sign<0){
            count=-count;
        }


        return (int)count;

    }
}
