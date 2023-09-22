package com.org.prep.math;

public class ReArrangeArray {
    public static void main(String[] args) {
        int a[] = {0,2,1,3};
        a = rearrange(a);
        System.out.println(a);
    }

    private static int[] rearrange(int[] a) {
        int n = a.length;
        for(int i=0;i<n;i++) {
            a[i]=a[i]*n;
        }

        for(int i =0;i<n;i++) {
            int oldValue=a[i]/n;
            int newValue=a[oldValue]/n;
            a[i]=a[i]+newValue;


        }
        for (int i=0;i<n;i++) {
            a[i]=a[i]%n;
        }
        return a;
    }
}
