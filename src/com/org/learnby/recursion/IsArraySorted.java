package com.org.learnby.recursion;

public class IsArraySorted {
    public static void main(String args[]){
        int a[]={1,2,3,41,5};
        System.out.println(isSorted(a,a.length));
    }

    private static boolean isSorted(int[] a, int length) {
        if(length==1 || length==0){
            return true;
        }
        return a[length-1]>a[length-2] && isSorted(a,length-1);
    }
}
