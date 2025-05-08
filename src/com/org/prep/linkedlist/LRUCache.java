package com.org.prep.linkedlist;

import java.util.*;

public class LRUCache {

//    private int capacity;
//    private ListNode1 dummy;
//    private ListNode1 head;
//
//    private ListNode1 last;
//
//    private Map<Integer,ListNode1> map;
//    private Map<Integer,Integer> res;
//
//    public LRUCache(int capacity) {
//        this.capacity=capacity;
//        this.dummy=new ListNode1(-1);
//        this.map=new HashMap<>();
//        this.res=new HashMap<>();
//        this.head=dummy;
//        this.last=dummy;
//    }
//
//    public int get(int key) {
//        ListNode1 T=search(key);
//        if(T==null){
//            return -1;
//        }else{
//            if(T.next!=null){
//
//                remove(T);
//                insertBack(T);
//            }
//
//        }
//        return this.res.get(key);
//
//    }
//
//    public void put(int key, int value) {
//
//        ListNode1 T=search(key);
//        this.res.put(key,value);
//
//        if(T==null){//miss
//            T=new ListNode1(key);
//            this.map.put(key,T);
//
//            if(this.map.size()>this.capacity){
//                this.map.remove(this.head.next.val);
//
//                remove(this.head.next);
//                insertBack(T);
//            }else{
//                insertBack(T);
//            }
//
//
//
//        }else{//hit
//            if(T.next!=null){
//                remove(T);
//                insertBack(T);
//            }
//
//
//        }
//
//
//    }
//    public void remove(ListNode1 T){
//        if(T.next==null){
//            this.dummy.next=T;
//        }else {
//            T.prev.next = T.next;
//            T.next.prev = T.prev;
//        }
//
//    }
//    public void insertBack(ListNode1 T){
//        this.last.next=T;
//        T.next=null;
//        T.prev=last;
//        last=T;
//
//    }
//    public ListNode1 search(int key){
//        return  this.map.get(key);
//    }
}
//class ListNode1{
//    int val;
//    ListNode1 next;
//    ListNode prev;
//    public ListNode1(int val){
//        this.val=val;
//        this.next=null;
//        this.prev=null;
//    }
//}
