package com.org.prep.list;
import java.util.*;

public class LRU {
    int capacity;
    Map<Integer,Node> map;
    //  Node dummy=new Node(-1);
    Node last=null;
    Node head=null;

    public LRU(int capacity) {
        map=new HashMap<>();
        this.capacity=capacity;
        //    this.dummy=new Node(-1);
    }

    public void addNode(Node node) {
        if (head == null) head = last = node;
        else {
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    void removeNode(Node node) {
        if (node == head && node == last) head = last = null;
        else if (node == head) head = head.next;
        else if (node == last) last = last.prev;
        else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        node.next = node.prev = null;
    }

    public void moveToHead(Node node) {
        removeNode(node);
        addNode(node);
    }

    public Node getLast() {
        return last;
    }


    public int get(int key) {
        Node node = map.get(key);
        if (node == null) return -1;
        //  doublyLinkedList.moveToHead(node);
        removeNode(node);
        addNode(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.value = value;
            //doublyLinkedList.moveToHead(node);
            removeNode(node);
            addNode(node);
        }
        else {
            if (map.size() == capacity) {
                Node last = getLast(); // LRU element
                //doublyLinkedList.removeNode(last);
                removeNode(last);
                addNode(last);
                map.remove(last.key);
            }
            node = new Node(key, value);
            addNode(node);
            map.put(key, node);
        }




    }
}
class Node{
    int value;
    Node next;
    Node prev;
    int key;
    public Node(int value,int key){
        this.value=value;
        this.next=null;
        this.prev=null;
        this.key=key;
    }
}
