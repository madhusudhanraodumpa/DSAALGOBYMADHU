package com.org.prep.array;

public class SubarrayWithLeastAverage {
    public static void main(String args[]){
        int a[]={20, 3, 13, 5, 10, 14, 8, 5, 11, 9, 1, 11};
        System.out.println(solve(a,9));
    }


    public static int solve(int[] A, int B) {
        int n=A.length;

        int i=0;
        int minValue=Integer.MAX_VALUE;
        int index=0;
        int startIndex=0;
        int sum=0;
        while(i<B){
            sum=sum+A[i];
            i++;
        }
        if(minValue>sum){
            startIndex=index;
            minValue=sum;
        }
        while(i<n){

            sum=sum-A[index];
            sum=sum+A[i];

            index++;
            i++;
            if(minValue>sum){
                startIndex=index;
                minValue=sum;
            }
        }
        return startIndex;
    }
}
