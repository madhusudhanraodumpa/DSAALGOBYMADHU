package com.org.learnby.searching;

public class BinarySearchSqareRoot {

    public static void main(String args[]){
        int a[]={1,2,3,4,5,6,7,8,9};
        System.out.println(iterativeBinarySearchSquareRoot(a,0,a.length-1,10));


    }

    public static int iterativeBinarySearchSquareRoot(int a[],int s,int e,int searchElement){
        int ans=-1;
        while(s<=e){
            int mid=(s+e)/2;
            if(a[mid]*a[mid]>searchElement){
                e=mid-1;
            }else if(a[mid]*a[mid]<searchElement){
                s=mid+1;
                ans=mid;

            }
        }
        return ans;

    }
}
