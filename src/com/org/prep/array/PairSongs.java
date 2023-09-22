package com.org.prep.array;

import java.util.*;

public class PairSongs {
    public static void main(String[] args){

        int[] a={30,20,150,100,40};
        numPairsDivisibleBy60(a);
    }


    public static int numPairsDivisibleBy60(int[] nums) {

        /**   int n=time.length;
         Map<Integer,Long> m= new HashMap<>();
         long count=0;

         for(int i=0;i<n;i++){

         int rem=time[i]%60;
         m.put(rem,m.getOrDefault(rem,0L)+1);
         }

         for(Integer key:m.keySet()){

         // int rem=time[i]%60;
         long x=m.get(key);
         if(key==0 || key*2==60){
         System.out.println(x);
         count=count+(long)((x-1)*x)/2;
         }
         if(key<30){
         long x2=m.getOrDefault((60-key),0L);
         count=count+(long)(x*x2);

         }
         }

         return (int)count;**/

        int n=nums.length;
        Map<Integer,Integer> m= new HashMap<>();
        int count=0;
        for(int i=0;i<n;i++){

            if(nums[i]%60==0){
                count=count+m.getOrDefault(nums[i]%60,0);
            }else{
                count=count+m.getOrDefault((nums[i]-(nums[i]%60)),0);
            }

            m.put(nums[i]%60,m.getOrDefault(nums[i]%60,0)+1);






        }
        return count;

    }

}
