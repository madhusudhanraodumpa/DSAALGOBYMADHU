package com.org.prep.array;

import java.util.HashMap;
import java.util.Map;

public class ArrayDivisibleByPair {
public static void main(String[] args){

    int a[]={};
    long count=(long)(60000L*(60000L-1))/2;
    System.out.println(count);

    numPairsDivisibleBy60(a);

}





    public static int numPairsDivisibleBy60(int[] time) {

        int n=time.length;
        Map<Integer,Long> m= new HashMap<>();
        int count=0;

        for(int i=0;i<n;i++){

            int rem=time[i]%60;
            m.put(rem,m.getOrDefault(rem,0L)+1);
        }

        for(Integer key:m.keySet()){

            // int rem=time[i]%60;
            long x=m.get(key);
            if(key==0 || key*2==60){

                count=count+(int)((x-1)*x)/2;
            }
            if(key<30){
                long x2=m.getOrDefault((60-key),0L);
                count=count+(int)(x*x2);

            }
        }

        return count;

    }
}
