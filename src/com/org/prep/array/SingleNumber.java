package com.org.prep.array;

public class SingleNumber {
    public static void main(String args[]){
        int a[]={1, 2, 2, 3, 1};
        System.out.println(singleNumber(a));


    }
    public static int singleNumber(int a[]){
        int n=a.length;
        int num=a[0];
        for(int i=1;i<n;i++){
            num=num^a[i];
        }
        return num;
    }
}
