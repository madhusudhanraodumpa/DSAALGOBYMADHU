package com.org.learnby.sorting;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String args[]) {
        int a[] = {5, 4, 3,1, 9, 6, 7, 2, 8};
        a=insertionsort(a);
        Arrays.stream(a).mapToObj(e->e+" ").forEach(System.out::print);

    }

    //worst case o(n2)
    //best case a(n);
    public static int[] insertionsort(int a[]){

        for(int i=1;i<a.length-1;i++){
            int j=i-1;
            int temp=a[i];
            for(;j>=0 && a[j]>temp ;j--){
                    a[j+1]=a[j];

            }
            a[j+1]=temp;
        }
        return a;
    }
}
