package com.org.prep.backtracking;

public class UniquePathsII {
    public static int count=0;
    public static void main(String[] args){
        UniquePathsII u=new UniquePathsII();
        int[][] a={{0,0,0},{0,1,0},{0,0,0}};
        u.uniquePathsWithObstacles(a);
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {


        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;

        uniquePathsWithObstacles(obstacleGrid,0,0,m,n);
        System.out.println(count);
        return count;
    }

    public void uniquePathsWithObstacles(int[][] a,int i,int j,int m,int n) {


        if(i<0 || j<0) return;
        if(i>=m || j>=n) return;
        if(a[i][j]==1 || a[i][j]==2) return;

        if(i==m-1 && j==n-1){
            count++;
            return;
        }


        if(a[i][j]==0){
            a[i][j]=2;
            uniquePathsWithObstacles(a,i+1,j,m,n);
            uniquePathsWithObstacles(a,i,j+1,m,n);
            a[i][j]=0;
        }



    }
}
