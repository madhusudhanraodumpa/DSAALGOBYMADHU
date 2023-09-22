package com.org.prep.array;
import java.util.*;

public class PairsWithGivenXor {

    public static void main(String args[]){
        int a[]={3, 6, 8, 10, 15, 50};
        solve(a,5);
    }


    public static int solve(int[] A, int B) {
        int n=A.length;
        Set<Integer> set=new HashSet<>();
        int x=0;
        int count=0;

        for(int i=0;i<n;i++){
            if (set.contains(B ^ A[i])){
                count++;
            }
            set.add(A[i]);
        }
        return count;
    }
}
