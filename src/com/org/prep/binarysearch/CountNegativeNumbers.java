package com.org.prep.binarysearch;

public class CountNegativeNumbers {
    public static void main(String[] args){
        int[][] a={{5,1,0},{-5,-5,-5}};
        countNegatives(a);
    }

    public static int countNegatives(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int i=n-1;
        int j=0;
        int count=0;
        while(i<n && j<m && i>=0 && j>=0){

            if(grid[i][j]<0){
                count=count+(n-j);
                i--;
            }else{
                j++;
            }

        }

        return count;


    }
}
