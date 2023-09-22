package com.org.prep.dp;

public class MaxProductSubArray {
    public static void main(String[] args){
        MaxProductSubArray m=new MaxProductSubArray();
        int a[]={1,-2,-5};
        System.out.println(m.maxProduct(a));
    }
    public int maxProduct(int nums[]){
        int n=nums.length;
        int prefixProduct[]=new int[n];
        int max=Integer.MIN_VALUE;
        int product1=1;
        int product2=1;
        int i=0;
        int j=n-1;
        while(i<n&&j>=0){
            product1=product1*nums[i];
            product2=product2*nums[j];
            max=Math.max(max,Math.max(product1,product2));
            if(product1==0){
                product1=1;
            }
            if(product2==0){
                product2=1;
            }
            i++;
            j--;
        }
        return max;
    }
}
