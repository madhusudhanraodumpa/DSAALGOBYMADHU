package com.org.learnby.recursion;

public class BinarySearch {
    public static void main(String args[]){
        int a[]={1,2,3,4,5,6,7,8};
       System.out.println(binarySearch(a,2,0,a.length-1));
    }
    public static boolean binarySearch(int[] a,int x,int start,int end){
        if(start<=end) {
            int mid = (start + end) / 2;
            if (a[mid] == x)
                return true;
            if (a[mid] > x) {
                return binarySearch(a, x, start, mid);
            } else {
                return binarySearch(a, x, mid + 1, end);
            }
        }
        return false;
    }
}
