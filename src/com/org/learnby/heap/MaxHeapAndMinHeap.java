package com.org.learnby.heap;

import java.util.Scanner;

public class MaxHeapAndMinHeap {

    public static void main(String[] args) {
        int[] a = new int[8];
        Scanner sc = new Scanner(System.in);
        int element = 0;
        while (element < a.length) {
            int value = sc.nextInt();
            insert(a, element, value);
            element++;

        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(" " + a[i]);
        }
        System.out.println();
        int sizeofdeletednumber = sc.nextInt();

        int n = a.length;
        int iteration = 1;

        while (sizeofdeletednumber > 0) {

            delete(a, n);
            n = n - 1;

            System.out.print("After deletion of " + iteration + " iteration ");
            for (int i = 0; i < n; i++) {
                System.out.print(" " + a[i]);
            }
            System.out.println();

            sizeofdeletednumber--;
            iteration++;
        }

    }

    private static void insert(int[] a, int size, int value) {
        if (size == 0) {
            a[0] = value;
        } else {
            a[size] = value;
            int i = size;

            while (i > 0) {
                int parent = (int) Math.floor((i - 1) / 2);
                if (a[parent] > a[i]) {
                    int temp = a[parent];
                    a[parent] = a[i];
                    a[i] = temp;

                    i = parent;
                } else {
                    return;
                }


            }


        }


    }

    private static void delete(int[] a, int n) {
        a[0] = a[n - 1];
        n = n - 1;
        CompareWithChildrens(a, n);


    }

    private static void CompareWithChildrens(int[] a, int n) {
        int i = 0;

        while (i < n) {

            int parent = i;
            int lefthChild = 2 * i + 1;
            int rigthChild = 2 * i + 2;
            if (lefthChild < n && rigthChild < n) {
                int minChild = a[lefthChild] < a[rigthChild] ? lefthChild : rigthChild;
                if (a[minChild] < a[i]) {
                    int temp = a[minChild];
                    a[minChild] = a[parent];
                    a[parent] = temp;
                    i = minChild;
                }
            } else {
                return;
            }


        }


    }
}
