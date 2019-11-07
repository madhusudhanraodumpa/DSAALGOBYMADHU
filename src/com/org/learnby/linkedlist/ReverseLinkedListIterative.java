package com.org.learnby.linkedlist;

public class ReverseLinkedListIterative {

    //public static Node head=null;
    public static void main(String args[]){
        Node n=new Node(10);
        n.next=new Node(20);
        n.next.next=new Node(30);
        n.next.next.next=new Node(40);
        n.next.next.next.next=new Node(50);
        Node temp=reverseLinkedIterative(n);
        // itterativeData(n);
        itterativeData(temp);


    }

    public static Node reverseLinkedIterative(Node node){
        Node current=node;
        Node previous=null;
        Node next=null;

        while(current!=null){
            next=current.next;
            current.next=previous;
            previous=current;
            current=next;
        }

        node=previous;
        return node;
    }

    public static void itterativeData(Node node){
        Node temp=node;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;

        }
        System.out.println();

    }
}
