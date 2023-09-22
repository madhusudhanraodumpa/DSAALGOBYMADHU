package com.org.prep.array;
import  java.util.*;

public class PairsDifference {

        public static void main(String args[]){
            int a[]={1,2};
            solve(a,0);
        }





    public static int solve(int[] A, int B) {
        int n=A.length;
        int p1=0;
        int p2=1;
        int count=0;
        Arrays.sort(A);
        while(p2<n){
            int diff=A[p2]-A[p1];
            if(diff==B){
                p1++;
                p2++;
                count++;
            }
           else  if(diff>B){
                p1++;
            }else{
                p2++;
            }
            while(p2<n && A[p2]==A[p2-1]){
                p2++;
                //p1=p2-1;
            }
            while(p1<n &&  p1>=1 && A[p1]==A[p1-1]){
                p1++;
                //p1=p2-1;
            }


        }
        return count;
    }
}
