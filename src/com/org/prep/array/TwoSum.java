package com.org.prep.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {
    public static void main(String args[]){
        int[] a={3,2,4};

        System.out.println(twoSum1(a,6));
    }
    public static int[] twoSum(int[] a,int target){
        int[] res=new int[2];
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<a.length;i++){
            if(map.containsKey(a[i])){
                res[0]= map.get(a[i]);
                res[1]=i;
            }else{
                map.put(target-a[i],i);
            }



        }
        return res;





    }

    public static int[] twoSum1(int[] a, int target) {
        int n=a.length;
        Arrays.sort(a);
        int start=0;
        int end=n-1;
        int[] res=new int[2];
        while(start<n &&  end>=0){
            System.out.println("inside");
            int sum=a[start]+a[end];
            if(sum==target) {
                res[0]=start;
                res[1]=end;
            }
            if(sum>target) {
                end--;
            }else{
                start++;
            }

        }
        return res;

    }
}
