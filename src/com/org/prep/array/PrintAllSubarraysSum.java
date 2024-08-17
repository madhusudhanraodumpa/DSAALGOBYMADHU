package com.org.prep.array;

public class PrintAllSubarraysSum {

    public static void main(String[] args) {
        int[] a={1,3,5};
        int n=a.length;
        int oddSubarraySum=0;
        for(int i=0;i<n;i++) {
            int sum=0;
            for(int j=i;j<n;j++) {
                sum =sum+a[j];
                System.out.println(sum);
                if(sum%2==1) {
                    oddSubarraySum++;
                }
            }
        }

        System.out.println(oddSubarraySum);



    }
}
