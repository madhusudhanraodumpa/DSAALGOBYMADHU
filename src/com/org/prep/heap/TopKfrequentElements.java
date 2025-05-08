package com.org.prep.heap;

import java.util.Collections;
import java.util.*;

public class TopKfrequentElements {
    public static void main(String[] args) {
        int a[]={4,1,-1,2,-1,2,3};
        int[] ans=topKFrequent(a,2);
    }
    public static int[] topKFrequent(int[] a, int k) {
        int n=a.length;
        Map<Integer,Integer> countMap=new HashMap<>();
        for (int i=0;i<n;i++){
            countMap.put(a[i],countMap.getOrDefault(a[i],0)+1);
        }

        List<Integer>[] list = new List[a.length];
        for(int i = 0; i<a.length; i++){
            list[i] = new ArrayList<>();
        }
        for(int key : countMap.keySet()){
            list[countMap.get(key)-1].add(key);
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
}
