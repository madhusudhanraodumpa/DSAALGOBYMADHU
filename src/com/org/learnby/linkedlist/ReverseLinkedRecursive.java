package com.org.learnby.linkedlist;

public class ReverseLinkedRecursive {
    //public static Node head=null;
    public static void main(String args[]){
        Node n=new Node(1);
        n.next=new Node(2);
        n.next.next=new Node(3);
        n.next.next.next=new Node(3);
        n.next.next.next.next=new Node(4);
        n.next.next.next.next.next=new Node(4);
        n.next.next.next.next.next.next=new Node(5);
      //  Node temp=reverseListTemp(n);
       // itterativeData(n);
       // itterativeData(temp);
        Node temp = deleteDuplicates1(n);

        itterativeData(temp);

    }


    public static Node deleteDuplicates1(Node head) {
        if(head==null || head.next==null) return head;
        Node dummy=new Node(-1);
        dummy.next=head;
        Node itr=dummy;
        Node current=head.next;

        while(current!=null){

            boolean flagDup=false;
            while(current!=null && itr.next.data==current.data){
                flagDup=true;
                current=current.next;
            }

            if(flagDup){
                itr.next=current;
            }else{
                itr=itr.next;
            }

            if(current!=null){
                current=current.next;
            }


        }


        return dummy.next;
    }

    public static Node deleteDuplicates(Node head) {
        if(head==null||head.next==null) return head;
        Node h1=head;
        Node h2=head.next;

        while(h2!=null){
            if(h1.data!=h2.data){
                h1.next=h2;
                h1=h1.next;
            }

            h2=h2.next;
        }
       // h1.next=h2;
        return head;
    }

    public static Node reverseBetween(Node head, int left, int right) {
        if(head==null || head.next==null) return head;
        Node h=head;
        Node h1=head;
        int k=left-1;
        Node t=head;
        while(h1!=null && k>0){
            t=h1;
            h1=h1.next;
            k--;
        }
        Node h2=h1;
        Node h3=h1;
        Node p=null;
        Node temp=h1;
        k=right-left+1;

        while(h2!=null && k>0){

            h2=h2.next;
            temp.next=p;
            p=temp;
            temp=h2;
            k--;

        }
        t.next=p;
        h3.next=h2;


        return t;



    }

    public static Node removeNthFromEnd(Node head, int n) {
        Node t1=head;
        Node t2=head;
        while(t1!=null && n>0){
            t1=t1.next;
            n--;
        }
        Node p=null;
        while(t1!=null){
            p=t2;
            t2=t2.next;

            t1=t1.next;
        }
        if(p!=null && t2!=null){
            p.next=t2.next;
        }
        return head;

    }
    public static Node reverseListTemp(Node node) {
        if(node==null) return node;
        if(node.next==null) {
            return node;
        }

        Node t=reverseListTemp(node.next);
        t.next=node;
        node.next=null;
        return node;





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
