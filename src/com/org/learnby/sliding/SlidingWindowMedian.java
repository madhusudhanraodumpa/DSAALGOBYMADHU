package com.org.learnby.sliding;

import java.util.PriorityQueue;

public class SlidingWindowMedian {
    public static void main(String args[]){
        SlidingWindowMedian slidingWindowMedian=new SlidingWindowMedian();
        int a[]={2147483647,1,2,3,4,5,6,7,2147483647};
        slidingWindowMedian.medianSlidingWindow(a,2);
    }
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((a, b)->a.compareTo(b));
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a,b)->b.compareTo(a));
    public double[] medianSlidingWindow(int[] nums, int k) {

        double[] result = new double[nums.length-k+1];
        for(int i=0;i<nums.length;i++){
            if(maxHeap.size()==0 || maxHeap.peek()>=nums[i]){
                maxHeap.add(nums[i]);
            }else{
                minHeap.add(nums[i]);
            }
            rebalanced();
            if(i-k+1>=0){
                result[i-k+1]=getMedian();
                int removedElement=nums[i-k+1];

                if(removedElement<=maxHeap.peek()){
                    maxHeap.remove(removedElement);
                }else{
                    minHeap.remove(removedElement);
                }
                rebalanced();
            }
        }
        return result;
    }

    public void rebalanced(){
//balancing
        if(maxHeap.size()>minHeap.size()+1){
            minHeap.add(maxHeap.peek());
            maxHeap.poll();
        }
        if(maxHeap.size()<minHeap.size()){
            maxHeap.add(minHeap.peek());
            minHeap.poll();
        }
    }
    public double getMedian(){
        if(maxHeap.size()==minHeap.size()){
            return (maxHeap.peek()+minHeap.peek())/2.0;
        }else{
            return maxHeap.peek()/1.0;
        }
    }
}
