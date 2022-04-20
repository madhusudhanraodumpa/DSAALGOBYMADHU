package com.org.prep.sliding;

import java.util.Deque;
import java.util.LinkedList;

public class Maximumofallsubarraysofsizek {

    public static void main(String args[]) {
        int a[] = {1,3,1,2,0,5};
        int window[] = maximumOfAllsubArrays(3, a);
    }

    public static int[] maximumOfAllsubArrays(int k, int a[]) {
        if(a.length==0){
            int arr[]=new int[0];
            return arr;
        }

        int start = 0;
        int end = 0;

        int[] window = new int[a.length - k + 1];
        Deque<Integer> dq = new LinkedList<>();
        while (end < a.length) {
            while (!dq.isEmpty() && a[end] > dq.peekLast()) {
                dq.pollLast();
            }
            dq.offerLast(a[end]);


            if (end - start + 1 < k) {
                end++;
            }
          else if (end - start + 1 == k) {

                window[start] = dq.peekFirst();
                if (a[start] == dq.peekFirst()) {
                    dq.pollFirst();
                }
                start++;
                end++;
            }
        }


        return window;
    }
}
