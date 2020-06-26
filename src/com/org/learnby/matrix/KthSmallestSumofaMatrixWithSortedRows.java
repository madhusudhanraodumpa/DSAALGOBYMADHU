package com.org.learnby.matrix;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthSmallestSumofaMatrixWithSortedRows {
    public static void main(String args[]){
        int a[][]={{1,10,10},{1,4,5},{2,3,6}};
        System.out.println(kthSmallest(a,7));
    }

    public static int kthSmallest(int[][] mat, int k) {
        Queue<Integer> maxHeap = new PriorityQueue<>(1,Collections.reverseOrder());
        maxHeap.offer(0);  // initial sum is zero
        for (int[] row : mat) {
            Queue<Integer> currMaxHeap = new PriorityQueue<>(Collections.reverseOrder());
            for (int preSum : maxHeap) {
                for (int i = 0; i < Math.min(row.length, k); i++) {
                    currMaxHeap.offer(preSum + row[i]);
                    if (currMaxHeap.size() > k) {
                        currMaxHeap.poll();
                    }
                }
            }
            maxHeap = currMaxHeap;
        }
        return maxHeap.poll();

    }
}
