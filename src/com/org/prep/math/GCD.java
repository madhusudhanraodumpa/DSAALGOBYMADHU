package com.org.prep.math;

public class GCD {

    public static void main(String[] args) {
        int a=25;
        int b=26;
        int gcd = gcdOfTwoNumbers(a,b);

        System.out.println(gcd);
        System.out.println(gcdOfTwoNumbersUsingFactors(a,b));
        System.out.println(gcdOfTwoNumbersUsingSubProperty(a,b));
        System.out.println(gcdOfTwoNumbersUsingModProperty(a,b));
    }

    private static int gcdOfTwoNumbersUsingModProperty(int a, int b) {
        if(b==0) return a;

        return gcdOfTwoNumbersUsingSubProperty(b,a%b);
    }

    private static int gcdOfTwoNumbersUsingSubProperty(int a, int b) {
        if(b==0) return a;
        if(a<b) {
            int temp=a;
            a=b;
            b=temp;
        }
        return gcdOfTwoNumbersUsingSubProperty(a-b,b);
    }
    private static int gcdOfTwoNumbers(int a, int b) {

        for(int i=Math.min(a,b);i>=1;i--) {

            if(a%i==0 && b%i==0){
                return i;
            }

        }
        return 1;
    }

    private static int gcdOfTwoNumbersUsingFactors(int a, int b) {
        int value = Math.min(a, b);
        int gcd = Integer.MIN_VALUE;

        for (int i = 1; i * i <= value; i++) {

            if (value % i == 0) {
                int f1 = i;
                int f2 = value / i;
                if (b % f1 == 0 && b % f2 == 0) {
                    gcd = Math.max(gcd, Math.max(f1, f2));
                } else if (b%f1== 0) {
                    gcd = Math.max(gcd, f1);
                } else if(b%f2==0){
                    gcd = Math.max(gcd, f2);
                }


            }

        }
        return gcd;
    }

}
