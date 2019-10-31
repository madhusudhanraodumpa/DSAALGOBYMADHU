package com.org.learnby.linkedlist;

import java.util.Arrays;

public class LinkedListOperations {
    public static void main(String args[]){

        LinkedList l=new LinkedList();
        int[] a={10,20,30,40,50};
        for(int i=0;i<a.length;i++) {
            l.insertAtEnd(a[i]);
           // l.insertBegging(a[i]);
        }
        /*l.deleteNodeByNumber(10);
        l.itterativeData();
        System.out.println();

        l.deleteNodeByNumber(50);
        l.itterativeData();
        System.out.println();

        l.deleteNodeByNumber(20);
        l.itterativeData();
        System.out.println();

        l.deleteNodeByNumber(30);
        l.itterativeData();
        System.out.println();

        l.deleteNodeByNumber(40);*/

       // l.deleteNodeByIndex(2);

       // System.out.println(l.searchANumber(70));
        l.reverseLinkedList();

       l.itterativeData();

       // l.recursiveData(l.getHead());



    }


}

