package com.org.leetcode.heap;

import com.org.learnby.heap.MaxHeap;
import com.org.learnby.heap.MinHeap;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianfromDataStream_295 {
    PriorityQueue<Integer> maxHeap = null;
    PriorityQueue<Integer> minHeap = null;


    int countL = 0;
    int countR = 0;
    double median = 0;

    public FindMedianfromDataStream_295() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();

    }

    public static void main(String args[]) {
        int arr[] = {1,2};
        FindMedianfromDataStream_295 f = new FindMedianfromDataStream_295();

        for (int i = 0; i < arr.length; i++) {

            f.addNum(arr[i]);

        }
        System.out.println(" median is "+f.findMedian());
    }

    public void addNum(int num) {

        /*if (maxHeap.size() == 0 && minHeap.size() == 0) {
            maxHeap.add(num);
            median = maxHeap.peek();
        } else if (maxHeap.size() == 0 || minHeap.size() == 0) {
            if (maxHeap.peek() < num) {
                minHeap.add(num);
            } else {
                int temp = maxHeap.remove();
                maxHeap.add(num);
                minHeap.add(temp);
            }
            median=(double)(maxHeap.peek()+minHeap.peek())/2;
        }else{
                if(maxHeap.size()==minHeap.size()){
                    if(maxHeap.peek()<num) {
                        minHeap.add(num);
                        median = minHeap.peek();
                    }else{
                        maxHeap.add(num);
                        median=maxHeap.peek();
                    }
                }else if(maxHeap.size()<minHeap.size()){
                    if(maxHeap.peek()<num){
                        minHeap.add(num);
                        int temp=minHeap.poll();
                        maxHeap.add(temp);
                    }else{
                        maxHeap.add(num);

                    }
                    median=(double)(maxHeap.peek()+minHeap.peek())/2;


                }else if (maxHeap.size()>minHeap.size()){
                    if(maxHeap.peek()<num){
                        minHeap.add(num);
                    }else{
                        maxHeap.add(num);
                        int temp=maxHeap.poll();
                        minHeap.add(temp);
                    }
                    median=(double)(maxHeap.peek()+minHeap.peek())/2;
                }


        }*/
        if(maxHeap.size()==0 || maxHeap.peek()>num){
            maxHeap.add(num);
        }else{
            minHeap.add(num);
        }
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

    public double findMedian() {
        //return median;
        if((maxHeap.size()+minHeap.size())%2==0){
            return maxHeap.peek()/2.0+minHeap.peek()/2.0;
        }else {
            return maxHeap.peek();
        }

    }



}
