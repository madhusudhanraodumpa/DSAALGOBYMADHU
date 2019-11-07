package com.org.learnby.NumberTheory;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumberChecking {

    public static void main(String args[]){
        int n=25;
       /* for(int i=2;i<n-1;i++){
            if(n % i==0){
                System.out.print(n+" is Not prime number");
                return;
            }
        }*/

       //Getting prime numbers
       /* primeSeries(1000);
        System.out.println();
        betterPrimeSeries1(1000);
        System.out.println();

        betterPrimeSeries2(1000);

        System.out.println();

        betterPrimeSeries3(1000);

        primeFactroise(n);*/

        betterPrimeSeries3(100);

       primeFactroise(49);

    }

    private static void primeFactroise(int n) {

        List<Integer> primeList=primeList(n);
        List<Integer> primeFactorList=new ArrayList<>();

        int p=primeList.get(0);
        int i=0;
        int m=n;
        while(p*p<=n){

            if(m%p==0){
                primeFactorList.add(p);
                while(m%p==0){
                    m=m/p;
                }
            }
            p=primeList.get(++i);

        }
        if(m!=1){
            primeFactorList.add(n);
        }

        for(int k:primeFactorList){
            System.out.print(k+" ");
        }





    }

    private static List<Integer> primeList(int n) {
        int p[]=new int[n];
        p[0]=0;
        p[1]=0;
        p[2]=1;


        //Making all add number to 1 hence odd numbers can only prime not even number.
        for(int i=3;i<n;i+=2){
            p[i]=1;
        }

        //Checking odd number is prime or not.
        for(int i=3;i<n;i++){
            if(p[i]==1){
                for(int j=i*i;j<n;j+=2*i){
                    p[j]=0;
                }
            }
        }
        List<Integer> list=new ArrayList<>();
        list.add(2);
        for(int i=3;i<n;i+=2){
            if(p[i]==1){
            list.add(i);
            }
        }
        return list;
    }

    private static boolean isPrimeNumber(int n) {
        if(n%2==0){
            return false;
        }
        for(int i=3;i*i<=n;i+=2){
            if(n % i==0){
                return false;
            }
        }
        return true;
    }

    public static void primeSeries(int n){
        System.out.print(2+" ");
        for(int i=3;i<=n;i++){
          if(isPrimeNumber(i)){
              System.out.print(i+" ");
            }
        }
    }

    public static void betterPrimeSeries1(int n){
        int p[]=new int[n];
        p[0]=0;p[1]=0;

        for(int i=2;i<n;i++) p[i]=1;
        for (int i=2;i<n;i++){
            if(p[i]==1){
                for(int j=i*2;j<n;j+=i){
                    p[j]=0;
                }


            }
        }
        for(int i=2;i<n;i++){
            if(p[i]==1){
                System.out.print(i+" ");
            }
        }
    }

    public static void betterPrimeSeries2(int n){
        //all even number are not prime

        int p[]=new int[n];
        p[0]=0;p[1]=0;
        p[2]=1;

        //Making all add number to 1 hence odd numbers can only prime not even number.
        for(int i=3;i<n;i+=2){
            p[i]=1;
        }
        //Checking odd number is prime or not.
        for(int i=3;i<n;i++){
            if(p[i]==1){
                for(int j=2*i;j<n;j+=i){
                    p[j]=0;
                }
            }
       }
        for(int i=2;i<n;i++){
            if(p[i]==1){
                System.out.print(i+" ");
            }
        }


    }

    public static void betterPrimeSeries3(int n){
        //all even number are not prime

        int p[]=new int[n];
        p[0]=0;p[1]=0;
        p[2]=1;

        //Making all add number to 1 hence odd numbers can only prime not even number.
        for(int i=3;i<n;i+=2){
            p[i]=1;
        }
        //Checking odd number is prime or not.
        for(int i=3;i<n;i++){
            if(i*i>=n)
                break;
            if(p[i]==1){
                for(int j=i*i;j<n;j+=2*i){
                    p[j]=0;
                }
            }
        }
        for(int i=2;i<n;i++){
            if(p[i]==1){
                System.out.print(i+" ");
            }
        }


    }


}
