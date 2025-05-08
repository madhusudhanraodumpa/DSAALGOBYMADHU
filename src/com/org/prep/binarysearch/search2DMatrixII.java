package com.org.prep.binarysearch;

public class search2DMatrixII {
    public static void main(String[] args) {
        int[][] a={{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        System.out.println(searchMatrix(a,5));

    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;
        int i=n-1;
        int j=0;
        while(i>=0 && j>=0 && i<n && j<m){
            if(matrix[i][j]<=target && matrix[i][m-1]>target){
                return  search(matrix[i],target)!=-1;
            }else {
                i--;
            }
        }
        return false;
    }
    public static int search(int[] a,int target){
        int n=a.length;
        int l=0;
        int h=n-1;
        while(l<=h){
            int m=(l+h)/2;
            if(a[m]==target) return m;
            else if(a[m]<target) {
                l=m+1;
            }else{
                h=m-1;
            }
        }
        return -1;
    }
}
