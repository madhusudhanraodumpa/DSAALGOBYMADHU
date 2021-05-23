package com.org.learnby.dynamicprograming;

import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class NthUglyNumber {
    public static void main(String args[]){
            System.out.println(nthUglyNumberIII(5,2,11,13));
        System.out.println(nthUglyNumberOpt(10));

    }
    public static int nthUglyNumber(int n){

        PriorityQueue<Integer> pq=new PriorityQueue<>();
        pq.add(1);
        Set<Integer> set= new HashSet<>();
        int value=0;
       while(set.size()<n){
            int x = pq.poll();
            pq.add(x*2);
            pq.add(x*3);
            pq.add(x*5);
            set.add(x);
            value = x;
        }

       return value;



    }

    public static int nthUglyNumberOpt(int n){

     int un[]=new int[n];
     int p2=0;
     int p3=0;
     int p5 =0;
        un[0]=1;
     for(int i=1;i<n;i++){
         int index= Math.min(un[p2]*2, Math.min(un[p3]*3,un[p5]*5));
         un[i] = index;

         if(index == un[p2]*2){
             p2 = p2+1;
         }
         if(index == un[p3]*3){
             p3 = p3+1;
         }
         if(index == un[p5]*5){
             p5 = p5+1;
         }

     }

    return un[n-1];

    }
    public static int superUglyNumber(int n, int[] primes){

        int un[]=new int[n];
        int p2=0;
        int p3=0;
        int p5 =0;
        un[0]=1;
        for(int i=1;i<n;i++){
            for(int j =0;j<primes.length;j++){

            }
            int index= Math.min(un[p2]*2, Math.min(un[p3]*3,un[p5]*5));
            un[i] = index;

            if(index == un[p2]*2){
                p2 = p2+1;
            }
            if(index == un[p3]*3){
                p3 = p3+1;
            }
            if(index == un[p5]*5){
                p5 = p5+1;
            }

        }

        return un[n-1];

    }
    public static   boolean isUgly(int num) {
        if(num < 1) return false;
        while(num > 1){
            if(num%2 == 0) num = num/2;
            else if(num%3 == 0) num = num/3;
            else if(num%5 == 0) num = num/5;
            else return false;
        }
        return true;
    }


    public static int nthUglyNumberIII(int n, int a, int b, int c) {
        long am = 1, bm = 1, cm = 1, cnt = 0, min = 1;
        while (cnt++ < n) {
            long an = am * a, bn = bm * b, cn = cm * c;
            min = Math.min(an, Math.min(bn, cn));
            if (an == min) am++;
            if (bn == min) bm++;
            if (cn == min) cm++;
        }
        return (int)min;
    }


}
