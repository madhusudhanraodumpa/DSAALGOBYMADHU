package com.org.prep.array;

import java.util.*;

public class InsertDeleteRandom {
    public static void main(String args[]){
        RandomizedSet randomizedSet=new RandomizedSet();
       // System.out.println(randomizedSet.insert(1));
      //  System.out.println(randomizedSet.remove(0));
        //System.out.println(randomizedSet.remove(0));
        System.out.println(randomizedSet.insert(0));
        System.out.println(randomizedSet.insert(1));System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.insert(3));
        System.out.println(randomizedSet.insert(4));

       // System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.remove(0));
        //System.out.println(randomizedSet.insert(-1));
        System.out.println(randomizedSet.remove(1));
        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.getRandom());System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.getRandom());System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.getRandom());





    }
}

class RandomizedSet {
    List<Integer> list;
    Map<Integer,Integer> map;
    Random random;

    public RandomizedSet() {
        list=new ArrayList<>();
        map=new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        list.add(val);
        map.put(val,list.size()-1);
        return true;


    }

    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }

        int x=map.get(val);
        int y=list.get(list.size()-1);
        list.set(x,y);
        map.remove(val);
        if(map.size()==0){
            list=new ArrayList<>();
        }
        if(map.containsKey(y)) {
            map.put(y, x);
        }



        return true;

    }

    public int getRandom() {
        return list.get(random.nextInt(map.size()));
    }
}

