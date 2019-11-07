package com.org.learnby.NumberTheory;

public class FastModExponention {

    public static void main(String args[]){
        int x=fastExponentionByMod(2,33,7);
        System.out.println(x);
      /*  int count=0;
        while(x>0){
           count++;
           x=x/10;
        }*/

      //  System.out.println(count);
    }
    public static int fastExponentionByMod(int a,int b,int m){

        int res=1;

        while(b>0){

            if((b & 1)==1){
                res=(res*a)%m;
            }
            a=a*a%m;
            b=b>>1;

        }


        return res;
    }
}
