package com.org.learnby.linkedlist;

public class LinkedList {
    public Node head;
    public Node insertFirst(int data){

        Node currentNode=new Node(data);
        currentNode.next=head;
        head=currentNode;
        return currentNode;
    }

    public void printList(){
        Node temp=head;
        while(temp!=null){
            System.out.println(temp.data);
            temp=temp.next;
        }
    }

}
class Node{
    int data;
    Node next;
    public Node(int data){
        this.data=data;
        next=null;
    }
}
