package com.org.prep.array;

public class MaxProductSubarray {

    public static void main(String[] args){
        int a[]={-1,-2,-3,0};
        System.out.println(maxProduct(a));
    }
    private static int maxProduct(int a[]){
       int leftProduct=1;
       int rightProduct=1;
       int n=a.length;
       int i=0;
       int j=n-1;
       int result=Integer.MIN_VALUE;
       while(i<n && j>=0){

           leftProduct =leftProduct*a[i];
           rightProduct = rightProduct*a[j];

           result=Math.max(result,Math.max(leftProduct,rightProduct));
           if(leftProduct==0){
               leftProduct=1;
           }
           if(rightProduct==1){
               rightProduct=1;
           }


           i++;
           j--;

       }

       return result;
    }

}
