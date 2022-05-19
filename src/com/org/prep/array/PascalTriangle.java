package com.org.prep.array;

import java.util.List;

public class PascalTriangle {
    public static void main(String args[]){
        pascalTriangle(6);
    }
    public static List<List<Integer>> pascalTriangle(int n){


        for(int i=0;i<n;i++){
            int val=1;
            for(int j=0;j<=i;j++){
                System.out.print(val+" ");
                int x=val*(i-j)/(j+1);
                val=x;
            }
            System.out.println();
        }

        return null;

    }
}
