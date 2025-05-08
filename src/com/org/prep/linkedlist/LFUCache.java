package com.org.prep.linkedlist;

import java.util.*;

public class LFUCache {
    int capacity;
    Map<Integer, ListNode> nodeMap;
    Map<Integer, DoubleLinkedList> freqMap;
    int leastFreq;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.leastFreq = 1;
        this.nodeMap = new HashMap<>();
        this.freqMap = new HashMap<>();

    }

    public int get(int key) {
        ListNode T = search(key);
        if(T==null){
            return -1;
        }else{
            int curFreq=T.freq;
            DoubleLinkedList list = freqMap.get(curFreq);
            if(T.next!=null) {
                list.remove(T);
            }else{
                list.lastSize--;
            }
            if (curFreq == leastFreq && list.lastSize==0) {
                leastFreq++;
                freqMap.remove(curFreq);
            }
            T.freq++;
            DoubleLinkedList newList = freqMap.getOrDefault(T.freq, new DoubleLinkedList());
            newList.addLast(T);
            freqMap.put(T.freq, newList);

        }
        return T.val;

    }

    public void put(int key, int value) {
        ListNode T = search(key);
        if (T == null) {//cache miss
            T = new ListNode(key, value);
            this.nodeMap.put(key, T);
            if (this.nodeMap.size() > this.capacity) {
                DoubleLinkedList list = freqMap.getOrDefault(leastFreq, new DoubleLinkedList());
                if(list.head.next==null){
                    freqMap.remove(leastFreq);
                }
                if(list.head.next!=null){
                    this.nodeMap.remove(list.head.next.key);
                    list.remove(list.head.next);
                }

                DoubleLinkedList curList = freqMap.getOrDefault(1, new DoubleLinkedList());

                curList.addLast(T);
                freqMap.put(1, curList);
                leastFreq=1;


            } else {
                DoubleLinkedList list = freqMap.getOrDefault(1, new DoubleLinkedList());
                list.addLast(T);
                freqMap.put(1, list);
                leastFreq=1;
            }

        } else {//cache hit
            T.val=value;
            int curFreq=T.freq;
            DoubleLinkedList list = freqMap.get(curFreq);
            if(T.next!=null) {
                list.remove(T);
            }
            if (curFreq == leastFreq ) {
                leastFreq++;
                freqMap.remove(curFreq);
            }
            T.freq++;
            DoubleLinkedList newList = freqMap.getOrDefault(T.freq, new DoubleLinkedList());
            newList.addLast(T);
            freqMap.put(T.freq, newList);
        }

    }

    public ListNode search(int key) {
        return this.nodeMap.get(key);
    }

}
class ListNode {
    int key;
    int val;
    int freq;
    ListNode next;
    ListNode prev;

    public ListNode(int key, int val) {
        this.val = val;
        this.next = null;
        this.prev = null;
        this.key = key;
        this.freq = 1;
    }
}

class DoubleLinkedList {
    int lastSize;
    ListNode head;
    ListNode last;
    ListNode dummy;

    public DoubleLinkedList() {
        this.dummy = new ListNode(-1, -1);
        this.head = dummy;
        this.last = dummy;
    }

    public void addLast(ListNode node) {
        this.last.next = node;
        node.next = null;
        node.prev = last;
        last = node;
    }

    public void remove(ListNode node) {
        if (node.next == null) {
            this.dummy.next=null;
            this.dummy.prev=null;
            this.head=dummy;
            this.last=dummy;

        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

    }

}

