package com.org.learnby.dynamicprograming;

public class FibonicBottomUpApproch {
    public static void main(String args[]){
        int a[]=new int[10];
        System.out.println(fibonic(a,6));
    }

    //Bottom Up approch.
    public static int fibonic(int a[],int n){

        a[0]=0;
        a[1]=1;
        for(int i=2;i<=n;i++){
            a[i]=a[i-1]+a[i-2];
        }
        return a[n];

    }
}
