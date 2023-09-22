package com.org.prep.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetTesting {
    public static void main(String args[]) {

        Set<List<Integer>> set = new HashSet<>();

        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(-2);
        list.add(0);
        set.add(list);
        list=new ArrayList<>();
        list.add(2);
        list.add(-2);
        list.add(0);
        set.add(list);
        System.out.println(set.size());
    }

}
