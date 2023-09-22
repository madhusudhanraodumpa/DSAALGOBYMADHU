package com.org.prep.array;

public class RangeSumQueryMutable {
    public static void main(String args[]) {
        int a[][] = {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        NumMatrix1 numMatrix1 = new NumMatrix1(a);
        numMatrix1.sumRegion(2, 1, 4, 4);
        numMatrix1.update(3, 2, 2);
    }
}
class NumMatrix1 {

    int[][] mat;
    int[][] a;
    public NumMatrix1(int[][] matrix) {
        mat=matrix;
        a=calculatePrefixSumMatrix(mat);
    }

    public void update(int row, int col, int val) {
        //  mat[row][col]=val;
        //a=calculatePrefixSumMatrix(mat);


        int difference = val -  mat[row][col];
        mat[row][col] = val;
        int x=difference;
        for(int j = col; j < a[0].length; j++) {
            for(int i=row;i<a.length;i++) {
                a[i][j] = a[i][j] + x;
            }
        }

    }

    public int sumRegion(int a1, int b1, int a2, int b2) {
        int sum=a[a2][b2];

        if(b1!=0){
            sum=sum-a[a2][b1-1];
        }
        if(a1!=0){
            sum=sum-a[a1-1][b2];
        }
        if(a1!=0 && b1!=0){
            sum=sum+a[a1-1][b1-1];
        }
        return sum;

    }

    public static int[][] calculatePrefixSumMatrix(int[][] a){
        int n=a.length;
        int m=a[0].length;
        int mat[][]=new int[n][m];

        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=0;j<m;j++){
                sum=sum+a[i][j];
                mat[i][j]=sum;
            }
        }

        for(int j=0;j<m;j++){
            int sum=0;
            for(int i=0;i<n;i++){
                sum=sum+mat[i][j];
                mat[i][j]=sum;
            }
        }

        return mat;


    }
}
