package com.org.learnby.sliding;

import java.util.PriorityQueue;

public class SlidingWindowMedian {
    public static void main(String args[]) {
        SlidingWindowMedian slidingWindowMedian = new SlidingWindowMedian();
        int a[] = {2147483647,1,2,3,4,5,6,7,2147483647};

        slidingWindowMedian.medianSlidingWindow(a, 2);
    }

    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((a, b) -> a.compareTo(b));
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a, b) -> b.compareTo(a));

    public double[] medianSlidingWindow(int[] nums, int k) {

        double[] result = new double[nums.length - k + 1];
        int start = 0;
        int end = 0;

        while (end < nums.length) {
            if (maxHeap.isEmpty() || maxHeap.peek() >= nums[end]) {
                maxHeap.add(nums[end]);
            } else {
                minHeap.add(nums[end]);
            }
            rebalanced();

            if (end - start + 1 > k) {
                end++;
            } else if (end - start + 1 == k) {
                double median = getMedian();
                result[end - k + 1] = median;
                if (nums[start] <= maxHeap.peek()) {
                    maxHeap.remove(nums[start]);
                } else {
                    minHeap.remove(nums[start]);
                }
                start++;



            }
            end++;
        }

        return result;
    }

    public void rebalanced() {
//balancing
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.peek());
            maxHeap.poll();
        }
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.peek());
            minHeap.poll();
        }
    }

    public double getMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek()/2.0 + minHeap.peek()/2.0) ;
        } else if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek() / 1.0;
        } else {
            return minHeap.peek() / 1.0;
        }
    }
}
