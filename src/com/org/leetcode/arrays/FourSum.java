package com.org.leetcode.arrays;

import java.util.*;

public class FourSum {
    public static void main(String args[]) {
        int a[] = {1, 0, -1, 0, -2, 2};
        List<List<Integer>> tripletList = fourSum(a,0);
        for (List<Integer> list : tripletList) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    private static List<List<Integer>> fourSum(int[] a, int target) {
        List<List<Integer>> array = new ArrayList<List<Integer>>();
        Set<List<Integer>> set1 = new HashSet<>();
        Arrays.sort(a);
        for(int i=0;i<a.length-3;i++){
            for(int j=i+1;j<a.length-2;j++){
                int l=j+1;
                int r=a.length-1;
                int requriedValue=target-a[i]-a[j];

                while(l<r){
                    int value=a[l]+a[r];
                    if(value==requriedValue){
                        List<Integer> list=new ArrayList<>();
                        list.add(a[l]);
                        list.add(a[r]);
                        list.add(a[i]);
                        list.add(a[j]);
                        Collections.sort(list);
                        set1.add(list);
                        l++;
                        r--;
                    }else if(value>requriedValue){
                        r--;
                    }else{
                        l++;
                    }

                }



            }
        }


        array.addAll(set1);
        return array;
    }
}
