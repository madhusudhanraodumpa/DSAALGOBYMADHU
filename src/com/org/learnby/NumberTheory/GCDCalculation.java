package com.org.learnby.NumberTheory;

public class GCDCalculation {

    public static void main(String args[]){


        int a=10,b=14;


        //Applying bruteforce algo.
        int greatest=Integer.MIN_VALUE;
        for(int i=1;i<=Math.min(a,b);i++){
            if(a%i==0 && b%i==0){
                greatest=Math.max(i,greatest);
            }
       }

        System.out.println("Gcd of " +a+" and "+ b +" is "+greatest);
        System.out.println("Gcd of " +a+" and "+ b +" is "+GCD(a,b));
        System.out.println("LCM of " +a+" and "+ b +" is "+LCM(a,b));


       /* 18x+30y=gcd(18,30)
            find out x and y value
            using extended euclid algo.*/

      // extendedGCD(18,30);
        int a1=3,m=1000000007;
       int value=mutiplicateModInverse(a1,m);
       if(value<0){
           value=(value+m)%m;
       }
       System.out.println(a1+" mutplicate mod inverse is = "+value);





    }
    static int x1=0,y1=0,gcd1=0;

    private static int extendedGCD1(int a, int b) {

        if(b==0){
            x1=1;
            y1=0;
            gcd1=a;
            return x1;
        }
        extendedGCD1(b,a%b);
        int cx1=y1;
        int cy1=x1-(a/b)*y1;
        //System.out.println("cx= "+cx+" cy= "+cy);

        x1=cx1;
        y1=cy1;

        return x1;



    }

    private static int mutiplicateModInverse(int a, int m) {
        return extendedGCD1(a,m);

    }

    static int x=0,y=0,gcd=0;
    private static void extendedGCD(int a, int b) {

        if(b==0){
           x=1;
           y=0;
           gcd=a;
            return;
        }
        extendedGCD(b,a%b);
        int cx=y;
        int cy=x-(a/b)*y;
        System.out.println("cx= "+cx+" cy= "+cy);

        x=cx;
        y=cy;




    }

    private static Integer LCM(int a, int b) {
        return (a*b)/GCD(a,b);
    }

    public static  int GCD(int a,int b){
        if(b==0)
            return a;
        return GCD(b,a%b);
    }
}
