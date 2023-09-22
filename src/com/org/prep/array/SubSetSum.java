package com.org.prep.array;

public class SubSetSum {

    public int solve(int[] A, int B) {

        int n=A.length;

        for(int i=0;i<(1<<n);i++){

            int sum=0;

            for(int j=0;j<n;j++){

                if(((i>>j)&1)==1){
                    sum=sum+A[j];
                }

            }
            if (sum==B){
                return 1;
            }
        }

        return 0;
    }

}
