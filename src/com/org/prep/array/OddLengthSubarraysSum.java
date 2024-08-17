package com.org.prep.array;

public class OddLengthSubarraysSum {
    public static void main(String[] args) {


        int arr[] = {1,4,2,5,3};
        int n=arr.length;
        int sum=0;
        for(int i=0;i<n;i++){
            int left=i+1;
            int right=n-i;
            sum=sum+((left*right+1)/2)*arr[i];
        }

//        int n=a.length;
//        int totalSum=0;
//
//        for(int i=0;i<n;i++) {
//            int sum=0;
//            for(int j=i;j<n;j++) {
//                sum=sum+a[j];
//                if(i==j) {
//                    totalSum=totalSum+sum;
//                }else if((i+j)%2==0) {
//                    totalSum= totalSum+sum;
//                }
//            }
//        }
        System.out.println(sum);
    }
}
