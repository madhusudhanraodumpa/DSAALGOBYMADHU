package com.org.prep.array;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {
    public static void main(String args[]){
        int[] a={2,7,11,15};

        System.out.println(twoSum(a,9));
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
}
