package com.org.prep.array;

public class MaxNumberOfOnesInRow {

    public static void main(String[] args) {
        int a[][] ={{0,0,0,0,0,1,1,1,1},{0,0,0,0,0,1,1,1,1},{0,0,0,0,0,1,1,1,1},{0,0,0,0,0,0,1,1,1},{0,0,0,0,0,0,1,1,1},{0,0,0,1,1,1,1,1,1},{0,0,0,0,1,1,1,1,1},{0,0,0,1,1,1,1,1,1},{0,0,0,1,1,1,1,1,1}};
        System.out.println(countMaxNumberOfOnes(a));
    }



    public static int countMaxNumberOfOnes(int[][] a) {

        int n=a.length;
        int m = a[0].length;
        int x=0;
        int y=m-1;
        int count=0;
        int ans=-1;
        int maxOfOnes = Integer.MIN_VALUE;
        int row=-1;
        while(x>=0 && y>=0) {

            if(a[x][y]==0) {
                if(maxOfOnes<((m-y-1))) {
                    maxOfOnes=m-y-1;
                    row=x;
                }
                x++;
            }else {
                y--;

            }

        }

        return row;

    }
}
