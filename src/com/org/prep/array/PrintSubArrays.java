package com.org.prep.array;

public class PrintSubArrays {
    public static void main(String[] args) {
        int[] a={8,2,9};
        int n=a.length;
        for(int s=0;s<n;s++){
            for(int e=s;e<n;e++){
                for(int k=s;k<=e;k++){
                    System.out.print(a[k]+" ");
                }
                System.out.println();
            }

        }
    }
}
