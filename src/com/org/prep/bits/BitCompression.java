package com.org.prep.bits;

public class BitCompression {
    public static void main(String args[]){
        int a[]={1,3,5};
        compressBits(a);
    }

    public static int compressBits(int[] A) {
        int ans=0;
        int n=A.length;
        for(int i=0;i<n-1;i++){
            int x=A[i]&A[i+1];
            int y=A[i]|A[i+1];
            A[i]=x;
            A[i+1]=y;
            ans=ans^x;


        }
        ans=ans^A[n-1];

        /** for(int i=0;i<n;i++){
         ans=ans^A[i];
         }**/
        return ans;

    }
}
