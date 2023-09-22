package com.org.prep.binarysearch;


public class MaximumCandiesAllocated {
    public static void main(String[] args){
        int[] a={4,7,5};
        maximumCandies(a,16);
    }
    public static int maximumCandies(int[] candies, long k) {
        int n=candies.length;
        long l=0;
        long h=0;
        int ans=0;
        for(int i=0;i<n;i++){
            h=h+candies[i];
        }

        h=h/k;
        if(h==0) return 0;
        while(l<=h){
            int m=(int)(l+h)/2;
            if(check(candies,n,m,k)){
                ans=m;
                l=m+1;
            }else{
                h=m-1;
            }
        }
        return ans;

    }
    public static boolean check(int[] candies,int n,int len,long children){

        long count=0;
        for(int i=0;i<n;i++){
            count=count+(candies[i]/len);
        }
        if(count>=children){
            return true;
        }
        return false;
    }
}
