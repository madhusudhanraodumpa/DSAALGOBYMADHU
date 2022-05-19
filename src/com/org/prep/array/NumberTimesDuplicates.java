package com.org.prep.array;

import java.util.Arrays;

public class NumberTimesDuplicates {

    public static void main(String args[]){
        int a[]={1,3,4,1,2};
        System.out.println(numberOfTimes(a));
       // Arrays.binarySearch()
    }
    public static int numberOfTimes(int a[]){

        int n=a.length;
        int count=0;
        int maxIndex=-1;
       for(int i=0;i<n;i++){
           if(a[i]<n){
               a[a[i]]=a[a[i]]+n;
           }else{
               if(a[i]<n*2){
                   int rem=a[i]%n;
                   a[rem]=a[rem]+n;
                   if(a[rem]>n*2){
                       return a[rem]/n;
                   }
               }else{
                   return a[i]/n;
               }

           }


       }
        return -1;



    }
}
