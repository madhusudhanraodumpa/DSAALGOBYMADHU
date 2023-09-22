package com.org.prep.array;

public class GreatestElementRightSide {

    public static void main(String args[]){
        int[] a={17,18,5,4,6,1};
        replaceElements(a);
    }
    public static int[] replaceElements(int[] arr) {
        int n=arr.length;
        int[] B=new int[n];
        B[n-1]=-1;
        int maxValue=arr[n-1];

        for(int i=n-2;i>=0;i--){

            B[i]=maxValue;
            maxValue=Math.max(maxValue,B[i]);




        }
        return B;

    }
}
