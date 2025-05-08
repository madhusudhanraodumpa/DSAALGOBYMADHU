package com.org.prep.linkedlist;

public class LFUCacheTest {
    public static void main(String[] args) {

//        LFUCache lfuCache  = new LFUCache(2);
//        lfuCache.put(1,1);
//        lfuCache.put(2,2);
//
//
//        System.out.println(lfuCache.get(1));
//        lfuCache.put(3,3);
//
//        System.out.println(lfuCache.get(2));
//        System.out.println(lfuCache.get(3));
//
//        lfuCache.put(4,4);
//
//
//        System.out.println(lfuCache.get(1));
//        System.out.println(lfuCache.get(3));
//        System.out.println(lfuCache.get(4));

//        LFUCache lfuCache  = new LFUCache(3);
//        lfuCache.put(2, 2);
//        lfuCache.put(1, 1);
//        System.out.println(lfuCache.get(2));
//        System.out.println(lfuCache.get(1));
//        System.out.println(lfuCache.get(2));
//        lfuCache.put(3, 3);
//        lfuCache.put(4, 4);
//
//        System.out.println(lfuCache.get(3));
//        System.out.println(lfuCache.get(2));
//        System.out.println(lfuCache.get(1));
//        System.out.println(lfuCache.get(4));

        LFUCache lfuCache  = new LFUCache(10);
        lfuCache.put(10,13);
        lfuCache.put(3,17);

        lfuCache.put(6,11);
        lfuCache.put(10,5);

        lfuCache.put(9,10);
        System.out.println(lfuCache.get(13));


        lfuCache.put(2,19);
        System.out.println(lfuCache.get(2));
        System.out.println(lfuCache.get(3));

        lfuCache.put(5,25);
        System.out.println(lfuCache.get(8));
        lfuCache.put(9,22);

        lfuCache.put(5,5);

        lfuCache.put(1,30);
        System.out.println(lfuCache.get(11));

        lfuCache.put(9,12);
        System.out.println(lfuCache.get(7));
        System.out.println(lfuCache.get(5));
        System.out.println(lfuCache.get(8));
        System.out.println(lfuCache.get(9));

        lfuCache.put(4,30);
        lfuCache.put(9,3);
        System.out.println(lfuCache.get(9));
        System.out.println(lfuCache.get(10));
        System.out.println(lfuCache.get(10));

        lfuCache.put(6,14);
        lfuCache.put(3,1    );

        System.out.println(lfuCache.get(3));
        System.out.println(lfuCache.get(2));

        lfuCache.put(4, 3);


        System.out.println(lfuCache.get(2));
        System.out.println(lfuCache.get(3));
        System.out.println(lfuCache.get(4));

    }

}
