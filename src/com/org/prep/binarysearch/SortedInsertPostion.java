package com.org.prep.binarysearch;

public class SortedInsertPostion {
    public static void main(String[] args) {
        int a[]={1, 3, 5, 6};
        System.out.println(searchInsert(a,7));
    }
    public static int searchInsert(int[] A, int B) {
        int n=A.length;
        int l=0;int h=n-1;
        int ans=-1;
        while(l<=h){
            int mid=(l+h)/2;
            if(A[mid]==B){
                return mid;
            }else if(A[mid]<B){
                l=mid+1;
                ans=l;
            }else{

                h=mid-1;
            }

        }
        return ans;

    }
}
