package com.org.prep.bits;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SubSets {
    public static void main(String args[]){
        int a[]={1,2,3};
        subSets(3,a);

    }

    public static LinkedList<LinkedList<Integer>> subSets(int n,int[] a){

            LinkedList<LinkedList<Integer>> list=new LinkedList<>();
            for(int i=0;i<(1<<n);i++){
                LinkedList<Integer> l=new LinkedList<>();
                for(int j=0;j<n;j++){
                    if(((i>>j)&1)==1){
                        l.addLast(a[j]);
                    }
                }
                list.add(l);
            }
            return list;
    }
}
