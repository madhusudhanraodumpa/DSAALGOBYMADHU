package com.org.prep.array;

public class WiggleSortI {
    public static void main(String[] args){
        int a[]={3,5,2,1,6,4};
        wiggleSort(a);
    }


    public static int[] wiggleSort(int[] a){

        int n=a.length;
        for(int i=0;i<n-2;i++){


            if(i%2==0){
                if(a[i]>a[i+1]){
                    int temp=a[i];
                    a[i]=a[i+1];
                    a[i+1]=temp;
                }

            }else{
                if(a[i]<a[i+1]){
                    int temp=a[i];
                    a[i]=a[i+1];
                    a[i+1]=temp;
                }
            }
        }
        return a;

    }
}
