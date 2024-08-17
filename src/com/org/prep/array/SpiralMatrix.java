package com.org.prep.array;

public class SpiralMatrix {

    public static void main(String[] args) {
        generateMatrix(3);
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
