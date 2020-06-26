package com.org.leetcode.arrays;

import java.util.*;

public class ThreeSum {
    public static void main(String args[]){
        int a[]={3,0,-2,-1,1,2};
        List<List<Integer>> tripletList=threeSumOpt(a);
        for(List<Integer> list:tripletList){
            for(Integer i:list){
                System.out.print(i+" ");
            }
            System.out.println();
        }
        System.out.println();
        tripletList=threeSumUsingHash(a);
        for(List<Integer> list:tripletList){
            for(Integer i:list){
                System.out.print(i+" ");
            }
            System.out.println();
        }

        System.out.println();
        tripletList=threeSum(a);
        for(List<Integer> list:tripletList){
            for(Integer i:list){
                System.out.print(i+" ");
            }
            System.out.println();
        }

    }

    private static List<List<Integer>> threeSum(int[] a) {

        List<List<Integer>> array = new ArrayList<List<Integer>>();
        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < a.length - 2; i++) {
            for (int j = i + 1; j < a.length - 1; j++) {
                for (int c = j + 1; c < a.length; c++) {

                    if (a[i] + a[j] + a[c] == 0) {
                        List<Integer> subArray = new ArrayList<>();
                        subArray.add(a[i]);
                        subArray.add(a[j]);
                        subArray.add(a[c]);
                        Collections.sort(subArray);
                        set.add(subArray);

                    }
                }
            }
        }
        array.addAll(set);
        return array;
    }
    private static List<List<Integer>> threeSumUsingHash(int[] a) {
        List<List<Integer>> array = new ArrayList<List<Integer>>();
        Set<List<Integer>> set1 = new HashSet<>();

        for(int i=0;i<a.length-1;i++){
            Set<Integer> set=new HashSet<>();
            for(int j=i+1;j<a.length;j++){

                int value= -(a[i]+a[j]);
                if(set.contains(value)){
                    List<Integer> list=new ArrayList<>();
                    list.add(value);
                    list.add(a[i]);
                    list.add(a[j]);
                    Collections.sort(list);
                    set1.add(list);
                }else{
                    set.add(a[j]);
                }

            }
        }
        array.addAll(set1);
        return array;
    }
    private static List<List<Integer>> threeSumOpt(int[] a) {
        List<List<Integer>> array = new ArrayList<List<Integer>>();
        Set<List<Integer>> set1 = new HashSet<>();
        Arrays.sort(a);
        for(int i=0;i<a.length-2;i++){
            int reuried_value=-a[i];
            int l=i+1;
            int r=a.length-1;
            while(l<r){
                int value=a[l]+a[r];
                if(value==reuried_value){
                    List<Integer> list=new ArrayList<>();
                       list.add(a[i]);
                       list.add(a[l]);
                       list.add(a[r]);
                       array.add(list);
                       l++;
                       r--;
                }else if(value>reuried_value){
                    r--;
                }else{
                    l++;
                }

            }
        }
        return array;
    }
    }
