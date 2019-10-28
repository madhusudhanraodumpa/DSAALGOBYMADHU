package com.org.learnby;

public class LootoGame {
    public static void main(String args[]){
        int a[]={1,2,3,4,5,6};

        int n=6;

        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                for(int k=j+1;k<n;k++){
                    System.out.println(a[i]+" "+a[j]+" "+a[k]);
                }
            }
        }
    }
}
