package com.org.prep.list;

public class Test {
    public static void main(String[] args){
        LRU lru=new LRU(    1);
        lru.put(2,1);

        System.out.println(lru.get(2));


    }
}
