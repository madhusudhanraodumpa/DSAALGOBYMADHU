package com.org.prep.array;

import java.util.*;

public class ThreeSum {

    public static void main(String args[]){

        int[] a={-1,0,1,2,-1,-4};
        System.out.println(threeSum(a));

    }

    private  static List<List<Integer>> threeSum1(int[]a){
        List<List<Integer>> array = new ArrayList<List<Integer>>();
        Set<List<Integer>> set1 = new HashSet<>();
        Arrays.sort(a);
        for(int i=0;i<a.length-2;i++){
            int reuried_value=-a[i];
            if(i!=0 && a[i]==a[i-1]){
                continue;
            }
            int l=i+1;
            int r=a.length-1;
            while(l<r){
                int value=a[l]+a[r];
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


    // this will work for only positive integers
    public static List<List<Integer>> threeSum(int[] a) {
        List<List<Integer>> array = new ArrayList<>();
        Set<List<Integer>> set1 = new HashSet<>();
                Arrays.sort(a);
                int n=a.length;
        for(int i=0;i<n-1;i++){
            int reuried_value=-a[i];
            if(i!=0 && a[i]==a[i-1]){
                continue;
            }

            List<List<Integer>> l=twoSum(a,reuried_value,i+1,n-1);
            for(List list:l){
                list.add(a[i]);
                set1.add(list);

            }
        }
        array.addAll(set1);
        return array;
    }


    private static List<List<Integer>> twoSum(int[] a, int target,int left,int right) {


        List<List<Integer>> l=new ArrayList<>();

        while(left<right){


            int sum=a[left]+a[right];
            if(sum==target){
                List<Integer> list=new ArrayList<>();
                list.add(a[left]);
                list.add(a[right]);
                left++;
                right--;
                l.add(list);
            }else if(sum>target){
                right--;
            }else{
                left++;
            }




        }
        return l;
    }

}
