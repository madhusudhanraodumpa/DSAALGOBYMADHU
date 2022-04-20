package com.org.prep.recursion;

import java.util.ArrayList;
import java.util.List;

public class JosephusProblem {
    public static void main(String args[]){
        System.out.println();
        int n =5;
        int k =2;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(i+1);
        }
        System.out.println(findNotKilledMember(0,k-1,list));
    }
    public static int findNotKilledMember(int index, int k, List<Integer> list){
        if(list.size()==1){
            return list.get(0);
        }
        index =(index+k)%list.size();
        list.remove(index);
       return findNotKilledMember(index,k,list);


    }
}
