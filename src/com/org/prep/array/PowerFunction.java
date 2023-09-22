package com.org.prep.array;

public class PowerFunction {
    public static void main(String args[]){
      //  pow(-1,1,20);
        int x= (int) Math.pow(2,27);
        System.out.println(x);
        System.out.println(x%1000000007);
        solve(2,27);
    }

    public static int pow(int A, int B, int C) {


        if(A==0) return 0;

        if(B==0) return 1;

        if(A<0){
            A=(C+A)%C;
        }
        long he=pow(A,B/2,C);
        long ha= (he%C*he%C)%C;

        if(B%2==0){
            return (int)ha;
        }else{

            return (int)(ha%C*A%C)%C;
        }


    }

    static public int solve(int A, int B) {
        int n=factorial(B);
        return pow(A,n);

    }
    static public int pow(int A,int B){
        int mod=1000000007;
        if(A==0) return 0;

        if(B==0){
            return 1;
        }
        if(A<0){
            A=(mod+A)%mod;
        }
        long x=Long.valueOf(pow(A,B/2));
        long ans=((x%mod)*(x%mod))%mod;;

        if(B%2==1){
            ans=((ans%mod) *(A%mod))%mod;
        }

        return (int)ans%mod;

    }

    static int factorial(int n)
    {
        int mod=1000000007;

        // single line to find factorial
        return (n == 1 || n == 0) ? 1 : ((n%mod) * (factorial(n - 1)%mod))%mod;
    }

}
