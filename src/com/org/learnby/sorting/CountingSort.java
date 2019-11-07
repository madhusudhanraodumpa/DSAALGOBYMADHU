package com.org.learnby.sorting;

import java.util.Arrays;

public class CountingSort {

    public static void main(String args[]) {
        int a[] = {5, 4, 3,2,2,1,0,1,1,2,1,0,3,3,4,6};
        a=countingsort(a,6);
        Arrays.stream(a).mapToObj(e->e+" ").forEach(System.out::print);

    }

    private static int[] countingsort(int[] a,int maxelement) {

        int[] b=new int[maxelement+1];

        for(int i=0;i<a.length;i++){

            b[a[i]]=++b[a[i]];

        }
        int count=0;
        for(int i=0;i<b.length;i++){

            int valueCount=b[i];
            while(valueCount>0){
                a[count++]=i;
                valueCount--;
            }

        }

        return a;
    }
}
