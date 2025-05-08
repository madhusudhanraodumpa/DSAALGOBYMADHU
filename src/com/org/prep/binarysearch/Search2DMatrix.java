package com.org.prep.binarysearch;

public class Search2DMatrix {
    public static void main(String[] args) {
        int[][] a={{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(searchMatrix(a,3));

    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;
        int l=0;
        int h=(n*m)-1;
        while(l<=h){
            int mid=(l+h)/2;
            int r=mid/m;
            int c=mid%m;

            if(matrix[r][c]==target) return true;
            else if (matrix[r][c]>target){
                h=mid-1;
            }else{
                l=mid+1;
            }

        }
        return false;

    }
    public static boolean searchMatrix1(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;
        int l=0;
        int h=n-1;
        while(l<=h){
            int mid = (l+h)/2;

            if(matrix[mid][0]<=target && matrix[mid][m-1]>=target){
                return search(matrix[mid],target);
            }else if(matrix[mid][m-1]>target){
                h=mid-1;
            }else{
                l=mid+1;
            }


        }
        return false;
    }
    public static boolean search(int[] a,int target){
        int n=a.length;
        int l=0;
        int h=n-1;
        while(l<=h){
            int m=(l+h)/2;
            if(a[m]==target) return true;
            if(a[m]>target){
                h=m-1;
            }else {
                l=m+1;
            }
        }
        return false;
    }
}
