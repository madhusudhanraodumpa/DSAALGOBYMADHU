package com.org.learnby.linkedlist;

public class ReverseLinkedRecursive {
    //public static Node head=null;
    public static void main(String args[]){
        Node n=new Node(10);
        n.next=new Node(20);
        n.next.next=new Node(30);
        n.next.next.next=new Node(40);
        n.next.next.next.next=new Node(50);
        Node temp=reverseLinkedRecursive(n);
       // itterativeData(n);
        itterativeData(temp);


    }

    public static Node reverseLinkedRecursive(Node node){
        if(node==null){
            return node;
        }
        if(node.next==null){
            return node;
        }

        Node temp=reverseLinkedRecursive(node.next);
        node.next.next=node;
        node.next=null;
        return temp;
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
