package com.org.prep.array;

import java.util.Arrays;

public class MaxTriplet {


    public static void main(String[] args) {
        int a[] = {5, 2, 8};
        int b[] = {10, 7, 12};
        int c[] = {9, 14, 6};
        maxTriplet1(a,b,c);

    }

    public static void maxTriplet(int[] a1,int[] a2,int[] a3) {
        int n= a1.length;
        int a=0;
        int b=0;
        int c=0;
        int minDiff = Integer.MAX_VALUE;
        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                for(int k=0;k<n;k++) {
                    int max= Math.max(a1[i],Math.max(a2[j],a3[k]));
                    int min= Math.min(a1[i],Math.min(a2[j],a3[k]));
                    int diff=max-min;
                    if(diff<minDiff) {
                        a=max;
                        b= a1[i]+a2[j]+a3[k]-(max+min);
                        c=min;
                        minDiff=diff;
                    }
                }
            }
        }

        System.out.println(a+" "+b+" "+c );
    }


    public static void maxTriplet1(int[] a1,int[] a2,int[] a3) {
        int n= a1.length;
        Arrays.sort(a1);
        Arrays.sort(a2);
        Arrays.sort(a3);

        int a=0;
        int b=0;
        int c=0;
        int minDiff = Integer.MAX_VALUE;
        int i=0,j=0,k=0;

        while (i<n && j<n && k<n) {
            int max= Math.max(a1[i],Math.max(a2[j],a3[k]));
            int min= Math.min(a1[i],Math.min(a2[j],a3[k]));
            int diff=max-min;
            if(diff<minDiff) {
                a=max;
                b= a1[i]+a2[j]+a3[k]-(max+min);
                c=min;
                minDiff=diff;
            }
            if(a1[i]==min) {
                i++;
            }else if(a2[j]==min) {
                j++;
            }else {
                k++;
            }
        }
        System.out.println(a+" "+b+" "+c );
    }
}
