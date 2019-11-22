package com.org.learnby.sorting;

public class QuickSort {
    public static void main(String args[]) {


        //int a[] = {3, 2, 5, 8, 1, 7, 4, 6};
        int a[] = {1, 2, 3, 4, 5, 6, 7, 8};

        quickSort(a, 0, a.length - 1);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

    }

    private static void quickSort(int[] a, int start, int end) {
        if (start < end) {
            int pivotIndex = partion(a, start, end);
            quickSort(a, start, pivotIndex - 1);
            quickSort(a, pivotIndex + 1, end);
        }
    }

    private static int partion(int[] a, int start, int end) {
        int pivot = a[start];

        int i = start;
        int j = end;
        while (i < j) {
            while (pivot >= a[i] && i < end) {
                i++;
            }
            while (pivot < a[j] && j > 0) {
                j--;
            }
            if (i < j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        int temp = a[start];
        a[start] = a[j];
        a[j] = temp;
        return j;
    }

}
