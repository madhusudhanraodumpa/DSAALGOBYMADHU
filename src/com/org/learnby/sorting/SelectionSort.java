package com.org.learnby.sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String args[]) {
    int a[] = {5, 4, 3,1, 9, 6, 7, 2, 8};
    a=selectionsort(a);
    Arrays.stream(a).mapToObj(e->e+" ").forEach(System.out::print);

    }

    private static int[] selectionsort(int[] a) {

        for(int i=0;i<a.length-1;i++){
            for(int j=i+1; j<a.length;j++){
                if(a[i]>a[j]){
                    int temp=a[i];
                    a[i]=a[j];
                    a[j]=temp;
                }


            }
        }

        return a;
    }


}