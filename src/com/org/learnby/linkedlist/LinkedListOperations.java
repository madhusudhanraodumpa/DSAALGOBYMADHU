package com.org.learnby.linkedlist;

import java.util.Arrays;

public class LinkedListOperations {
    public static void main(String args[]){

        LinkedList l=new LinkedList();
        int[] a={1,2,3,4};
        for(int i=0;i<a.length;i++) {
            l.insertAtEnd(a[i]);
           // l.insertBegging(a[i]);
        }

       l.swapPairs(l.getHead());
        l.itterativeData();
















      /*  LinkedList l1=new LinkedList();
        int[] b={5,6,4};
        for(int i=0;i<b.length;i++) {
            l1.insertAtEnd(b[i]);
            // l.insertBegging(a[i]);
        }

        Node node=l.addTwoNumbers(l.getHead(),l1.getHead());
*/
    //    l.nextGreaterNode(l.getHead());
    /* l.removeNthFromEnd(l.getHead(),2);
        l.itterativeData();*/
        //l.itterativeData();
     //  l.deleteNode(3);
       // l.itterativeData();
      /*  Node node=l.reverseList(l.getHead());
        l.setHead(node);
        l.itterativeData();*/


      // l.getHead().next.next.next.next.next.next=l.getHead().next.next;
     /*   System.out.println("*************");
        System.out.println(l.detectLoop(l.getHead()));
        l.detectLoop1(l.getHead());
        l.itterativeData();*/
       // l.itterativeData();
        /*LinkedList l2=new LinkedList();

        int[] b={10,15,30};
        for(int i=0;i<b.length;i++) {
            l2.insertAtEnd(b[i]);
            // l.insertBegging(a[i]);
        }
        System.out.println(l.getInterSectionNode(l.getHead(),l2.getHead()));
*/


     /*   l.itterativeData();
        System.out.println();
        System.out.println(l.isPalindrom(l.getHead(),l.getHead()));
       // l.reverseRecursiveTemp(l.getHead());
       // l.reverseRecursiveTemp(l.getHead());
        l.recursiveData(l.getHead());*/
/*System.out.println();
        l.deleteFirest();
        l.itterativeData();
        System.out.println();
        l.deleteLast();*/
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
       // l.reverseLinkedl.reverseRecursiveByP(l.getHead());
    //   l.itterativeData();

       // l.recursiveData(l.getHead());
      //  l.reverseRecursive(l.getHead());



    }


}

