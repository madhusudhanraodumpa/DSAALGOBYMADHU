package com.org.prep.array;

import java.util.Arrays;

public class WiggleSortII {
    public static void main(String[] args){
        int a[]={1,3,2,2,3,1};
        wiggleSort(a);
    }


    public static int[] wiggleSort(int[] a){
        int n=a.length;
        int res[]=new int[n];
        int i=1;
        int j=n-1;
        Arrays.sort(a);
        while(i<n){
            res[i]=a[j--];
            i=i+2;
        }
        i=0;
        while(i<n){
            res[i]=a[j--];
            i=i+2;
        }
        i=0;

        while(i<n){
            a[i]=res[i];
            i++;
        }

        return a;
    }
}
