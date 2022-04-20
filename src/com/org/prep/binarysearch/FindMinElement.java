package com.org.prep.binarysearch;

public class FindMinElement {
    public static void main(String args[]){
        int a[]={2,1};
        System.out.println(findMin(a));
    }

    public static int findMin(int[] a) {
        // If the list has just one element then return that element.
        int n=a.length;
        if (a.length == 1) {
            return a[0];
        }


        int start = 0, end = a.length - 1;


        if (a[end] > a[0]) {
            return a[0];
        }


        while (end >= start) {

            int mid = start + (end - start) / 2;
            int next=(mid+1)%n;
            int prev=(mid+n-1)%n;
            if(a[mid]<=a[next] && a[mid]<=a[prev]){
                return a[mid];
            }

            if (a[end] > a[0]) {
                return a[start];
            }

            if (a[mid] >= a[start]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
