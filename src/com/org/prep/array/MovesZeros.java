package com.org.prep.array;

public class MovesZeros {


    public static void main(String[] args) {

        int[] a={0,1,0,3,12};
        movesZeros(a);
    }

    public static void movesZeros(int[] a) {
        int n=a.length;
        int start=0;
        int end=n-1;

        while(start<end) {
            if(a[start]==0 && a[end]!=0) {
                a[start]=a[end];
                a[end]=0;
                end--;
                start++;
            }else{
                start++;
            }


        }
    }
}
