package com.org.prep.array;

public class ChristmasTrees {
    public static void main(String[] args) {
        int a[] = {1, 6, 4, 2, 6, 9};
        int[] b = {2, 5, 7, 3, 2, 7};
        int res = minCost(a, b);
        System.out.println(res);
    }

    private static int minCost(int[] a, int[] b) {

        int n = a.length;
        int j = 1;
        int minCost = Integer.MAX_VALUE;


        while (j < n - 1) {
            int i = 0;
            int costI = Integer.MAX_VALUE;
            int costK = Integer.MAX_VALUE;
            while (i < j) {

                if (a[i] < a[j]) {
                    costI = Math.min(costI, b[i]);
                }
                i++;
            }
            int k = j + 1;
            while (k < n) {
                if (a[j] < a[k]) {
                    costK = Math.min(costK, b[k]);
                }
                k++;
            }

            minCost = Math.min(minCost, costI + costK + b[j]);
            j++;
        }

        return minCost;
    }
}
