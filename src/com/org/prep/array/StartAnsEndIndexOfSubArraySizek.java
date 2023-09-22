package com.org.prep.array;

public class StartAnsEndIndexOfSubArraySizek {
    public static void main(String[] args) {
        int k =3;
        int a[] = {1,2,3,4,5,6,7,8,6,5,4,4,3,33,4,4,4};
        int n=a.length;
        int s=0;
        int e=k-1;
        while (e<n || s<=n-k) {
            System.out.println(s+" "+e);
            s++;
            e++;
        }
    }
}
