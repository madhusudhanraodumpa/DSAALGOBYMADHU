package com.org.prep.sorting;

import java.util.Arrays;

public class KthSmallestElement {

    public static void main(String args[]){
        int a[]={43, 31, 68, 21, 25, 4, 36, 76, 6, 25, 7};
        kthsmallest(a,3);
        Arrays.sort(a);

    }

    public static int kthsmallest(final int[] A, int B) {

        int n=A.length;

        for(int i=0;i<B;i++){
            int index=i;
            int min=A[i];

            for(int j=i;j<n;j++){


                if(min>A[j]){
                    index=j;
                    min=A[j];
                }
            }

            int temp=A[i];
            A[i]=A[index];
            A[index]=temp;



        }

        return A[B-1];
    }
}
