package com.org.prep.backtracking;
import java.util.*;
public class Combinations {

    public static void main(String[] args){
        Combinations c=new Combinations();

        c.combine(4,2);
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list =new ArrayList<>();
        List<Integer> l=new ArrayList<>();
        combination(n,0,l,list,k);
        return list;

    }


    public void combination(int n,int index,List<Integer> subset, List<List<Integer>> list,int k){
        if(index==n){
            if(subset.size()==k){
                list.add(new ArrayList<>(subset));
            }
            return;
        }
        subset.add(index+1);
        combination(n,index+1,subset,list,k);
        subset.remove(subset.size()-1);
        combination(n,index+1,subset,list,k);

    }
}
