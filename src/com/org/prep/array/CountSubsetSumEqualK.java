package com.org.prep.array;

public class CountSubsetSumEqualK {
    public static void main(String args[]){
        int a[]={3,5,6,7};
        numSubseq(a,9);
    }
    public static int numSubseq(int[] A, int B) {
        int n=A.length;
        int count=0;

        for(int i=0;i<(1<<n);i++){

            int minValue=Integer.MAX_VALUE;
            int maxValue=Integer.MIN_VALUE;

            for(int j=0;j<n;j++){

                if(((i>>j)&1)==1){
                    minValue=Math.min(minValue,A[j]);
                    maxValue=Math.max(maxValue,A[j]);
                }

            }
            if ((maxValue!= Integer.MIN_VALUE ) && (minValue!=Integer.MAX_VALUE) && (minValue+maxValue)<=B){
                count++;
            }
        }

        return count%1000000007;
    }
}
