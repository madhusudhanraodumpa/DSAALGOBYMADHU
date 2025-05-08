package com.org.prep.binarysearch;

import java.util.*;

public class CountSmallerNum {
    public static void main(String[] args) {

    }

    public static List<Integer> countSmaller(int[] nums) {
        int n=nums.length;
        List<Integer> list=new ArrayList<>();
        List<Integer> tempList= new ArrayList<>();

        for(int i=0;i<n;i++){
            tempList.add(nums[i]);
        }
        for(int i=0;i<n;i++){
            int index=search(nums[i],tempList);
            list.add(index);
            tempList.remove(index);
        }
        return list;
    }
    public static int search(int a,List<Integer> tempList){
        int l=0;
        int h=tempList.size()-1;
        while(l<=h){
            int m=(l+h)/2;
            if(tempList.get(m)==a) return m;
            else if(tempList.get(m)<a) l=m+1;
            else h=m-1;

        }
        return 0;
    }
}
