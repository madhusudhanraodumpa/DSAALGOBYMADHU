package com.org.prep.array;

import java.util.*;

public class FourSum {
    public static void main(String args[]){
        int[] a={1000000000,1000000000,1000000000,1000000000};
        fourSum(a,-294967296);
        if(Integer.MAX_VALUE==-294967296){
            System.out.println("yes");
        }
    }


    public static List<List<Integer>> fourSum(int[] a, int target) {
        List<List<Integer>> array = new ArrayList<>();
        Set<List<Integer>> set1 = new HashSet<>();
        Arrays.sort(a);
        int n=a.length;

        for(int i=0;i<n-1;i++){
            long reuried_value=target-a[i];
            if(i!=0 && a[i]==a[i-1]){
                continue;
            }

            List<List<Integer>> l=threeSum(a,reuried_value,i+1,n-1);
            for(List list:l){
                list.add(a[i]);
                set1.add(list);

            }
        }
        array.addAll(set1);
        return array;

    }




    public static List<List<Integer>> threeSum(int[] a,long target,int left,int right) {
        List<List<Integer>> array = new ArrayList<List<Integer>>();
        Set<List<Integer>> set1 = new HashSet<>();
        //  Arrays.sort(a);
        for(int i=left;i<right;i++){
            long reuried_value=target-a[i];
            /*if(i!=0 && a[i]==a[i-1]){
                continue;
            }*/
            int l=i+1;
            int r=a.length-1;
            while(l<r){
                long value=a[l]+a[r];
                if(value==reuried_value){
                    List<Integer> list=new ArrayList<>();
                    list.add(a[i]);
                    list.add(a[l]);
                    list.add(a[r]);
                    set1.add(list);
                    l++;
                    r--;

                }else if(value>reuried_value){
                    r--;
                }else{
                    l++;
                }

            }
        }
        array.addAll(set1);
        return array;
    }
}
