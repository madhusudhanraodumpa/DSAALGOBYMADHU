package com.org.learnby.array;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class EveneFibaonicSum {

    public static  void main(String args[]){

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            long n = in.nextInt();
            long sum=0;
            sum=sum+ 3*(((n-1)/3*(((n-1)/3)+1)))/2;
            sum=sum+ 5*(((n-1)/5*(((n-1)/5)+1)))/2;
            sum=sum-15*(((n-1)/15*(((n-1)/15)+1)))/2;

            System.out.println(sum);
        }
    }
}
