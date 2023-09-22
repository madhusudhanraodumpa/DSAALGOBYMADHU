package com.org.prep.array;

import java.util.Arrays;

public class MinmumDifferenceOfTriplet {


    public static void main(String args[]){
        int[] a={1, 4, 5, 8, 10};
        int[] b={6,9,15};
        int c[]={2,3,6,6};
        System.out.println(minTriplet(a,b,c));// its different size of arrays
       // System.out.println(minTriplet1(a,b,c));// its same size of arrays
        System.out.println();
    }

    public static int[] minTriplet1(int[] a,int[] b,int[] c) {
        int n = a.length;
        int i=0;
        int j=0;
        int k=0;
        int diff= Integer.MAX_VALUE;
        int[] res=new int[n];
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);

        while (i<n && j<n && k<n) {

            int max=Math.max(a[i],Math.max(b[j],c[k]));
            int min = Math.min(a[i],Math.min(b[j],c[k]));

            if(diff>max-min) {
                diff = max-min;
                res[0]=a[i];
                res[1] = b[j];
                res[2] = c[k];
            }

            if(a[i]==min){
                i++;
            } else if (b[j]==min) {
                j++;
            }else {
                k++;
            }


        }

        return res;

    }

    public static int[]  minTriplet(int[] a,int[] b,int[] c){

        int i=0,j=0,k=0;

        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);
        int n=a.length;
        int diff=Integer.MAX_VALUE;
        int[] res=new int[3];
        while (i<a.length && j<b.length && k<c.length){

            int min=Math.min(a[i],Math.min(b[j],c[k]));
            int max=Math.max(a[i],Math.max(b[j],c[k]));
            int total=a[i]+b[j]+c[k];
            if(a[i]==min){
                i++;
            }else if(b[j]==min){
                j++;
            }else{
                k++;
            }

            if(diff>(max-min)){
                diff=max-min;
                res[0]=max;
                res[1]=min;
                res[2]=total-(max+min);

            }


        }

        return res;



    }

    public static int solve(int[] A, int[] B, int[] C) {
        Arrays.sort(A);
        Arrays.sort(B);
        Arrays.sort(C);
        int minDiff=Integer.MAX_VALUE;
        int a=A.length;
        int b=B.length;
        int c=C.length;
        int i=0,j=0,k=0;

        while(i<a && j<b && k<c){
            int max=Math.max(A[i],Math.max(B[j],C[k]));
            int min=Math.min(A[i],Math.min(B[j],C[k]));
            System.out.println(max);
            System.out.println(min);

            minDiff=Math.min(minDiff,Math.abs(max-min));

            if(min==A[i]) i++;
            else if(min == B[j]) j++;
            else k++;


        }

        return minDiff;
    }

}
