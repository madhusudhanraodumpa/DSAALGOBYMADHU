package com.org.prep.hash;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DiffkII {
    public static void main(String[] args){

        List<Integer> list=new ArrayList<>();
        list.add(0);
        //list.add(5);
        //list.add(3);
        diffPossible(list,0);
    }


    public static int diffPossible(final List<Integer> A, int B) {

        Set<Integer> set=new HashSet<>();
       // if(B==0) return 1;

        for(int i=0;i<A.size();i++){
            int a=A.get(i);
            int b=a-B;

            if(set.contains(b)){
                return 1;
            }else{
                set.add(a);
            }








        }

        return -1;

    }
}
