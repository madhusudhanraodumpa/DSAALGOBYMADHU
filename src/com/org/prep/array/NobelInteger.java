package com.org.prep.array;

import java.util.Arrays;

public class NobelInteger {
    public static void main(String[] args){
        int a[]={6,7,5};
        System.out.println(solve(a));
    }


    public static int solve(int[] A) {
        Arrays.sort(A);
        reverse(A);
        int count=0;
        if(A[0]==0){
            count++;
        }
        int less=-1;
        for(int i=1;i<A.length;i++){


            if(A[i]!=A[i-1]){
                less=i;
            }else{
                continue;
            }
            if(less==A[i]){
                count++;
            }





        }

        return count==0?-1:count;

    }
    public static void reverse(int[] A){
        int n=A.length;

        int left=0;
        int right=n-1;
        while(left<right){
            int temp=A[left];
            A[left]=A[right];
            A[right]=temp;
            left++;
            right--;


        }





    }
}
