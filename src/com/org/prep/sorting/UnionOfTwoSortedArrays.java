package com.org.prep.sorting;

public class UnionOfTwoSortedArrays {
    static int printUnion(int arr1[], int arr2[], int m, int n)
    {
        int i = 0, j = 0;
        while (i < m && j < n)
        {
            if (arr1[i] < arr2[j])
                System.out.print(arr1[i++]+" ");
            else if (arr2[j] < arr1[i])
                System.out.print(arr2[j++]+" ");
            else
            {
                System.out.print(arr2[j++]+" ");
                i++;
            }
        }

      /* Print remaining elements of
         the larger array */
        while(i < m)
            System.out.print(arr1[i++]+" ");
        while(j < n)
            System.out.print(arr2[j++]+" ");

        return 0;
    }

    public static void main(String args[])
    {
        int arr1[] = {2, 2, 3, 4,5};
        int arr2[] = {1, 1, 2, 4,5};
        int m = arr1.length;
        int n = arr2.length;
        printUnion(arr1, arr2, m, n);
    }
}
