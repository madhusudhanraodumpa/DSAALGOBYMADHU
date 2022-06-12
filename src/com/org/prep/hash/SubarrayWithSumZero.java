package com.org.prep.hash;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubarrayWithSumZero {

    public static void main(String[] args){

        ArrayList<Integer> list=new ArrayList<>();
        list.add(-1);
        list.add(1);
        solve(list);
    }

    public static int solve(ArrayList<Integer> A) {

        int[] pf=new int[A.size()];
        Set<Long> set=new HashSet<>();
        //pf[0]=A.get(0);
        //set.add(A.get(0));
        long sum=0;

        for(int i=0;i<A.size();i++){
            sum=sum+A.get(i);
            if(set.contains(sum)){
                return 1;
            }else{
                set.add(sum);
            }

        }
        return set.contains(0)?1:0;
    }
}
