package com.org.prep.math;

public class CountOfDivisors {
    public static void main(String args[]){
        int a[]={2,3,4,5};
        solve(a);
    }


    public static int[] solve(int[] A) {
        int n=A.length;

        int maxValue=Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            maxValue=Math.max(maxValue,A[i]);
        }
        int[] spf=simplestPrimeFactor(maxValue);
        int a[]=new int[n];

        for(int i=0;i<n;i++){
            a[i]=countFactors(A[i],spf);
        }

        return a;


    }

    public static int countFactors(int n,int[] spf){
        int totalFactors=1;
        while(n>1){
            int c=0;
            int p=spf[n];
            while(n%p==0){
                c++;
                n=n/p;
            }

            totalFactors=totalFactors*(c+1);

        }
        return totalFactors;

    }


    public static int[] simplestPrimeFactor(int n){
        int[] a=new int[n+1];

        for(int i=0;i<=n;i++){
            a[i]=i;
        }

        for(int i=2;i*i<=n;i++){

            if(a[i]==i){

                for(int j=i*i;j<=n;j=j+i){

                    a[j]=Math.min(a[j],i);
                }



            }

        }
        return a;

    }
}
