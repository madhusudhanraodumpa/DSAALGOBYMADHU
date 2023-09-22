package com.org.prep.bits;

public class SumOfXorPairs {
    public static void main(String args[]){
        int a[]={3,5,6,8,2};
       System.out.println(sum(a));
    }

    public static int sum(int a[]){
        int n=a.length;

        int ans=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                ans=ans+(a[i]^a[j]);
            }
        }

        return ans*2;
    }
}
