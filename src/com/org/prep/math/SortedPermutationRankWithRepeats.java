package com.org.prep.math;

public class SortedPermutationRankWithRepeats {

    public static void main(String args[]){
        System.out.println(findRank("asasdsdsadasdadsadasdsa"));
    }

    public static int findRank(String A) {

        int n=A.length();
        int[] alpha=new int[256];
        int mod=1000003;

        for(int i=0;i<n;i++){
            alpha[A.charAt(i)]++;
        }
        long[] fact=new long[n+1];
        fact[0]=1;
        fact[1]=1;
        for(int i=2;i<=n;i++){
            fact[i]=(fact[i-1]%mod*i%mod)%mod;
        }

        int[] d_count = new int[52];

        for (int j = 0; j < n; j++)
        {

            if ((A.charAt(j) >= 'A')
                    && A.charAt(j) <= 'Z')
                d_count[A.charAt(j) - 'A'] += 1;
            else
                d_count[A.charAt(j) - 'a' + 26] += 1;
        }

        long rank=0;

        for(int i=0;i<n;i++){
            long count=0;
            char charVal=A.charAt(i);
            for(int j=0;j<(int)charVal;j++){
                if(alpha[j]!=0){
                    count=count+Long.valueOf(alpha[j]);
                }
            }
            alpha[charVal]=alpha[charVal]-1;



            long d_fac = 1;
            for (int ele : d_count)
                d_fac =(d_fac%mod * fac(ele)%mod)%mod;

            if ((A.charAt(i) >= 'A')
                    && A.charAt(i) <= 'Z'){
                d_count[A.charAt(i)-'A']=d_count[A.charAt(i)-'A']-1;
            }else{
                d_count[A.charAt(i)-'a'+26]=d_count[A.charAt(i)-'a'+26]-1;

            }

           // rank=(rank+((count%mod*fact[n-1-i]%mod)%mod)*pow(d_fac,mod-2,mod)%mod)%mod;


            rank=(rank %mod + (((count%mod * fact[n-1-i]%mod)%mod)%mod * pow(d_fac,mod-2,mod)%mod)%mod)%mod;

        }
        return (int) ((rank+1)%mod);


    }

    static int fac(int n)
    {
        int mod=1000003;
        if (n == 0 || n == 1)
            return 1;
        return (n%mod * fac(n - 1)%mod)%mod;
    }

    public static int pow(long A,long B,long mod){
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

}
