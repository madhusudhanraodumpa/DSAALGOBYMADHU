package com.org.learnby.array;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestlementinanArray {


    public static void main(String args[]){
        int a[]={3,2,1,5,6,4};
        System.out.println(findKthLargest(a,2));

    }
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<nums.length;i++)
            pq.offer(nums[i]);

        int result=0;
        while(k>0){

            result=pq.peek();
            pq.poll();
            k--;
        }
        return result;
    }
}
