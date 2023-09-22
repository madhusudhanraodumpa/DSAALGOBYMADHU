package com.org.prep.math;

public class CalculateNCR {
    public static void main(String rags[]){
        solve1(5,1,13);

    }


    public static int solve1(int n, int r, int p) {
        int[] pascal=new int[r+1];

        pascal[0]=1;

        for (int i = 1; i <= n; i++) {
            for (int j = r; j > 0; j--){
                pascal[j] = (pascal[j] + pascal[j - 1]) % p;
            }

        }
        return pascal[r];
    }
    public static int solve(int A, int B, int C) {
        long factorN = factorial(Long.valueOf(A),Long.valueOf(C))%Long.valueOf(C);
        long N_MINUS_R = factorial(Long.valueOf((A-B)),Long.valueOf(C))%Long.valueOf(C);
        long factorR = factorial(Long.valueOf(B),Long.valueOf(C))%Long.valueOf(C);

        long N_MINUS_R_pow = Long.valueOf(pow(N_MINUS_R,C-2,C)%C);
        long  factorR_pow =  Long.valueOf(pow(factorR,C-2,C)%C);

        return (int)(factorN%C*N_MINUS_R_pow%C*factorR_pow%C)%C;
    }




   static public int pow(long A,long B,long mod){
        // int mod=1000000007;
        if(A==0) return 0;

        if(B==0){
            return 1;
        }
        if(A<0){
            A=(mod+A)%mod;
        }
        long x=Long.valueOf(pow(A,B/2,mod));
        long ans=((x%mod)*(x%mod))%mod;;

        if(B%2==1){
            ans=((ans%mod) *(A%mod))%mod;
        }

        return (int)(ans%mod);

    }

   static long factorial(long n,long mod)
    {
        return (n == 1 || n == 0) ? 1 : ((n%mod) * (factorial(n - 1,mod)%mod))%mod;
    }
}
