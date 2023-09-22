package com.org.prep.array;

import java.util.Arrays;
import java.util.Collections;

public class NobelInteger {
    public static void main(String[] args){
        int a[]={-4,-2,0,-1,-6};
        System.out.println(solve1(a));
    }

    public static int solve1(int[] A) {
        Arrays.sort(A);
       // reverse(A);
     //   Arrays.stream(A).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
        int n= A.length;
        int count  = 0;
        if((n-1) == A[0]) return 1;
        for(int i=1;i<n-1;i++){

            if(A[i]==A[i+1]) {
                continue;
            } else {
                count = n-(i+1);
            }
            if(count==A[i]) return 1;
        }

        return -1;
    }

    public static int solve(int[] A) {
    //    Arrays.sort(A,(b, a) -> Integer.compare(A[1], A[1]));
        Arrays.stream(A).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
       // reverse(A);
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
