package com.org.learnby.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String rags[]){

        /*int a[][]={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> list=spiralOrder(a);
        for(Integer i:list){
            System.out.print(i+" ");
        }*/
        int a[][]=generateMatrix(3);
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(a[i][j]+" ");
            }
        }
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;

        int top=0;//r1
        int bottom=n-1; //r2
        int left=0;//c1
        int right=m-1;//c2
        int val=1;
        List<Integer> list=new ArrayList<>();
        while(top<=bottom && left<=right){
            for(int i=left;i<=right;i++){
                list.add(matrix[top][i]);
                val++;
            }
            top++;
            for(int i=top;i<=bottom;i++){
                list.add(matrix[i][right]);
                val++;
            }
            right--;
            for(int i=right;i>=left;i--){
                list.add(matrix[bottom][i]);
                val++;
            }
            bottom--;
            for(int i=bottom;i>=top;i--){
                list.add(matrix[i][left]);
                val++;
            }
            left++;


        }

        return list;
    }
    public static int[][] generateMatrix(int n) {
        int a[][]=new int[3][3];
        int r1=0;
        int r2=n-1;
        int c1=0;
        int c2=n-1;
        int count=1;

        while(r1<=r2 && c1<=c2){
            for(int x=c1;x<=c2;x++){
                a[r1][x]=count++;
            }
            for(int x=r1+1;x<=r2;x++){
                a[x][c2]=count++;
            }
            if(r1<r2 && c1<c2){
                for(int x=c2-1;x>=c1;x--){
                    a[r2][x]=count++;
                }
                for(int x=r2-1;x>=r1+1;x--){
                    a[x][c1]=count++;
                }
            }

            r1++;r2--;c1++;c2--;


        }



        return a;
    }
    public static int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int[][] dirt = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // east, south, west, north
        List<int[]> res = new ArrayList<>();
        int len = 0, d = 0; // move <len> steps in the <d> direction
        res.add(new int[]{r0, c0});
        while (res.size() < R * C) {
            if (d == 0 || d == 2) len++; // when move east or west, the length of path need plus 1
            for (int i = 0; i < len; i++) {
                r0 += dirt[d][0];
                c0 += dirt[d][1];
                if (r0 >= 0 && r0 < R && c0 >= 0 && c0 < C) // check valid
                    res.add(new int[]{r0, c0});
            }
            d = (d + 1) % 4; // turn to next direction
        }
        return res.toArray(new int[R * C][2]);

    }

    }

/**
 *  int[][] res= new int[R*C][2];
 *         res[0]=new int[]{r0, c0};
 *         int len=0, idx=1, k=0;
 *         int[] d= new int[]{0,1,0,-1,0};
 *         while (idx<R*C){
 *             len++;
 *             for (int round=0; round<2; round++){
 *                 for (int sz=len; sz>0; sz--){
 *                     r0+=d[k];
 *                     c0+=d[k+1];
 *                     if (r0<0 || r0>=R || c0<0 || c0>=C) continue;
 *                     res[idx++]=new int[]{r0, c0};
 *                 }
 *                 k=(k+1)%4;
 *             }
 *         }
 *         return res;
 */



/**
 * int idx;
 *     int[][] ret;
 *
 *     private void add (int r, int c, int R, int C) {
 *         if (r >= R || r < 0 || c >= C || c < 0) return;
 *         ret[idx][0] = r;
 *         ret[idx++][1] = c;
 *     }
 *
 *     public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
 *         int r = r0, c = c0, len = 1;
 *         ret = new int[R * C][2];
 *         while (idx < (R * C )) {
 *             for (int k = 0; k < len; k++) add(r, c++, R, C);
 *             for (int k = 0; k < len; k++) add(r++, c, R, C);
 *             len++;
 *             for (int k = 0; k < len; k++) add(r, c--, R, C);
 *             for (int k = 0; k < len; k++) add(r--, c, R, C);
 *             len++;
 *         }
 *         return ret;
 *     }
 *
 *
 *
 */