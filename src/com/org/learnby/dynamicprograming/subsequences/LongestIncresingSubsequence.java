package com.org.learnby.dynamicprograming.subsequences;

import java.util.ArrayList;
import java.util.List;

public class LongestIncresingSubsequence {
    public static void main(String args[]){
        int a[] = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(a));
    }
    public static  int lengthOfLIS(int[] a) {
        List<Integer> list=new ArrayList<>();
        List<Integer> result=new ArrayList<>();
        list.add(a[0]);
        result.add(a[0]);
        for(int i=1;i<a.length;i++){
            if(list.get(list.size()-1)<a[i]){
                list.add(a[i]);
                result.add(a[i]);
            }else{
                int index=findLoweBound(0,list.size()-1,a[i],list);
                list.remove(index);
                if(list.size()==0) {
                    result.remove(index);
                    result.add(a[i]);
                };
                list.add(index,a[i]);
            }
        }
        return list.size();
    }


    private static int findLoweBound(int start, int end, int value, List<Integer> list) {

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (list.get(mid) >= value) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
