package com.org.prep.binarysearch;

public class MatrixMedian {
    public static void main(String[] args){
        int[][] a={ {2},
                {1},
                {4},
                {1},
                {2},
                {2},
                {5}};
        System.out.println(findMedian(a));
    }
    public static int findMedian(int[][] A) {
        int n=A.length;
        int m=A[0].length;
        int l=0;
        int h=10;
        while(l<=h){
            int mid=(l+h)/2;
           int count=0;//numberLessThanOrEqual(A,n,m,mid);
            for (int i = 0; i < n; i++) {
                count += countSmallerThanMid(A[i], mid, m);
            }
            if(count<=((n*m)/2)){
                l=mid+1;
            }else{
                h=mid-1;
            }



        }
        return l;
    }
    public static int numberLessThanOrEqual(int[][] A,int n,int m,int val){
        int i=0;
        int j=m-1;
        int count=0;

        while(i<n && j<m && i>=0 && j>=0){

            if(A[i][j]<=val){
                count=count+j+1;
                i++;
            }else {
                j--;
            }

        }
        return count;
    }
    public static int countSmallerThanMid(int[] A, int val, int n) {
        int l = 0, h = n - 1;
        int ans=0;
        while (l <= h) {
            int md = (l + h) / 2;
            if (A[md] <= val) {
                ans=md+1;
                l = md + 1;
            } else {
                h = md - 1;
            }
        }
        return ans;
    }
}
