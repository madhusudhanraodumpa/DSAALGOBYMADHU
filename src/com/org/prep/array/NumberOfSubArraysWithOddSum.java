package com.org.prep.array;

public class NumberOfSubArraysWithOddSum {
    public static void main(String args[]){
        int[] a={1,3,5};
       // numOfSubarrays(a);

        String s="a";
        char s1='a';
        System.out.print(s1);
    }

    public static int numOfSubarrays(int[] arr) {


        int n=arr.length;
        long count=0;
        int even=0;
        int odd=0;
        /** int sum=0;
         for(int i=0;i<n;i++){
         sum=sum+arr[i];
         if(sum%2==0){
         count=count+odd;
         even++;
         }else{
         count=count+even+1;
         odd++;
         }

         }**/

        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
                sum=sum+arr[j];
                if(sum%2==1){
                    count++;
                }
            }

        }

        return (int)(count%1000000007);
    }
}
