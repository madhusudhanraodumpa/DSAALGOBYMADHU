package com.org.learnby.searching;

public class BinarySearchPivotElement {
    public static void main(String args[]){
        int a[]={1,2,3,4,5};
        System.out.println(findPivotElement(a,0,a.length-1));
    }
    public static int findPivotElement(int[] a,int s,int e){

        int mid=(s+e)/2;
        if(s>e){
            return -1;
        }
        if(e>mid && a[mid]>a[mid+1]){
            return mid;
        }
        if(s <mid && a[mid]<a[mid-1]){
            return mid-1;
        }
        if(a[mid]<a[s]){
            return findPivotElement(a,s,mid-1);
        }else{
            return findPivotElement(a,mid+1,e);
        }


    }

}
