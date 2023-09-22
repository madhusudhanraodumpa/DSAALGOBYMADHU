package com.org.prep.array;

public class SumOfOddLengthSubarray {

    public static void main(String[] args) {

        int a[]={1,4,2,5,3};
        System.out.println(oddSum(a));
        System.out.println(evenSum(a));


    }

    private static int oddSum(int[] a) {
        int sum =0;
        int n=a.length;

        for (int i=0;i<n;i++) {
            int left = i+1;
            int right = n-i;

            sum=sum+((left*right+1)/2)*a[i];




        }
        return sum;

    }

    private static int evenSum(int[] a) {
        int sum =0;
        int n=a.length;

        for (int i=0;i<n;i++) {
            int left = i+1;
            int right = n-i;

            sum=sum+((left*right)/2)*a[i];



        }
        return sum;

    }
}
