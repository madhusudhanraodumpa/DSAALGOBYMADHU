package com.org.prep.array;

import java.util.Arrays;

public class MinmumDifferenceOfTriplet {


    public static void main(String args[]){
        int[] a={5,2,8};
        int[] b={10,7,12};
        int c[]={9,14,6};
        minTriplet(a,b,c);
    }

    public static int[]  minTriplet(int[] a,int[] b,int[] c){

        int i=0,j=0,k=0;

        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);
        int n=a.length;
        int diff=Integer.MAX_VALUE;
        int[] res=new int[3];
        while (i<n && j<n && k<n){

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
}
