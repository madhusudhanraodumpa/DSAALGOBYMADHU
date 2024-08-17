package com.org.prep.array;

import java.util.*;

public class TopKFrequentElements {
    public static void main(String[] args) {
        int a[]= {1,1,1,1,2,2,3};
        int k=2;

       int[] result =  topKFrequentElementsBuketSort(a,k);
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

    public static int[] topKFrequentElements1(int[] a,int k) {


        int n=a.length;
        Map<Integer,Integer> countMap=new HashMap<>();
        for (int i=0;i<n;i++){
            countMap.put(a[i],countMap.getOrDefault(a[i],0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> maxHeap=new PriorityQueue<>((x,y)->y.getValue()-x.getValue());

        for (Map.Entry<Integer,Integer> entry: countMap.entrySet()) {
            maxHeap.add(entry);
        }
        int[] outPut=new int[k];
        for(int i=0;i<k;i++) {
            outPut[i]=maxHeap.poll().getKey();
        }
        return outPut;


    }

    public static int[] topKFrequentElementsBuketSort(int[] a,int k) {
        //https://www.youtube.com/watch?v=YPTqKIgVk-k

        int n=a.length;
        Map<Integer,Integer> countMap=new HashMap<>();
        for (int i=0;i<n;i++){
            countMap.put(a[i],countMap.getOrDefault(a[i],0)+1);
        }

        List<Integer>[] list = new List[a.length+1];
        for(int i = 0; i<=a.length; i++){
            list[i] = new ArrayList<>();
        }
        for(int key : countMap.keySet()){
            list[countMap.get(key)].add(key);
        }
        int res[] = new int[k];
        for(int i = list.length-1; i>=0; i--){
            for(int j = 0; j<list[i].size(); j++){
                res[--k]=list[i].get(j);
                if(k==0){
                    return res;
                }
            }
        }
        return res;


    }

    public static int[] topKFrequentElementsBuketSort1(int[] a,int k) {
        int n=a.length;
        Map<Integer,Integer> countMap=new HashMap<>();
        for (int i=0;i<n;i++){
            countMap.put(a[i],countMap.getOrDefault(a[i],0)+1);
        }

        List<Integer>[] list = new List[a.length];
        /**  for(int i = 0; i<a.length; i++){
         list[i] = new ArrayList<>();
         }*/
        for(int key : countMap.keySet()){
           if (list[countMap.get(key)-1] ==null) {
               list[countMap.get(key)-1] =new ArrayList<>();
           }
            list[countMap.get(key)-1].add(key);
        }
        int res[] = new int[k];
        for(int i = list.length-1; i>=0; i--){
            if(list[i]==null) continue;
            for(int j = 0; j<list[i].size(); j++){
                res[--k]=list[i].get(j);
                if(k==0){
                    return res;
                }
            }
        }
        return res;


    }
}