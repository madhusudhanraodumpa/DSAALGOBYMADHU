package com.org.leetcode.heap;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class SlidingWindowMaximum_239 {
    public static void main(String args[]){
        SlidingWindowMaximum_239 s=new SlidingWindowMaximum_239();
        int arr[]={1,3,-1,-3,5,3,6,7};
        Scanner sc=new Scanner(System.in);
        int window[]=s.maxSlidingWindow(arr,sc.nextInt());

        for(int i=0;i<window.length;i++){
            System.out.print(window[i]);
        }


    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==0){
            int arr[]=new int[0];
            return arr;
        }
        Deque<Integer> dq=new LinkedList<>();

        int[] window=new int[nums.length-k+1];
        int count=0;
        for(int i=0;i<k;i++){
            while(!dq.isEmpty() && nums[dq.peekLast()]<nums[i]){
                dq.pollLast();
            }
            dq.offerLast(i);
        }

        for(int i=k;i<nums.length;i++){
            window[count++]=nums[dq.peekFirst()];

            while (!dq.isEmpty() && dq.peekFirst()<=i-k){
                dq.pollFirst();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()]<nums[i]){
                dq.pollLast();
            }
            dq.offerLast(i);
        }
        if(dq!=null && dq.size()>0) {
            window[count++] = nums[dq.peekFirst()];
        }
        return window;
    }
}


