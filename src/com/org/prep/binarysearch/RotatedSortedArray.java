package com.org.prep.binarysearch;

public class RotatedSortedArray {
    public static void main(String[] args) {
        int a[]={1, 7, 67, 133, 178};
        int b=1;
        System.out.println(search(a,b));


    }
    public static int search(final int[] A, int B) {

        int n=A.length;
        int l=0;
        int h=n-1;
        int k=-1;
        while(l<=h){
            int m=(l+h)/2;
            if(A[m]<A[0]){
                k=m;
                h=m-1;
            }else {
                l=m+1;
            }

        }
        if(k==-1){
            k=n;
        }
        System.out.println("k= "+k);
        if(A[0]<=B){
            l=0;
            h=k-1;
        }
        else{
            l=k;
            h=n-1;
        }

        int ans=-1;
        while(l<=h){
            int m=(l+h)/2;
            if(A[m]==B) return m;
            if(A[m]>B){
                h=m-1;
            }else{
                l=m+1;
            }


        }
        return ans;

    }
}
