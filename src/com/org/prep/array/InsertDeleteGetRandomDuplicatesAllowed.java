package com.org.prep.array;

import java.util.*;

public class InsertDeleteGetRandomDuplicatesAllowed {
    public static void main(String args[]){
        RandomizedCollection randomizedCollection=new RandomizedCollection();
        System.out.println(randomizedCollection.insert(1));
        System.out.println(randomizedCollection.insert(1));
        System.out.println(randomizedCollection.insert(2));
        System.out.println(randomizedCollection.insert(1));
        System.out.println(randomizedCollection.insert(2));
        System.out.println(randomizedCollection.insert(2));
        System.out.println(randomizedCollection.remove(1));
        System.out.println(randomizedCollection.remove(2));
        System.out.println(randomizedCollection.remove(2));
        System.out.println(randomizedCollection.remove(2));
        System.out.println(randomizedCollection.getRandom());


    }
}
class RandomizedCollection {
    List<Integer> list;
    Map<Integer, Set<Integer>> map;
    Random random;

    public RandomizedCollection() {
        list=new ArrayList<>();
        map=new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        Set<Integer> set=null;
        boolean flag=false;
        if(map.containsKey(val)){
            set=map.get(val);
            flag=false;
        }else{
            set=new HashSet<>();
            flag=true;
        }
        set.add(list.size());
        list.add(val);
        map.put(val,set);
        return flag;

    }

    public boolean remove(int val) {

        if(!map.containsKey(val)){
            return false;
        }else{
            Set<Integer> set=map.get(val);
            int removeIndex=-1;

            for(int i:set){
                removeIndex=i;
                break;
            }
            set.remove(removeIndex);


            map.put(val,set);

            if(map.get(val).size()==0){
                map.remove(val);
            }

            int listVal=list.get(list.size()-1);
            list.set(removeIndex,listVal);

            Set<Integer> temp=map.get(listVal);
            if(temp!=null){
                temp.remove(list.size()-1);
                temp.add(removeIndex);
                map.put(listVal,temp);
            }

            list.remove(list.size()-1);





        }
        return true;


    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}