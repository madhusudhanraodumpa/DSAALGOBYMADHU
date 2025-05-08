package com.org.prep.array;
import java.util.*;

public class SpiralMatrix {

    public static void main(String[] args) {
        int[][] a={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        spiralOrder(a);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        List<Integer> list = new ArrayList<>();

        if (n == m) {

            int i = 0;
            int j = 0;

            while (n > 1) {
                for (int k = 1; k <= n - 1; k++) {
                    list.add(matrix[i][j]);
                    j++;
                }
                for (int k = 1; k <= n - 1; k++) {
                    list.add(matrix[i][j]);
                    i++;
                }
                for (int k = 1; k <= n - 1; k++) {
                    list.add(matrix[i][j]);
                    j--;
                }
                for (int k = 1; k <= n - 1; k++) {
                    list.add(matrix[i][j]);
                    i--;
                }
                i++;
                j++;
                n = n - 2;
            }
            if (n == 1) {
                list.add(matrix[i][j]);
            }
        } else {

            int top = 0;
            int bottom = matrix.length - 1;
            if (matrix.length == 0)
                return new ArrayList<>(0);
            int left = 0;
            int right = matrix[0].length - 1;
            //List<Integer> list=new ArrayList<>();
            while (top <= bottom && left <= right) {
                for (int x = left; x <= right; x++) {
                    list.add(matrix[top][x]);
                }
                for (int x = top + 1; x <= bottom; x++) {
                    list.add(matrix[x][right]);
                }
                if (top < bottom && left < right) {
                    for (int x = right - 1; x >= left; x--) {
                        list.add(matrix[bottom][x]);
                    }

                    for (int x = bottom - 1; x >= top + 1; x--) {
                        list.add(matrix[x][left]);
                    }
                }

                left++;
                top++;
                bottom--;
                right--;

            }

        }
        return list;
    }

    public static int[][] generateMatrix(int n) {
        int[][] result=new int[3][3];
        int val=1;
        int i=0;
        int j=0;

        while(n>1) {

            for(int k=1;k<n;k++){
                result[i][j]=val++;
                j++;
            }
            for(int k=1;k<n;k++){
                result[i][j]=val++;
                i++;
            }

            for(int k=1;k<n;k++){
                result[i][j]=val++;
                j--;
            }

            for(int k=1;k<n;k++){
                result[i][j]=val++;
                i--;
            }

            n=n-2;

                i++;
                j++;

        }
        if(n==1) {

            result[i][j]=val++;
        }


        return result;


    }
}
