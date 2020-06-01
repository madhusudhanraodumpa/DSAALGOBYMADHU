package com.org.learnby.recursion;

public class FirstOccurance {
    public static void main(String args[]){
        int a[]={1,2,3,4,5,6,7,8};
        System.out.println(firstOccur(a,0,a.length,7));

    }
    public static int firstOccur(int[] a,int start,int end,int key){

        if(start>end)
            return -1;
        if(a[start]==key){
            return start;
        }
        return firstOccur(a,start+1,end,key);

    }
}
