package com.org.prep.math;

public class LuckyNumber {
    public static void main(String args[]){
        solve(21);
    }

    public static int solve(int A) {

        int primeDivisor=0;
        int a[]=simplestPrimeFactor(A);
        for(int i=2;i<=A;i++){
            if(a[i]==2){
                primeDivisor++;
            }
        }
        return primeDivisor;
    }


    public static int[] simplestPrimeFactor(int n){
        int[] a=new int[n+1];
        for(int i=0;i<=n;i++){
            a[i]=0;
        }

        for(int i=2;i<=n;i++){

            if(a[i]==0){
                a[i]=a[i]+1;

                for(int j=i*2;j<=n;j=j+i){

                    a[j]=a[j]+1;
                }



            }

        }
        return a;

    }
}
