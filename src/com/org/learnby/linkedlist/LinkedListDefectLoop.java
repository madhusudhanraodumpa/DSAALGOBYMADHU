package com.org.learnby.linkedlist;

public class LinkedListDefectLoop {

    public static void main(String args[]){
        LinkedList l1=new LinkedList();
        Node node1=l1.insertFirst(10);
        Node node2=l1.insertFirst(20);
        Node node3=l1.insertFirst(30);
        Node node4=l1.insertFirst(40);
        Node node5=l1.insertFirst(50);
        node5.next=node3;



        l1.printList();
    }
}
