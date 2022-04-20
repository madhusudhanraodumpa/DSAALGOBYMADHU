package com.org.learnby.dynamicprograming.subsequences;

import java.util.ArrayList;
import java.util.List;

public class LongestIncresingSubsequence {
    public static void main(String args[]){
        //int a[] = {10,9,2,5,3,7,101,18};
        int a[] ={2,5,3,7,11,8,10,13,6};
        System.out.println(lengthOfLIS(a));
        System.out.println(lengthOfLISSimple(a));
        System.out.println(longestIncSubsequence(a,a.length));

    }

    //O(n^2) time complexity
    public static int longestIncSubsequence(int[] a, int n){
        int[] lis = new int[n];
        lis[0] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {

                if (a[i] > a[j] && lis[i] <= lis[j]) {

                    lis[i] = lis[j];
                }

            }
            lis[i] = 1 + lis[i];
        }
        return lis[n - 1];


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

    public static  int lengthOfLISSimple(int[] a) {
        int n =a.length;
        int len=1;
        int maxElement[]= new int[n];
        maxElement[0] = a[0];
        for(int i=1;i<n;i++){
            if(maxElement[0]>a[i]){
                maxElement[0] = a[i];
            }
            else if (maxElement[len-1]<a[i]){
                maxElement[len++] = a[i];
            }else{

                maxElement[binarySearch(0,len-1,a[i],maxElement)] = a[i];
            }


        }
        return len;
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
    private static int binarySearch(int start, int end, int value, int[] maxElement) {

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (maxElement[mid] >= value) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
