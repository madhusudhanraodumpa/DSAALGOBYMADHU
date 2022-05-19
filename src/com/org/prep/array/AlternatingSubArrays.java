package com.org.prep.array;

import java.util.ArrayList;
import java.util.List;

public class AlternatingSubArrays {

    public static void main(String[] args) {
        int a[]={0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 1};
        solve(a,1);
    }

    public static int[] solve(int[] A, int B) {
        int n = A.length;
               // if(index==1) return A;

        List<Integer> list = new ArrayList<>();

        for (int i = B; i < n - B; i++) {

            int value = A[i];
            boolean left = true;
            boolean rigth = true;

            for (int j = i - 1; j >= i - B; j--) {

                if (value != A[j]) {
                    value = A[j];
                } else {
                    left = false;
                    break;
                }


            }
            value = A[i];
            for (int j = i + 1; j < i + B + 1; j++) {
                if (value != A[j]) {
                    value = A[j];
                } else {
                    rigth = false;
                    break;
                }
            }


            if (left && rigth) {
                list.add(i);
            }

        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}
