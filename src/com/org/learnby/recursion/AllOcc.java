package com.org.learnby.recursion;

public class AllOcc {
    public static void main(String args[]){
        int a[]={7,2,7,4,5,6,7,7};
        int out[]=new int[a.length];
       int x=allOcc(a,0,a.length,7,out,0);
       System.out.println("count is:= "+x);
       for(int i=0;i<x;i++){
           System.out.print(out[i]+" ");
       }

    }
    public static int allOcc(int[] a,int start,int end,int key,int[] out,int j){

        if(start==end)
            return j;
        if(a[start]==key){
            out[j]=start;
           return allOcc(a,start+1,end,key,out,j+1);
        }
        return allOcc(a,start+1,end,key,out,j);

    }
}
