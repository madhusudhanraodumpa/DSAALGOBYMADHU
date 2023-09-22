package com.org.prep.binarysearch;

import java.util.Arrays;

public class KthPrice {
    public static void main(String[] args){
        int a[]={52,60, 94, 63, 3, 86, 40, 93, 36, 56, 48, 17, 10, 23, 43, 77, 1, 1, 93, 79, 4, 10, 47, 1, 99, 91, 53, 99, 18, 61, 84, 10, 13, 3, 9, 78, 16, 7, 62,52};
        //Arrays.sort(a);
        System.out.println(a[22]);
        System.out.println(solve(a,22));
    }

    public static int solve(final int[] A, int B) {

        int n=A.length;
        for(int i=0;i<n;i++){

            int count=countLess(A,A[i],n);
            if(count==B){
                return A[i];
            }
        }
        return -1;
    }

    public static int countLess(int a[],int ele,int n){
        int count=0;
        for(int i=0;i<n;i++){
            if(a[i]<=ele){

                count++;
                if(a[i]==ele){
                    return count;
                }
            }
        }
        return count;
    }
}
