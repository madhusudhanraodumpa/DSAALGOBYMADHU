package com.org.prep.array;

public class PrintAntiDigonal2D {
    public static void main(String args[]){
        int[][] A={{1,2,3},{4,5,6},{7,8,9}};
        diagonal(A);

    }


    public static int[][] diagonal(int[][] A) {
        int n=A.length;
        int m=A[0].length;
        int C[][]=new int[n+m-1][m];
        int z=0;
        for(int j=0;j<m;j++){
            int x=0;
            int y=j;
            int t=0;

            while(x<n && y>=0){
                C[z][t]=A[x][y];
                x++;
                y--;
                t++;

            }
            z++;


        }


        for(int i=1;i<n;i++){
            int x=i;int y=m-1;
            int t=0;
            while(x<n && y>=0){
                C[z][t]=A[x][y];
                x++;
                y--;
                t++;
            }
            z++;
        }
        return C;
    }
}
