package com.org.prep.array;

public class MergeSortedArrays {
    public static void main(String args[]){

        int[] a={1,2,3,0,0,0};
        int[] b={2,5,6};
        merge(a,3,b,3);
    }



    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int i=0;
        int j=0;
        int[] a=new int[m+n];
        int k=0;
        while(i<m && j<n){

            if(nums1[i]>=nums2[j]){
                a[k]=nums2[j];
                j++;
            }else{
                a[k]=nums1[i];
                i++;
            }
            k++;



        }

        while(i<m){
            a[k]=nums1[i];
            i++;
            k++;
        }
        while(j<m){
            a[k]=nums2[j];
            j++;
            k++;
        }

        for(int t=0;t<m+n;t++){
            nums1[t]=a[t];

        }

    }
}
