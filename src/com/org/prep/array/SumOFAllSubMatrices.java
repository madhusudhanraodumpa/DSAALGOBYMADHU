package com.org.prep.array;

public class SumOFAllSubMatrices {
    public static void main(String args[]){
        int arr[][] = {{1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}};
        System.out.println(sumOfSubMatrices(arr));
    }

    public static int sumOfSubMatrices(int a[][]){

        int n=a.length;
        int m=a[0].length;

        int sum=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int top_left=(i+1)*(j+1);
                int bottom_right=(n-i)*(m-j);
                sum=sum+a[i][j]*top_left*bottom_right;


            }
        }
        return sum;

    }
}
