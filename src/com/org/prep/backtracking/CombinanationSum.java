package com.org.prep.backtracking;
import java.util.*;

public class CombinanationSum {

    public static void main(String args[]){
        CombinanationSum c=new CombinanationSum();
        int a[]={};
        c.combinationSum(a,0);
    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        int n=candidates.length;
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> l=new ArrayList<>();
        combinationSum(candidates,target,n,list,l);

        return list;
    }

    public void combinationSum(int[] a,int target,int n,List<List<Integer>> list,List<Integer> l){

        if(target<=0){

            if(target==0){
                list.add(new ArrayList<>(l));
            }
            return;
        }





        for(int i=0;i<n;i++){
            l.add(a[i]);
            combinationSum(a,target-a[i],n,list,l);
            target=target+a[i];
            l.remove(l.size()-1);
        }



    }
}
