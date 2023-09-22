package com.org.prep.array;

public class EquilibriumIndex {

    public static void main(String args[]){
        int a[]={-7, 1, 5, 2, -4, 3, 0};
        solve(a);
    }


    public static int solve(int[] A) {
        int N= A.length;
        int[] pf=new int[N];
        pf[0]=A[0];
        for(int i=1;i<N;i++){
            pf[i]=pf[i-1]+A[i];
        }

        for(int i =0;i<N;i++){
            int leftSum=0;
            int rightSum=0;
            if(i==0){
                leftSum=0;
            }else{
                leftSum=pf[i-1];
            }
            rightSum = pf[N-1]-pf[i];

            if(leftSum==rightSum) return i;
        }

        return -1;

    }
}
