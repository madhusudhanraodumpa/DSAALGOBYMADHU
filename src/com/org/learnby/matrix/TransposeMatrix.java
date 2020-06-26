package com.org.learnby.matrix;

public class TransposeMatrix {

    public static void main(String args[]){
        int[][] a={{1,2,3},{4,5,6},{7,8,9}};
        transpose(a);
        for (int i=0;i<a.length;i++){
            for(int j=0;i<a[0].length;j++){
                System.out.println(a[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static  int[][] transpose(int[][] A) {
        int R = A.length, C = A[0].length;
        int[][] ans = new int[C][R];
        for (int r = 0; r < R; ++r)
            for (int c = 0; c < C; ++c) {
                ans[c][r] = A[r][c];
            }
        return ans;
    }
}
