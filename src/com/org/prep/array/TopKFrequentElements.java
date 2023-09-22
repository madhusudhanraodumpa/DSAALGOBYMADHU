package com.org.prep.array;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public static void main(String[] args) {
        int a[]= {1,1,1,1,2,2,3};
        int k=2;

       int[] result =  topKfrequentElements(a,k);
        System.out.println(result);
    }

    public static int[] topKfrequentElements(int a[],int k) {

        int n=a.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(a[i],map.getOrDefault(a[i],0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> heap = new PriorityQueue<>((x,y)->y.getValue()- x.getValue());

        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            heap.add(entry);
        }

        int[] result=new int[k];
        while (k>0){
            Map.Entry<Integer,Integer> entry = heap.remove();
            result[k-1] = entry.getKey();
            k--;
        }

        return result;

    }
}