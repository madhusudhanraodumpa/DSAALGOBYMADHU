package com.org.learnby.linkedlist;

public class LinkedList {
    private Node head=null;



    public Node getHead() {
        return head;
    }

    public void insertAtEnd(int data){
        Node node=new Node(data);
        if(head==null){
            head=node;
        }else{
            Node temp=head;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=node;

        }


    }
    public void insertBegging(int data){
        Node node=new Node(data);
        if(head==null){
            head=node;
        }else{
            node.next=head;
            head=node;
           }


    }
    public boolean searchANumber(int data){
        Node temp=head;
        while(temp!=null){
            if(temp.data==data){
                return true;
            }
            temp=temp.next;
        }
        return false;
    }

    public void deleteNodeByNumber(int data){
        Node temp=head;
        Node previous=null;
        while(temp!=null){
            if(temp.data==data){
                if(previous!=null) {
                    previous.next = temp.next;
                }else{
                    head=head.next;
                }
                break;
            }
            previous=temp;
            temp=temp.next;
        }


    }
    public void deleteNodeByIndex(int index){
        Node temp=head;
        Node previous=null;
        int n=0;
        while(temp!=null){
            if(index==n){
                if(previous==null){
                    head=head.next;
                }else{
                    previous.next=temp.next;
                }
                break;
            }
            n++;
            previous=temp;
            temp=temp.next;
        }



    }
    public void reverseLinkedList(){
        Node temp=head;
        Node current=head;
        Node previous=null;
        while(current!=null){
            temp=temp.next;
            current.next=previous;
            previous=current;
            current=temp;
        }
        head=previous;
    }

    public Node reverseRecursive(Node node){

        if(node==null){
            return null;
        }
        if(node.next==null){
            head=node;
            return node;
        }

        Node temp=reverseRecursive(node.next);
        temp.next=node;
        node.next=null;
        return node;
    }

    public Node reverseRecursiveByP(Node node){

        if(node==null){
            return node;
        }
        if(node.next==null){
            return node;
        }

        Node temp=reverseRecursiveByP(node.next);
        node.next.next=node;
        node.next=null;
        return temp;
    }

    public void itterativeData(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }

    }

    public void recursiveData(Node node){
        if(node==null){
            return;
        }
        System.out.print(node.data+" ");
        recursiveData(node.next);

    }


}
