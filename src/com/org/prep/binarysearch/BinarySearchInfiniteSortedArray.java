package com.org.prep.binarysearch;

public class BinarySearchInfiniteSortedArray {
    public static void main(String args[]){

        int a[]={3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170};
        System.out.println(findPosition(a,10));

    }
    public static int findPosition(int[] a, int k){
        int l=0;
        int h=1;
        while(a[h]<k){

            l=h;
            h=2*h;

        }

        while(l<=h){

            int m=(l+h)/2;
            if(a[m]==k) return m;
            else if(a[m]<k) {
                l=m+1;
            }else{
                h=m-1;
            }

        }


        return -1;
    }
}
