package com.org.prep.heap;
import java.util.*;

public class MaxSumAFterBNegotations {
    public static void main(String[] args) {
        int a[]={24, -68, -29, -9, 84};
        System.out.println(solve(a,4));
    }
    public static int solve(int[] A, int B) {
        PriorityQueue<Integer> p=new PriorityQueue<>();
        int n=A.length;
        for(int i=0;i<n;i++){
            p.add(A[i]);
        }
        while(B>0){
            int a=p.poll();
            a=-(a);
            p.add(a);
            B--;
        }
        int sum=0;
        while(!p.isEmpty()){
            sum=sum+p.poll();
        }
        return sum;

    }

}
