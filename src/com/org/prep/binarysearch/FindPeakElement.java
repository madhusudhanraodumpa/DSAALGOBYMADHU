package com.org.prep.binarysearch;

public class FindPeakElement {

    public static void main(String args[]){
        int a[]={1, 1000000000, 1000000000};
        System.out.println(solve(a));
    }


    public static int solve(int[] A) {


        return A[peakIndex(A)];
    }

    public static int peakIndex(int A[]){
        int n=A.length;
        if(n==1 || A[0]>A[1]) return 0;
        if(A[n-1]>=A[n-2]) return n-1;

        int l=1;
        int h=n-2;

        while(l<=h){
            int mid=(l+h)/2;

            if(A[mid-1]<A[mid] && A[mid]>A[mid+1]){
                return mid;
            }else if(A[mid]<A[mid+1]){
                l=mid+1;
            }else{
                h=mid-1;
            }




        }

        return -1;



    }
}
