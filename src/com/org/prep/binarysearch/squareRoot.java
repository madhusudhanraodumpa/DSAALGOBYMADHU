package com.org.prep.binarysearch;

public class squareRoot {
    public static void main(String[] args) {
        System.out.println(sqrt(2));
    }
    public static int sqrt(int A) {
        if(A==0) return A;
        int l=1;
        int h=A;
        int ans=-1;
        while(l<=h){
            int m=(l+h)/2;
            if(m*m==A) return m;
            else if(m*m>A){
                ans=m;
                h=m-1;
            }else {
                l=m+1;
            }
        }
        return ans;
    }
}
