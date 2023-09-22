package com.org.prep.backtracking;

import java.util.*;

public class CombinanationSumII {

    public static void main(String args[]){
        CombinanationSumII c=new CombinanationSumII();
        int a[]={1,1,1,2,2};
        c.combinationSum2(a,4);
    }


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        int n=candidates.length;
        Set<List<Integer>> list=new HashSet<>();
        List<Integer> l=new ArrayList<>();
        combinationSum2(candidates,target,0,list,l,n);
        List<List<Integer>> li=new ArrayList<>(list);
        return li;


    }



    public void combinationSum2(int[] a, int target,int index,Set<List<Integer>> list,List<Integer> l,int n) {

        if (target == 0) {
            list.add(new ArrayList < > (l));
            return;
        }

        for (int i = index; i < a.length; i++) {
            if (i > index && a[i] == a[i - 1]) continue;
            if (a[i] > target) break;

            l.add(a[i]);
            combinationSum2(a, target - a[i],i+1, list, l,n);
            l.remove(l.size() - 1);
        }




    }
}
