package com.org.learnby.sorting;

import java.util.Arrays;
import java.util.stream.Collectors;

public class BubbleSort {
    public static void main(String args[]){

        int a[]={5,4,3,9,6,7,2,8};
        a=bubblesore(a);
        int b[]=bubblesoreOptimization(a);
        Arrays.stream(a).mapToObj(e->e+" ").forEach(System.out::print);
        System.out.println();
        Arrays.stream(b).mapToObj(e->e+" ").forEach(System.out::print);


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
}
