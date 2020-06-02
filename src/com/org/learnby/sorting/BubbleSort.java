package com.org.learnby.sorting;

import java.util.Arrays;
import java.util.stream.Collectors;

public class BubbleSort {
    public static void main(String args[]){

        int a[]={5,4,3,9,6,7,2,8};
       // a=bubblesore(a);
        //int b[]=bubblesoreOptimization(a);
        //bubblesortRecursion(a,a.length);
        bubblesortRecursionOpt(a,a.length,0);
        Arrays.stream(a).mapToObj(e->e+" ").forEach(System.out::print);
       // System.out.println();
        //Arrays.stream(b).mapToObj(e->e+" ").forEach(System.out::print);


    }

    private static int[] bubblesore(int[] a) {

        for(int i=0;i<a.length-1;i++){
            for(int j=0;j<a.length-1-i;j++){
                if(a[j]>a[j+1]){

                    int temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }

            }
        }
        return a;
    }
//Best case here is o(n)
    private static int[] bubblesoreOptimization(int[] a) {

        for(int i=0;i<a.length-1;i++){
            boolean thisIterationAnyElementSwapped=false;
            for(int j=0;j<a.length-1-i;j++){
                if(a[j]>a[j+1]){
                    thisIterationAnyElementSwapped=true;
                    int temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }

            }
            if(!thisIterationAnyElementSwapped){
                break;
            }
        }
        return a;
    }

    private static void bubblesortRecursion(int[] a,int n) {
        if(n==0){
            return;
        }
        for(int j=0;j<n-1;j++){
            if(a[j]>a[j+1]){
                int temp=a[j];
                a[j]=a[j+1];
                a[j+1]=temp;
            }
        }
        bubblesortRecursion(a,n-1);

    }

    private static void bubblesortRecursionOpt(int[] a,int n,int j) {
        if(n==0){
            return;
        }
        if(j<n-1) {
            if (a[j] > a[j + 1]) {
                int temp = a[j];
                a[j] = a[j + 1];
                a[j + 1] = temp;
            }
            bubblesortRecursionOpt(a,n,j+1);
        }

        bubblesortRecursionOpt(a,n-1,0);

    }
}
