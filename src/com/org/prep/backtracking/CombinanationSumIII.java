package com.org.prep.backtracking;

import java.util.*;

public class CombinanationSumIII {

    public static void main(String args[]){
        CombinanationSumIII c=new CombinanationSumIII();
        int a[]={1,1,1,2,2};
        c.combinationSum3(3,7);
    }


    public List<List<Integer>> combinationSum3(int k, int n) {


        List<List<Integer>> list=new ArrayList<>();
        List<Integer> l=new ArrayList<>();
        combinationSum3(k,n,list,l,1);
        return list;
    }


    public void combinationSum3(int k, int n,List<List<Integer>> list,List<Integer> l,int index) {


        if(k==0 && n==0){
            list.add(new ArrayList<>(l));
        }
        if(index>9) return;
        if(k<=0) return;


        l.add(index);
        combinationSum3(k-1,n-index,list,l,index+1);
        l.remove(l.size()-1);
        combinationSum3(k,n,list,l,index+1);





    }
}
