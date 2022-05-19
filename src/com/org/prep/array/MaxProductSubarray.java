package com.org.prep.array;

public class MaxProductSubarray {

    public static void main(String[] args){
        int a[]={2,4,-1,-5,6};
        System.out.println(maxProduct(a));
    }
    private static int maxProduct(int a[]){
        int max=Integer.MIN_VALUE;
        int product1=1;
        int product2=1;
        int left=0;
        int right=a.length-1;

        while (left<a.length && right>=0){
            product1=product1*a[left];
            product2=product2*a[right];
            max=Math.max(max,Math.max(product1,product2));

            if(product1==0){
                product1=1;
            }
            if(product2==0){
                product2=1;
            }

            left++;
            right--;
        }
    return max;
    }

}
