package com.org.learnby.sorting;

public class MergeSort {
    public static void main(String args[]) {
        int a[] = {7, 2, 5, 4, 3, 6, 1};
        mergSort(a, 0, a.length-1);

        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }

    private static void mergSort(int[] a, int start, int end) {

        if (start < end) {
            int mid = (start + end) / 2;
            mergSort(a, start, mid);
            mergSort(a, mid + 1, end);
            merg(a, start, mid, end);
        }


    }

    private static void merg(int[] a, int start, int mid, int end) {
        int[] b = new int[end+start+1];

        int i = start;
        int j = mid + 1;
        int k = start;

        while (i <= mid && j <= end) {
            if (a[i] <= a[j]) {
                b[k] = a[i];
                i++;
            } else {
                b[k] = a[j];
                j++;
            }
            k++;
        }
        if (j > end) {
            while (i <= mid) {
                b[k] = a[i];
                i++;
                k++;
            }
        } else {
            while (j <= end) {
                b[k] = a[j];
                j++;
                k++;
            }
        }

        for (k = start; k <= end; k++) {
            a[k] = b[k];
        }
    }
}
