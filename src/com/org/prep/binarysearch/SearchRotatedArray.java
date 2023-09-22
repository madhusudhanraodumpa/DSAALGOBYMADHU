package com.org.prep.binarysearch;

public class SearchRotatedArray {

    public static void main(String args[]){
        int a[]={1, 7, 67, 133, 178};
        System.out.println(search(a,1));
    }

    public static int search(final int[] A, int B) {
        int n=A.length;
        int k = peakIndex(A,B);

        if(B<A[0] || k==0)
            return binarySearch(A,B,k,n-1);
        else
            return binarySearch(A,B,0,k-1);


    }

    public static int binarySearch(final int[] A, int B,int l,int h){

        while(l<=h){
            int mid=(l+h)/2;

            if(A[mid]==B) return mid;
            else if(A[mid]>B){
                h=mid-1;
            }else{
                l=mid+1;
            }
        }

        return -1;



    }
    public static int peakIndex(final int[] A, int B){
        int n=A.length;
        int l=0;int h=n-1;
        int ans=0;
        while(l<=h){
            int mid=(l+h)/2;

            if(A[mid]<A[0]){
                ans=mid;
                h=mid-1;

            }else{

                l=mid+1;
            }



        }
        return ans;


    }

}
