package com.org.prep.array;

public class MinSwapdRequried {
    public static void main(String args[]){
        int a[]={1, 12, 10, 3, 14, 10, 5};
        System.out.println(solve(a,8));
    }

    public static int solve(int[] A, int B) {
        int n=A.length;
        int countB=0;
        for(int i=0;i<n;i++){
            if(A[i]<=B){
                countB++;
            }
        }


        int start=0;
        int end=0;
        int count=0;
        int minSwaps=Integer.MAX_VALUE;
        while(end<countB){
            if(A[end]<=B){
                count++;
            }
            end++;
        }
        minSwaps=Math.min(minSwaps,countB-count);

        while(end<n){

            if(A[end]<=B){
                count++;
            }

            if(A[start]<=B){
                count--;
            }

            minSwaps=Math.min(minSwaps,countB-count);
            start++;
            end++;
        }

        return minSwaps;

    }
}
