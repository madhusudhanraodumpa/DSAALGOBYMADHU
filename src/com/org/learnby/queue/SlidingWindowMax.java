package com.org.learnby.queue;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMax {
    public static void main(String args[]) {
        int a[] = {4, 3, 1, 2, 5, 3, 4, 7, 1, 9};
        int k = 4;
        int window[] = new int[a.length - k + 1];

        findWindowsMax(a, window, k, a.length);

        for (int x : window) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    private static void findWindowsMax(int[] a, int[] window, int k, int n) {

        Deque<Integer> dq = new LinkedList<>();
        int i;
        for (i = 0; i < k; i++) {
            while (!dq.isEmpty() && a[dq.peekLast()] <= a[i]) {
                dq.removeLast();
            }
            dq.addLast(i);


        }
        for (i = k; i < n; i++) {
            window[i - k] = a[dq.peekFirst()];
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.removeFirst();
            }

            while (!dq.isEmpty() && a[dq.peekLast()] <= a[i]) {
                dq.removeLast();
            }
            dq.addLast(i);

        }
        window[i - k] = a[dq.peekFirst()];
    }
}
