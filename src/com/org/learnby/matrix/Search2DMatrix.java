package com.org.learnby.matrix;

public class Search2DMatrix {
    public static void main(String args[]){
        int a[][]={{1}};
        System.out.println(searchMatrix(a,1));

    }

    public static boolean searchMatrix(int[][] matrix, int target) {

        int rLenth=matrix.length;
        if(rLenth==0) return false;

        int cLength=matrix[0].length;
        int rStart=0;
        int cStart=cLength-1;
        boolean falg=false;
        while(rLenth>rStart && 0<=cStart){
            if(matrix[rStart][cStart]>target){
                cStart--;
            }else if(matrix[rStart][cStart]<target){
                rStart++;
            }else{
                return true;
            }

        }
        return falg;
    }
}
